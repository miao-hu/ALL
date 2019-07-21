1.（找到能被5或被6整除，但不能同时被5或6整除的数）编写一个程序，显示从100到200中，
   每十个数一行，能被5或被6整除，但不能同时被5或6整除的数，数字之间用一个空格隔开。

import java.util.Scanner; 
public class DivBy5or6ButNotBoth{
	public static void main(String[] args){	
		int count = 0;		
		for(int i = 100; i <= 200; i++){		
			if(i%5 == 0 ^ i%6 == 0){		
				System.out.print(i + " ");		
				count++;			
				if(count%10 == 0)				
				System.out.println();			
			}		
		}	
	}
}



2.（求一个整数的各位数字之和）编写一个方法，计算一个整数各位数字之和。
   使用方法头public	static	int	sumDigits(long n)
   例如：sumDigits(234)返回9（2+3+4）
   
import java.util.Scanner;
public class SumDigitsInAnInteger{	
	public static void main(String[] args){	
	System.out.print("plese enter an int number:");
	Scanner input = new Scanner(System.in);		
	int num = input.nextInt();	
	System.out.println("The sum is "+sumDigits(num));	
	}	
	
	public static int sumDigits(int n){	
		int sum = 0;		
		while(n != 0){	
			sum += n % 10;		
			n = n / 10;		
		}		
	return sum;	
	}
}



3.（使用isPrime方法）提供一个测试一个数字是否是素数的方法isPrime（int	number)
		    10000的素数个数。
	
public class IsPrime{    
	public static void main(String[] args){   
	int count = 0;   
	for(int i = 2; i <= 10000; i++){   
		if(isPrime(i))    		
		count++;    	
	}    
	System.out.println("The count is "+count);   
 }  
 
	public static boolean isPrime(int n){      
		for(int i = 2; i<= n/2; i++){   
			if(n%i == 0)    			
				return false;    
		}    
		return true;   
	}
}

	

4.（找最小元素）编写一个方法，使用下面的方法头找出一个double型数组中的最小元素。
               public	static	double	min(double[]	array)
               编写测试程序，提示用户输入10个数字，调用这个方法返回最小值，显示其最小值。
               下面是该程序的运行示例：
               Enter	ten	numbers:1.9  2.5  3.7  2  1.5  6  3  4  5  2
               The	minimum	    number	is:1.5
	
import java.util.Scanner; 
public class FindSmallestElement{		
	public static void main(String[] args){	
		double[] nums = new double[10];	
		Scanner input= new Scanner(System.in);
		System.out.print("Enter ten numbers:");	
		for(int i = 0; i < 10; i++){			
			nums[i] = input.nextDouble();		
		}				
		double smallest = min(nums);	
		System.out.println("The minimum number is :"+smallest);	
	} 		
	public static double min(double[] array){	
		double small = array[0];	
		for(int i = 0; i < 10; i++){	
			if(array[i] < small)				
				small = array[i];		
		}		
	return small;	
	}
}



5.（求数组的平均值）编写两个重载方法，使用下面的方法头返回一个数组的平均值。
		  public static int average(int[] array)
		  public static double average(double[] array)
		  编写测试程序，提示用户输入10个double型值，调用这个方法显示其平均值。
		  
import java.util.Scanner;
public class AverageArray{		
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);	
	double[] nums = new double[10];	
	System.out.print("Enter ten number:");	
	for(int i = 0; i < 10; ++i){			
		nums[i] = input.nextDouble();	
	}				
	double ret= average(nums);	
	System.out.println("The average array is "+ret);	
	}	
	
	public static int average(int[] array){	
		int sum = 0;	
		for(int i = 0; i < array.length; i++){		
			sum += array[i];	
		}	
		return sum/array.length;
	}	
	
	public static double average(double[] array){	
		double sum = 0;		
		for(int i = 0; i < array.length; i++){	
			sum += array[i];		
		}		
		return sum/array.length;	
	}
 } 



6.（按考分对学生排序）以正确答案个数升序显示学生。

	public class SortStudentOnGrades{	
	public static void main(String[] args){	
		char answer[][] = {		
		{'A','B','A','C','C','D','E','E','A','D'},		
		{'D','B','A','B','C','A','E','E','A','D'},	
		{'E','D','D','A','C','B','E','E','A','D'},		
		{'C','B','A','E','D','C','E','E','A','D'},		
		{'A','B','D','C','C','D','E','E','A','D'},		
		{'B','B','E','C','C','D','E','E','A','D'},		
		{'B','B','A','C','C','D','E','E','A','D'},		
		{'E','B','E','C','C','D','E','E','A','D'}};				
	char keys[] = {'D','B','D','C','C','D','A','E','A','D'};	
	int[] student = new int[answer.length];	
	for(int i = 0; i < answer.length; i++){	
		int correctCount = 0;		
		for(int j = 0; j < answer[i].length; j++){
			if(answer[i][j] == keys[j])			
			correctCount++;	
		}		
		student[i] = correctCount;	
	}	
	java.util.Arrays.sort(student);			
	for(int i = 0; i < student.length; ++i){
			System.out.println(student[i]);
	}
	}
}



7.（求矩阵的主对角线元素的和）编写一个方法。求n*n的double矩阵中主对角线上所有的数字之和。使用下面的方法头：
			    public static double sumMajorDiagonal(double[][] m)
			    一个测试程序读取4*4的矩阵，然后显示它的主对角线上所有的元素的和。这儿是一个简单地运行例子：
			    Enter a 4-by-4 matrix row by row:
				1	2	3	4.0
				5	6.5	7	8
				9	10	11	12
				13	14	15	16
			    Sum of the elements in the major diagonal is 34.5	
					
import java.util.Scanner;
public class SumMagorDiagonalMatrix{	
	public static void main(String[] args){	
	Scanner input = new Scanner(System.in);	
	final int row= 4;		
	double[][] num = new double[row][row];	
	System.out.println("Enter a 4-by-4 matrix row by row:");	
	for(int i = 0; i < row; ++i){			
		for(int j = 0; j < row; ++j){			
			num[i][j] = input.nextDouble();
		}
	}		
	double ret = sumMajorDiagonal(num);	
	System.out.println("Sum of the elements in the major diagonal is "+ret);	
	}
	
	public static double sumMajorDiagonal(double[][] m){
		double sum=0;
		for(int i = 0; i < m.length; i++){	
			sum += m[i][i];
		}		
		return sum;
	}	
}



8.（指定等级）写一个程序，读入学生成绩，获得最高分best，然后根据下面的规则赋等级值。
	     如果分数>=best-10,等级为A
	     如果分数>=best-20,等级为B
	     如果分数>=best-30,等级为C
	     如果分数>=best-40,等级为D
	     其他情况等级为F
	     程序提示用户输入学生的总数，然后提示用户去输入所有的分数，然后显示等级得出结论，下面是一个运行实例：
	     Enter the number of students:4
	     Enter 4 scores:	40	55	70	58
	     Student  0 score is  40  and grade is 	C
	     Student  1 score is  55  and grade is 	B
	     .......

import java.util.Scanner;
public class AssignGrades{	
	public static void main(String[] args){	
	Scanner input = new Scanner(System.in);	
	int best = 0;
	
	System.out.print("Enter the number of students:");	
	int numStudent = input.nextInt();
	
	int[] student = new int[numStudent];
	
	System.out.print("Enter "+numStudent+" scores:");
	for(int i = 0; i < numStudent; i++){	
		student[i] = input.nextInt();	
		if(student[i] >= best)			
	    best = student[i];		
	}
	
	for(int i = 0; i < numStudent; ++i){	
		System.out.print("Student " + i + " score is " + student[i] + " and grade is ");			
	if(student[i] >= best - 10)			
		System.out.println("A");			
	else if(student[i] >= best - 20)	
			System.out.println("B");			
		 else if(student[i] >= best - 30)	
				System.out.println("C");			
			  else if(student[i] >= best - 40)	
					  System.out.println("D");
				   else
					  System.out.println("F");
	}	
	}
}



9.（任意字母）使用Math.random()方法编写程序，显示一个任意的小写字母。

//Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值[0.0,1.0)
public class LittercaseLetter{
  public static void main(String[] args){
    int number=97+(int)(Math.random()*26);
    char letter=(char)number;
    System.out.println(letter);
  }
}



10.//区别%n和\n的使用，即main函数的形参args[0]越界问题

public class Test{
	public static void main(String[] args){
	
	System.out.printf("%s%n",args[0]);  //zhangsan
	System.out.printf("%s\n",args[0]);  //zhangsan
	}
}

//javac Test.java 
//java Test zhangsan

/*
在windows平台下，\r\n表示回车换行
在Linux平台下，\n表示回车换行
而JAVA语言是支持跨平台的，因此使用%n可以自动识别平台
而不用去因为平台的不同而去辨别到底书写\r\n还是书写\n
*/
	


11.  * 利用公式
     * e = 1/0! + 1/1! + 1/2! + 1/3! + 1/4! + ...
     * 计算自然对数的底 e
     * @param n 计算多少项
     * @return

/*
注意：输入的n不能太大，太大结果会为Infinity
	0.0并不是真正意义上的0，它只不过是一个非常接近0的数而已，
	所以一个数除以一个非常接近0的数，那么结果应该为无穷大。
	在JAVA浮点范围内存在Infinity表示无穷大的概念。
*/

import java.util.Scanner;

public class CalE{
	public static void main(String[] args){
		System.out.print("please enter a number:");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		double e=0;
		for(int i=0;i<=n;i++){
			e+=(1.0/factorial(i));
		}
		System.out.println(e);    //2.7182818284590455
	}
	
	/*方法一(利用迭代方式计算阶乘)
	public static long factorial(int num){
		long sum=1;
		for(int i=1;i<=num;i++){
			sum*=i;
		}
		return sum;
	}
	*/
	
	//方法二(利用递归方式计算阶乘)
	public static long factorial(int num){
		if(num==0||num==1){
			return 1;
		}else{
			return num*factorial(num-1);
		}
	}
}



12.  /**
     * 利用公式
     * Pi / 4 = 1/1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
     * 计算 pi 的值
     * @param n 一共计算多少项
     * @return
     */
	 
import java.util.Scanner;

public class CalPi{
	public static void main(String[] args){
		System.out.print("please enter a number:");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		
		/*第一种(设置标志位)
		double tag=1,sum=0;  //tag为标志位
		for(int i=1;i<n;i++){
			sum+=tag/(2*i-1);
			tag=-tag;
		}
		*/

		
		//第二种
		double sum=0;
		for(int i=0;i<n;i++){
			int fenmu=2*i+1;
			double shang=1.0/fenmu;
			if(i%2==0){
				sum+=shang;    //奇数判断用：i%2!=0
			}else{				//i%2==1是错误的（ -3也是奇数）
				sum-=shang;
			}
		}
		System.out.println(sum*4);  //double*int可能有精度损失
	}
}



13./**
     * 10 进制转 16 进制，计算公式如下例
     * 1958 转 16 进制
     * 1958 % 16 == 6   1958 / 16 == 122
     * 122 % 16 == 10 也就是 A   122 / 16 == 7
     * 7 < 16
     * 1958 的 16 进制 为 7A6
     * @param n
     * @return
     */

import java.util.Scanner;

public class DecToHex{
	public static void main(String[] args){
		System.out.print("please enter a number:");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		String s="";
		while(n>0){
			int yushu=n%16;
			if(yushu<10){
				s+=yushu;
			}
			else{
				char c=(char)((yushu-10)+'A');
				s+=c;
			}
			n/=16;
		}
		System.out.println(reverse(s));
	}
    public static String reverse(String s){
        int length=s.length();
        String r ="";
        for (int i=length-1;i>=0;i--) {
            r+=s.charAt(i);
        }
        return r;
    }
}



14.
