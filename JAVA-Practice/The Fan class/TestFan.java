
public class TestFan {

	public static void main(String[] args){

		Fan fan1 = new Fan();       //创建fan1对象

		fan1.setSpeed(3);   //设置速度为最大

		fan1.setRadius(10);  

		fan1.setColor("yellow");  //设置颜色为yellow

		fan1.turnOn();    //设置风扇状态为打开

		fan1.ToString();

		

		Fan fan2 = new Fan();    

		fan2.setSpeed(2);

		fan2.setColor("blue");

		fan2.turnOff();

		fan2.ToString();

	}

}
