
public class Fan {

	private final short SLOW = 1;

	private final short MEDIUM = 2;

	private final short FAST = 3;

	private int speed;

	private boolean on;

	private double radius;

	private String color;

	Fan(){

		speed = SLOW;

		on = false;

		radius = 5;

		color = "blue";

	}

	

	public void turnOn(){

		on = true;

	}

	public void turnOff(){

		on =false;

	}

	public void setRadius(double newRadius){

		radius = newRadius;

	}

	public double getRadius(){

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

			System.out.println("fan is off");

	}

	

}
