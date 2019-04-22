import javax.swing.JFrame;

public class TestFrame{
	public static void main(String[] args){
	  JFrame frame1=new JFrame();          //创建JFrame对象
	  frame1.setTitle("windows 1");        //设置窗口标题
	  frame1.setSize(400,300);             //设置窗口的宽度和高度
	  frame1.setLocation(400,200);         //指明窗口左上角的位置
	  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //在关闭框架时终止该程序
	  frame1.setVisible(true);             //表示是否显示这个窗口
	   
	  JFrame frame2=new JFrame();          
	  frame1.setTitle("windows 2");
	  frame1.setSize(600,400);
	  frame1.setLocation(500,300);
	  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame1.setVisible(true);
	}
}
	  
