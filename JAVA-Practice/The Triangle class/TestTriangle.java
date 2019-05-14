import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] agrs){
	Scanner input=new Scanner(System.in);
	System.out.print("please enter three sids:");//提醒用户输入三条边
	double side1=input.nextDouble();
	double side2=input.nextDouble();
	double side3=input.nextDouble();
	Triangle triangle = new Triangle(side1,side2,side3);//创建Triangle类的一个对象
	
	System.out.print("please enter it is color:");//提醒用户输入颜色
	String color=input.next();
	triangle.setColor(color);
	
	System.out.print("please enter whether it is filled or not:");//提醒用户输入图形是否被填充
    Boolean filled=input.nextBoolean();  //只能输入false   true
	triangle.setFilled(filled);
	
    System.out.println(triangle.toString());
	//调用的是子类的toString()方法
    }
}  

class GeometricObject{      //父类
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;   //java.util.Date是类名

    public GeometricObject(){
        dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled){
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return color; 
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public java.util.Date getDateCreated(){
        return dateCreated;
    }

    public String toString(){
        return "created on " + dateCreated + 
				"\ncolor: " + color +
				" and filled: " + filled; 
    }
}

class Triangle extends GeometricObject{ //Triangle是子类
    private double side1 ;
    private double side2 ;
    private double side3 ;

    public Triangle(){
        super();    //继承父类的构造方法
        side1 = side2 = side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3){
        super();    //继承父类的构造方法
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    public double getArea(){
        double s = (side1 + side2+ side3) / 2;
        return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

  
    public String toString(){
        return  "created on " + super.getDateCreated()
				+ "\ncolor: " + super.getColor() 
				+ "\nfilled: " + super.isFilled()
                + "\nArea: " + this.getArea() 
				+ "\nPerimeter: " + this.getPerimeter();
    }
}

