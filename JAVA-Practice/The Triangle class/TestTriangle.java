//(三角形类Triangle）设计一个名为Triangle的类来扩展GeometricObject类，该类包括：
//	*三个名为side1,side2,side3的double型数据域来表示这个三角形的三条边，他们的默认值为1.0
//	*一个无参的构造方法去创建默认三角形
//	*一个能创建指定side1,side2,side3的三角形的构造方法
//	*所有三个数据域的访问器方法
//	*一个名为getArea（）的方法返回这个三角形面积
//	*一个名为getPerimeter()的方法返回这个三角形的周长
//	*一个名为toString()的方法返回这个三角形的字符串描述
//
//	写一个程序去提示用户输入三角形的三条边，颜色和是否被填充。
//	程序应该创建一个三角形的对象，它的三条边，颜色，是否被填充应该使用刚刚所输入的数据。
//	程序应该展示三角形的面积，周长，颜色，是否被填充信息。
//


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

