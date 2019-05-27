public class Test {

    public static void main(String[] args){
        GeometricObject arr[] = new GeometricObject[5];//创建有5个GeometricObject对象的数组
        arr[0] = new Square(1,"white",false);  //赋值
        arr[1] = new Square(2,"blue",true);
        arr[2] = new Square(3,"black",true);
        arr[3] = new Square(1,"red",true);
        arr[4] = new Square(1,"yellow",false);
        Square temp = null;   //定义一个Square类的一个实例temp
        for(GeometricObject o : arr){   //遍历这个数组
            if(o instanceof Square){   //若o是Square的一个实例
                temp = (Square)o;
                if(temp.isFilled()){ //若对象已经被填充
                    System.out.println("The area is "+temp.getArea());
					temp.howToColor();
					System.out.println();
				}
            }
        }
    }
}
