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


