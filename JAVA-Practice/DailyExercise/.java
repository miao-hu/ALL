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




