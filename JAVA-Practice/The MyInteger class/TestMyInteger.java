//(MyInteger类）设一个名为MyInteger的类，这个类包括：
//	*一个名为value的int型数据域，存储这个对象代表的int值
//	*一个指定的int值创建一个MyInteger对象的构造方法
//	*一个返回int值的get方法
//	*如果值分别为偶数，奇数，素数，那么isEven(),isOdd(),isPrime()方法都会返回true
//	*如果指定值分别为偶数，奇数，素数，那么isEven(int),isOdd(int),isPrime(int)方会返回true
//	*如果指定值分别为偶数，奇数，素数，那么isEven(MyInteger),isOdd(MyInteger),isPrime(MyInteger)方法都会返回true
//	*如果该对象的值和指定的值相等，那么equals(int)和equals(MyInteger)方法都会返回true
//	*静态方法parseInt(char [])将数字字符构成的数组转换为一个Int值
//	*静态方法parseInt(String)将一个字符串转换为一个Int值

//	实现这个类，编写客户程序测试这个类中的所有方法



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

    public int getValue(){       //访问器
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

   /*  第一种
    public static boolean isEven(MyInteger num){
        return (num.value%2 == 1 )? false : true;
    }

    public static boolean isOdd(MyInteger num){
        return (num.value%2 == 1 ) ? true : false;
    }

    public static boolean isPrime(MyInteger num){    
        for(int i = 2; i<num.value; ++i)
            if(num.value%i == 0)
                return false;
        return num.value == 1 ? false : true;
    }
    */
    
    public static boolean isEven(MyInteger num){
        return (num.getValue()%2 == 1 )? false : true;
    }

    public static boolean isOdd(MyInteger num){
        return (num.getValue()%2 == 1 ) ? true : false;
    }

    public static boolean isPrime(MyInteger num){
        for(int i = 2; i<num.getValue(); ++i)
            if(num.getValue()%i == 0)
                return false;
        return num.getValue() == 1 ? false : true;
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
