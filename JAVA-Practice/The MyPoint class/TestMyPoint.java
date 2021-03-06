//（MyPoint类）设计一个名为MyPoint的类，表示一个带x坐标和带y坐标的点，这个类他包括：
//	*两个带get方法的数据域x和y，分别表示它们的坐标
//	*创建点（0，0）的无参构造方法
//	*一个创建特定坐标点的构造方法
//	*一个名为distance的方法，返回MyPoint类型的两个点之间的距离
//	*一个名为distance的方法，返回指定x和y坐标的两个点之间的距离

//	写一个测试程序去创建两个点（0，0）和（10，30.5）展示它们之间的距离。




//测试这个类
public class TestMyPoint {
    public static void main(String[] agrs){
        MyPoint p1 = new MyPoint();           //创建两个对象p1,p2
        MyPoint p2 = new MyPoint(10,30.5);
        System.out.println(p1.distance(p2));    //p1,p2之间的距离
    }
}  

class MyPoint{
  private double x;        //定义数据域
	private double y;

    public MyPoint(){       //无参构造方法
        x = 0;
        y = 0;
    }

    public MyPoint(double x, double y){    //有参构造方法
        this.x = x;
        this.y = y;
    }

    public double getX(){      //访问器
        return x;
    }

    public double getY(){
        return y;
    }
 
    public double distance(MyPoint p){         //求MyPoint类型的两个点之间的距离
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
      //return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    public double diatance(double x, double y){         //求指定x,y坐标两点之间的距离
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
}

//Math.sqrt 开平方     Math.pow( , )    求次方
