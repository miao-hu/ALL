//(可着色接口Colorable)设计一个名为Colorable的接口，其中有名为()的void方法，可着色对象的每个类必须实现这个接口，
//		      设计一个扩展GeometricObject的类并实现Colorable接口的名为Square的类，
//		      实现howToColor方法在这个类中，显示消息”Color all four sides”。


//			编写一个测试程序，创建有5个GeometricObject对象的数组，对于数组中的每个对象而言，
//			如果对象是可着色的（已被填充的），那就展示他的面积个调用howToColor()方法。



public class Square extends GeometricObject implements Colorable{
	//一个名为Square的类：扩展GeometricObject类并且实现Colorable接口
    private double side;

    public Square(){
        super();
        side = 1.0;
    }

    public Square(double side, String color, boolean filled){
        super(color,filled);   //因为color,filled在父类中都是私有的
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPrimeter() {
        return side*4.0;
    }
}
