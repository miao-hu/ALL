//测试这个类
public class TestMyInteger {
    public static void main(String[] agrs){
        MyInteger n = new MyInteger(10);     //创建一个对象n
    System.out.println(n.isEven());
		System.out.println(n.isOdd());
		System.out.println(n.isPrime());
		System.out.println( MyInteger.isEven(123));   //调用MyInteger类中的方法
		System.out.println( MyInteger.isOdd(123));
		System.out.println( MyInteger.isPrime(123));
		System.out.println(n.equals(123));
    }
}  

//定义一个TestMyInteger类
class MyInteger{
    private int value;     //数据域

    public MyInteger(int value){      //带参构造方法
        this.value = value;
    }

    public int getMyInteger(){       //访问器
        return value;
    }

    public boolean isEven(){
        return value % 2 == 0 ? true : false;
    }

    public boolean isOdd(){
        return value % 2 == 0 ? false : true;
    }

    public boolean isPrime(){
        if(value == 1) return false;

        for(int i = 2; i*i <= value; ++i){
            if(value%i == 0)
                return false;
        }
        return true;
    }

    public static boolean isEven(int num){
        return num%2 == 1 ? false : true;
    }

    public static boolean isOdd(int num){
        return num%2 == 1 ? true : false;
    }

    public static boolean isPrime(int num){
        for(int i = 2; i*i <= num; ++i)
            if(num%i == 0)
                return false;
        return num == 1 ? false : true;
    }

    public static boolean isEven(MyInteger num){
        return (num.value%2 == 1 )? false : true;
    }

    public static boolean isOdd(MyInteger num){
        return (num.value%2 == 1 ) ? true : false;
    }

    public static boolean isPrime(MyInteger num){    //此处只能用 num.value 不能用 num.getValue()
        for(int i = 2; i<num.value; ++i)
            if(num.value%i == 0)
                return false;
        return num.value == 1 ? false : true;
    }
	
    public boolean equals(int num){
        return this.value == num;
    }

    public boolean equals(MyInteger num){
        return this.value == num.getMyInteger();
      //return this.value == num.value;
    }

    public static int parseInt(char[] str){
        return Integer.parseInt(str.toString());
    }

    public static int parseIne(String str){
        return Integer.parseInt(str);
    }
}
