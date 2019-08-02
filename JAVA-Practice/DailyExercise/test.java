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



14.//二分查找：前提数组有序
	
public class BinarySearch{
	public static void main(String[] args){
	int[] a={1,2,3,4,5,6,7,8,9,10};
	int pos=binarySearch(a,8);
	System.out.printf("pos=%d%n",pos);
	}
	
	/*第一种
	public static int binarySearch(int[] a, int v){
		int left=0;
		int right=a.length-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(v==a[mid]){
				return mid;
			}else if(v>a[mid]){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		return -1;
	}
	*/
	
	//第二种
	public static int binarySearch(int[] a, int v){
		int left=0;
		int right=a.length;
		while(left<right){
			int mid=(left+right)/2;
			if(v==a[mid]){
				return mid;
			}else if(v>a[mid]){
				left=mid+1;
			}else{
				right=mid;
			}
		}
		return -1;
	}	
}



15.
//模仿copyOf()函数进行拷贝
//拷贝到一个数组长度为newLength的新数组中

/*(1)若原数组长度比新数组长度小
-----把原数组元素全部拷贝，新数组剩余元素默认为0(int类型的默认值)
  (2)若原数组长度比新数组长度大
-----只拷贝新数组长度的个数元素

综上：取两个数组长度最小的那个作为衡量值
*/
import java.util.Arrays;

public class CopyArray{
	public static void main(String[] args){
	int[] a={1,2,3,4,5};
	System.out.println(Arrays.toString(copyOf(a,10)));//[1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
	System.out.println(Arrays.toString(copyOf(a,3)));//[1, 2, 3]
	System.out.println(Arrays.toString(Arrays.copyOf(a,7)));//[1, 2, 3, 4, 5, 0, 0]
	System.out.println(Arrays.toString(Arrays.copyOf(a,4)));//[1, 2, 3, 4]
	
	}

	public static int[] copyOf(int[] original, int newLength){
		int[] dest=new int[newLength];  //定义一个新数组长度为NewLength
		int length=original.length<=newLength?original.length:newLength;
		for(int i=0;i<length;i++){
			dest[i]=original[i];
		}
		return dest;
	}
}
	
	
	
16.//模仿fill()函数填充一个数组

import java.util.Arrays;
public class FillArray{
	public static void main(String[] args){
		int[] a=new int[5];
		fill(a,6);
		System.out.println(Arrays.toString(a));//[6, 6, 6, 6, 6]
		Arrays.fill(a,24);   
		System.out.println(Arrays.toString(a));//[24, 24, 24, 24, 24]
	}
	
	public static void fill(int[] a, int v){
		for(int i=0;i<a.length;i++){
			a[i]=v;
		}
	}
}



17.//仿照indexOf()函数的功能
   //从一个数组中找一个元素，若找到返回元素的下标
   //若没有找到返回-1

import java.util.Arrays;
public class FindNumber{
	public static void main(String[] args){
		int[] a={1,2,3,4,5};
		System.out.println(indexOf(a,10));
	}
	
	public static int indexOf(int[] a, int v){
		for(int i=0;i<a.length;i++){
			if(v==a[i]){
				return i;
			}
		}
		return -1;
	}
}

	
	
18.
/*
public static void arraycopy(Object src,int srcPos,
							Object dest,int destPos,
							int length);
		将src从srcPos位置起复制length长度个元素
		到dest的destPos起的位置
*/

import java.lang.System;
//不用添加这个包也可以，系统自动添加
import java.util.Arrays;
public class ToArrayCopy{
	public static void main(String[] args){
		int[] a={1,2,3,4,5,6,7,8,9};
		int[] b=new int[10];
		System.arraycopy(a,3,b,4,3);
		System.out.println(Arrays.toString(b));
		//[0, 0, 0, 0, 4, 5, 6, 0, 0, 0]
	}
}

	
	
19.
/*
冒泡排序
正向：无序[0,a.length-i)
      有序[a.length-i,a.length)
反向：有序[0,i)
	  无序[i,a.length)
*/
import java.util.Arrays;

public class BubbleSort{
	public static void main(String[] args){
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int[] b = { 7, 6, 5, 4, 3, 2, 1 };
		int[] c = { 3, 5, 2, 4, 1, 7, 6 };
		int[] d = { 3, 3, 3, 3, 3, 3, 3 };
		
		testBubbleSort(a);
		testBubbleSort(b);
		testBubbleSort(c);
		testBubbleSort(d);
	}
	
	public static void testBubbleSort(int[] arr){
		System.out.print("排序前:");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		bubbleSort1(arr);
		System.out.print("排序后:");
		System.out.println(Arrays.toString(arr));
		System.out.println();
	}
	
	//正向
	public static void bubbleSort(int[] a){
		for(int i=0;i<a.length;i++){//控制趟数
			boolean sorted=true;
			for(int j=0;j<a.length-i-1;j++){
				//-1是为了保证最后两项进行比较
				if(a[j]>a[j+1]){
					swap(a,j,j+1);
					sorted=false;
				}	
			}
			if(sorted==true){
				return;
			}
		}
	}
	
	//反向
	public static void bubbleSort1(int[] a){
		for(int i=0;i<a.length;i++){//控制趟数
			boolean sorted=true;
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					swap(a,j,j-1);
					sorted=false;
				}	
			}
			if(sorted==true){
				return;
			}
		}
	}
	
	public static void swap(int[] a,int i,int j){			
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
}	
	
	

20.
/*
n代表盘子个数，source代表源柱子，dest代表目标柱子
用0 1 2分别代表三个柱子
将此题分为3个步骤：
(1)将n-1个盘子从source移动到other
(2)将第n个盘子从source移动到dest
(3)将n-1个盘子从other移动到dest
*/

public class Hannoi{
	public static void main(String[] args){
		//String "11"-->int 11
		move(Integer.parseInt(args[0]),0,2);  //将n个盘子从源移动到目的
	}
	
	public static void move(int n,int source,int dest){
		if(n==1){
			System.out.printf("从 %d 移动到 %d%n",source,dest);
			return;
		}
		int other=3-source-dest;
		move(n-1,source,other);
		System.out.printf("从 %d 移动到 %d%n",source,dest);
		move(n-1,other,dest);
	}
}


//javac -encoding UTF-8 Hannoi.java
//java Hannoi 3

//从 0 移动到 2
//从 0 移动到 1
//从 2 移动到 1
//从 0 移动到 2
//从 1 移动到 0
//从 1 移动到 2
//从 0 移动到 2
	
	
	
21./*
将一个数组右旋K位，求新数组的值,使用下列方法
public static void arraycopy(Object src,int srcPos,
                             Object dest,int destPos,
                             int length);
public static void copyOf(int[] original, int newLength);

思路:1,2,3,4,5       k=3   //3,4,5,1,2
	 1,2,3,4,5,6,7   k=8   //7,1,2,3,4,5,6
	 先开辟一个新的数组
	 先把4,5移动到新数组
	 把1,2,3在原数组进行移动
	 把4,5从新数组移动到原数组
*/
import java.util.Arrays;

public class Rotate{
	public static void main(String[] args){
	System.out.println(Arrays.toString(rotate(new int[]{1,2,3,4,5},3)));
	System.out.println(Arrays.toString(rotate(new int[]{1,2,3,4,5},8)));
	System.out.println(Arrays.toString(rotate(new int[]{1,2,3,4,5,6,7},8)));
	}
	
	public static int[] rotate(int[] nums,int k){
		k=k%nums.length;
		int[] other=Arrays.copyOfRange(nums,nums.length-k,nums.length);
		System.arraycopy(nums,0,nums,k,nums.length-k);
		System.arraycopy(other,0,nums,0,other.length);
		return nums;
	}	
}
	
	
	
22.//将数组中的奇数值全部放到右边
//将数组中的偶数值全部放到左边

import java.util.Arrays;

public class SortArrayByParity{
	public static void main(String[] args){
		int[] arr={2,3,6,7,8,10};	
		System.out.println(Arrays.toString(sortArrayByParity1(arr)));
	}
	
	//[0,a)都为偶数,[a,i)之间的都为奇数,i右边的都没有判断
	public static int[] sortArrayByParity(int[] nums){
		int a=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]%2==0){  //偶数
				swap(nums,a,i);
				a++;
			}	
		}
		return nums;
	}
	
	/*
		[begin, end] 区间内的数是未判断的数
		[0, begin)	偶数
		[end, nums.length) 奇数
	*/
	public static int[] sortArrayByParity1(int[] nums){
		int begin=0;
		int end=nums.length-1;
		while(begin<end){
			while(begin<end&&nums[begin]%2==0){
				/*这里的begin<end是为了防止数组下标越界
				  若没有begin<end，那么要是数组全是偶数
				  begin一直++，那么最终下标会越界报错
				*/
				begin++;
			}
			while(begin<end&&nums[end]%2!=0){
				end--;
			}
			//走到这的原因之一是
			//begin下标对应的是奇数，end下标对应的是偶数
			swap(nums,begin,end);
			
		}
		return nums;
	}
	
	public static void swap(int[] a ,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;	
	}
}



23.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
