//(ComparableCircle类)设计一个名为ComparableCircle的类，它扩展Circle类并实现Comparable接口，
//                    实现comparTo方法去利用两个圆的面积比较两个圆的大小。

//                    编写一个测试程序，求出ComparableCircle对象中两个实例的较大者。



public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{



    public ComparableCircle(){

        super();

    }



    public ComparableCircle(double radius){

        super(radius);

    }



    @Override

    public int compareTo(ComparableCircle o) {

        if(this.getArea() > o.getArea()){

            return 1;

        }

        else if(this.getArea() < o.getArea()){

            return -1;

        }

        else

            return 0;

    }

}

