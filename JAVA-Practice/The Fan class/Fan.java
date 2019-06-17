//（风扇类Fan）设计一个名为Fan的类来表示一个风扇，这个类包括：
//	     *三个名为SLOW,MEDIUM,FAST而值是1,2,3的常量来表示风扇的速度
//           *一个名为speed的int类型的私有数据域来表示风扇的速度（默认值SLOW）
//	     *一个名为on的boolean类型的私有数据域来表示风扇是否打开（默认值false）
//	     *一个名为radius的double类型的私有数据域来表示风扇的半径（默认值5）
//	     *一个名为color的String类型的数据域来表示风扇的颜色（默认值blue）
//	     *这四个数据域的访问器和修改器
//	     *一个创建默认风扇的构造方法
//	     *一个名为toString()的方法返回描述风扇的字符串，如果风扇是打开的，那么该方法返回风扇的速度，颜色，半径将它们组合在一个字符串中表达。
//	     *如果风扇没有被打开，那么该方法就会返回一个由”fan is off”和粉删的颜色，半径组成的字符串

//	     编写一个测试程序，创建两个Fan对象，将第一个对象设置为最大速度，半径为10，颜色为yellow，状态为打开。
//	     将第二个对象设置为中等速度，半径为5，颜色为blue，状态为关闭。
//	     通过调用它们的toString()方法显示这些对象。



//一个名为Fan的类

public class Fan {

	private final short SLOW = 1;     //三个名为SLOW，MEDIUM，FAST而值为1，2，3的常量表示风扇的速度

	private final short MEDIUM = 2;

	private final short FAST = 3;

	private int speed;         //私有数据域

	private boolean on;

	private double radius;

	private String color;      //风扇的颜色

	Fan(){           //无参构造方法（初始化对象）默认值为，SLOW，false,5,blue

		speed = SLOW;

		on = false;

		radius = 5;

		color = "blue";

	}

	

	public void turnOn(){    //函数：风扇开

		on = true;

	}

	public void turnOff(){       //函数：风扇关

		on =false;

	}

	public void setRadius(double newRadius){      //修改器

		radius = newRadius;

	}

	public double getRadius(){         //访问器

		return radius;

	}

	public void setColor(String newColor){

		color = newColor;

	}

	public String getColor(){

		return color;

	}

	public void setSpeed(int newSpeed){

		speed = newSpeed;

	}

	public int getSpeed(){

		return speed;

	}

	public void ToString(){

		if(on)

			System.out.println(speed + " " + color + " " + radius);

		else

			System.out.println("fan is off"+);

	}

	

}
