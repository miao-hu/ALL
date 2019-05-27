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
