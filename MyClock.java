import java.awt.Color;
import java.awt.Dimension;//确定一个对象尺寸的包
import java.awt.Font;//封装字体的包
import java.awt.Graphics;
import java.awt.Graphics2D;//绘制2D图像的包
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;//获取当前系统时间的包
import javax.swing.JFrame;
 
public class MyClock extends JFrame implements Runnable//通过实现Rannnable接口创建线程
{
  Thread clock;//需要申明一个Thread对象
  final int Xpoint=180;
  final int Ypoint=180;
  final int R=80;
  int xHour=0, yHour=0, xSecond=0, ySecond=0, xMinute=0, yMinute=0;
  public MyClock()//通过构造函数创建所需组件
  {
  	 super("我的时钟"); //调用父类构造函数
     setFont(new Font("楷体",Font.BOLD,24)); //设置日期的显示字体（分别表示字体、样式、字号）
     start(); //启动线程对象的方法
     setSize(360,360);  //设置窗口大小
     setVisible(true);  //设置窗口可视
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口是退出虚拟机 
  }

 public void run()//定义线程的操作，即要实现的功能
 { 
   while (clock!=null)
   {
      repaint(); //，paint是系统回调方法，调用paint方法重绘界面
      try
      {
        Thread.sleep(1000);  //线程暂停一秒(1000毫秒)，让其他线程有机会运行
      }
      catch (InterruptedException ex)
      {
        ex.printStackTrace();  //输出出错信息
      }
   }
 }
 
 public void start()
 {  
   if(clock==null)
   {
      clock=new Thread(this); //实例化进程
      clock.start(); //启动线程
   }
 }
 
 public void stop()//停止进程
 { 
   clock=null;
 }
 
 public void paint(Graphics g) //重载组件的paint方法
 { 
 	 //String head="monday tuesday wendesday thursday friday saturday sunday";
 	 //g.setColor(Color.black);  //设置当前时间颜色
   //g.drawString(head,30,40);  //显示时间字符串及其字号大小
   
   Graphics2D g2 = (Graphics2D)g; //得到Graphics2D对象,并创建Graphics的引用（下面用g就相当于用g，两个对象等同）
   DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
 //日期格式，精确到日
   Calendar now = new GregorianCalendar(); //实例化类对象now
   now.setTime(new Date()); //dateFormat.format(now.getTime())，设置当前系统时间
   int hour = now.get(Calendar.HOUR_OF_DAY); //得到时
   int minute = now.get(Calendar.MINUTE);   //得到分
   int second = now.get(Calendar.SECOND);  //得到秒
   
   //设置背景
   g.setColor(Color.white);  //白色背景为了让黑点显示出来
   Dimension dim = getSize();  //得到窗口尺寸
   g.fillRect(0,0,dim.width,dim.height);  //以白色填一个矩形。即线程启动一次填充一次，才不会让上次所执行的操作留下残余
   
   //设置日期
   g.setColor(Color.orange); //颜色
   g.drawString(dateFormat.format(now.getTime()),20,60); //显示日期字符串及其字号大小
   
   //设置时间
   String time = "";
   if (hour<=9) time+="0"+hour+":"; //格式化输出
   else time+=hour+":";
   if (minute<=9) time+="0"+minute+":";
   else time+=minute+":";
   if (second<=9) time+="0"+second;
   else time+=second;
   g.setColor(Color.black);  //颜色
   g.drawString(time,130,340);  //显示时间字符串及其字号大小    
   g.setFont(new Font("楷体",Font.BOLD,15));//设置时钟的显示字体及字号大小
   
   //设置时钟
   for(int i=0,num=0; i<360; i+=6)//每循环一次，度数加6（每秒钟之间角度为6度）
   { 
     double angle = Math.toRadians(i); //求得以弧度为单位的角度
     int xPos=Xpoint+(int)(R*Math.sin(angle));
     int yPos=Ypoint-(int)(R*Math.cos(angle));
     //画表盘
     if(i%30==0){
	     if(num==0){
		     num=12;
		     g.setColor(Color.red);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=1;
	     }
	     else if(num==1){
		     g.setColor(Color.pink);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=2;
	     }
	     else if(num==2){
		     g.setColor(Color.magenta);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=3;
	     }
	     else if(num==3){
		     g.setColor(Color.red);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=4;
	     }
	     else if(num==4){
		     g.setColor(Color.pink);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=5;
	     }
	     else if(num==5){
		     g.setColor(Color.magenta);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=6;
	     }
	     else if(num==6){
		     g.setColor(Color.red);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=7;
	     }
	     else if(num==7){
		     g.setColor(Color.pink);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=8;
	     }
	     else if(num==8){
		     g.setColor(Color.magenta);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=9;
	     }
	     else if(num==9){
		     g.setColor(Color.red);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=10;
	     }
	     else if(num==10){
		     g.setColor(Color.pink);
		     g.drawString(""+num, xPos-5,yPos+3);
		     num=11;
	     }
	     else if(num==11){
		     g.setColor(Color.magenta);
		     g.drawString(""+num, xPos-5,yPos+3);
	     }
     }
     else{ 
       g.setColor(Color.gray);
       g.drawString("*",xPos,yPos);
     }
    }
    //画实心点，半径为8
 		g.setColor(Color.black); 
 		g.fillOval(Xpoint-4,Ypoint-4,8,8);
 		//画秒针
    xSecond=(int)(Xpoint+(R-10)*Math.sin(second*(2*Math.PI/60)));
    ySecond=(int)(Ypoint-(R-10)*Math.cos(second*(2*Math.PI/60)));
    g.setColor(Color.red);
    g.drawLine(Xpoint,Ypoint,xSecond,ySecond);
    //画分针
    xMinute=(int)(Xpoint+(R-20)*Math.sin((minute+second/60)*(2*Math.PI/60)));
    yMinute=(int)(Ypoint-(R-20)*Math.cos((minute+second/60)*(2*Math.PI/60)));
    g.setColor(Color.blue); 
    g.drawLine(Xpoint,Ypoint,xMinute,yMinute);
    //画时针
    xHour=(int)(Xpoint+(R-30)*Math.sin((hour+minute/60+second/60/60)*(2*Math.PI/12)));
    yHour=(int)(Ypoint-(R-30)*Math.cos((hour+minute/60+second/60/60)*(2*Math.PI/12)));
    g.setColor(Color.black);
    g.drawLine(Xpoint,Ypoint,xHour,yHour);
 }
 public static void main(String a[])
 {
  new MyClock();
 }
}
