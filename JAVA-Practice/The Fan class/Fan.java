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
