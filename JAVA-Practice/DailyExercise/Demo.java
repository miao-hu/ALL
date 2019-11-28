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



23.//去掉数组中一个最大值和一个最小值求平均值

public class Test{
	public static void main(String[] args){
		int[] a={1,2,3,4,5,6,7};
		System.out.println(average(a));
		System.out.println(average1(new int[]{1,2,3,4,5,6,7}));//匿名数组
		//两个结果都是4.0
	}
	
	public static double average(int[] a){
		int sum=0;
		int max=a[0];
		int min=a[0];
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			if(max<a[i]){
				max=a[i];
			}
			if(min>a[i]){
				min=a[i];
			}
		}
		return (double)(sum-max-min)/(a.length-2);
	}
		
	public static double average1(int[] a){
		int sum=0;
		int max=Integer.MIN_VALUE; //-2^31
		int min=Integer.MAX_VALUE; //2^31-1
		for(int v:a){  //遍历这个数组
			sum+=v;
			if(v>max){
				max=v;
			}
			if(v<min){
				min=v;
			}
		}
		return (double)(sum-max-min)/(a.length-2);
	}

}
	
	
	
24.class Person {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person self() {
		return this;
	}
	
	public String name() {
		return this.name;
	}
}

public class TestThis {
	public static void main(String[] args) {
		Person p = new Person("小比特", 18);
		System.out.println(p.self().name());   //小比特
		System.out.println(p.self());   //Person@15db9742
		System.out.println(p.name());    //小比特
	}
}



25.//java中导入自己设定的包
	
package hello;  //属于hello包
public class HelloJava{
	
	public void say(){
		System.out.println("Hello Java");
	}
	
}


package hello;  //属于hello包
public class HelloWorld{
	
	public void say(){
		System.out.println("Hello world");
	}
	
}
	

import hello.HelloWorld;  //import 包名.类名；
import hello.HelloJava;  //导入这个包
public class Practice0722{
	public static void main(String[] args){
		HelloWorld p=new HelloWorld();
		p.say();  //Hello world
		HelloJava q=new HelloJava();
		q.say();  //Hello Java
		//new HelloJava().sayHello();  //Hello Java
		//注意：最后一条代码是匿名对象
	}
}



26.//代码块

public class A{

	public A(){
		System.out.println("构造方法中a=30");
		a=30;
	}
	
	{
		System.out.println("构造代码块1中a=40");
		a=40;
	}
	
	int a=init();
	
	{
		System.out.println("构造代码块2中a=60");
		a=60;
	}
	
	public int init(){
		System.out.println("初始化中a=90");
		return 90;
	}
	
	static{
		System.out.println("静态代码块1中B=100");
		B=100;
	}
	
	static int B=staticInit();
	
	static{	
		System.out.println("静态代码块2中B=400");
		B=400;
	}
	
	//初始化static int类型的属性时，初始化方法也必须是static int类型的
	public static int staticInit(){   
		System.out.println("初始化中B=500");
		return 500;
	}
	public static void main(String[] args){
		A p=new A();
		A q=new A();
			/*
			静态代码块1中B=100
			初始化中B=500
			静态代码块2中B=400		注意：static代码块只执行一次
			构造代码块1中a=40       	（static代码块只在类加载时执行,
			初始化中a=90				 类是用类加载器来读取的，
			构造代码块2中a=60			 类加载器是带有一个缓存区的，
　　　　　　构造方法中a=30				 它会把读取到的类缓存起来，
			构造代码块1中a=40			 所以在一次虚拟机运行期间,
			初始化中a=90				 一个类只会被加载一次，这样的话
　　　　　	构造代码块2中a=60			 静态代码块只会运行一次）
			构造方法中a=30
			*/
	
	/*zhuyi:对属性进行初始化和执行代码块是同级的，谁先在前先执行谁
			然后再执行构造方法
			当静态static出现时先执行有static出现的代码
	*/
	}
}



27./*
System.out.println();
表示：System类的out属性的println()方法      (嵌套调用)
*/

class System{
	static PrintWriter out;   //System类的out属性
}

//PrintWriter也是一个类
class PrintWriter {   
	public void println() {
	}
}

//等同于
PrintWriter temp=System.out;
temp.println();

//对象名.方法名()调用PrintWriter类的println()方法



28./*
定义一个名为Data的类，它的属性包括年-月-日
原则：一切从用户角度出发
功能：1）定义一个构造方法（初始化）
		*无参（显示当前年-月-日）
		*有参（更新新的年-月-日）
	  2）必须对用户输入的年-月-日进行效验
	    *年支持范围[1999,2999]
		*月支持范围[1,12]
		*日支持范围（根据月份而定）
		注：每月的天数1   2     3  4  5  6  7  8  9  10 11 12 
					  31 28/29  31 30 31 30 31 31 30 31 30 31
	  3）days天之后的年-月-日
	  4）days天之前的年-月-日
*/

class Data{
	private int year;
	private int month;
	private int day;
	
	//内部属性，这些属性没有必要为每个对象都存一份所以定义为static
	//大家共享就行，final不可变的，每个月多少天是不可变的
	private static final int[] DAYS_OF_MONTH={
					31,28,31,30,31,30,31,31,30,31,30,31
					};
	
	public Data(){
		this.year=2019;
		this.month=7;
		this.day=20;
	}
	
	public Data(int year,int month,int day){
		//对用户输入的年-月-日进行合法性效验
		if(year<1999||year>2999){
			System.err.println("输入的年份有问题");
			return;
		}
		if(month<1||month>12){
			System.err.println("输入的月份有问题");
			return;
		}
		if(day<1||day<calMonthNumber(year,month)){
			System.err.println("输入的日有问题");
			return;
		}
		
		//执行到这一步说明输入的年-月-日是正确的
		this.year=year;
		this.month=month;
		this.day=day;
	}
	
	private static  int calMonthNumber(int year,int month){
		if(month!=2){  //说明不是2月
			return DAYS_OF_MONTH[month-1];  //月份下标[0,11]
		}
		if(isLaepYear(year)){
			return 29;   //闰年2月29天
		}
		else{
			return 28;   //别的年份2月29天
		}
	}
	
	//判断是否是闰年不为用户提供服务，因此用private
	//这个方法不调用普通属性和方法，因此用static
	private static  boolean isLaepYear(int year){
		if((year%4==0&&year%100!=0)||year%400==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public  Data after(int days){
		day+=days;
		//当day>这个月的天数   那么就循环
		while(day>calMonthNumber(year,month)){
			//day-=DAYS_OF_MONTH[month-1];错误：应该减去这个月的天数
			day-=calMonthNumber(year,month);
			month+=1;   //到下一月
			if(month>12){
				month=1;
				year+=1;
			}
		}
		return this;   //返回这个对象
	}	
	
	public  String toString(){
		return String.format("%04d-%02d-%02d",year,month,day);
		//和System.out.printf一样格式化输出
		//年占4个字节，月占2个，日占两个，不够用0填充
	}
}	

//public更多是提供给用户用的
//对外提供的服务是public的
public class TestData{
	public static void main(String[] args){
		Data now=new Data();   
		System.out.println(now.toString());  //2019-7-20
		
		Data afterNow=now.after(300);
		System.out.println(afterNow.toString());  //2020-05-15
		System.out.println(now.toString());       //2020-05-15
		
		now=new Data();
		Data beforeNow=now.before(500);
		System.out.println(beforeNow.toString());
	}
}
	
	
	
	
	
public Data before(int days) {
		day-=days;
		while(day<1){
			month-=1;   //到上一月
			day+=calMonthNumber(year,month);	
			if(month==1){
				month=12;
				year-=1;
			}
		}
		return this;   //返回这个对象
	}
		
	public Date immutableAfter(int days) {//当前对象不可变
		Date other = new Date(year, month, day);//吧自己的年月日传进去
		
		// 修改的是 other 的属性
		return other;
	}
	
	
	// TODO: 实现 a - b 相差多少天
	public static int diff(Date a, Date b) {
		return 0;
	}	
	
	
	
29.// 这个 public 是顶级的(top-level)
public class TestStatic{
	int a;
	static int b=1;
	
	public void print(){
	}
	
	// 这个 public 是成员级的 (member-level)
	public static void main(String[] args){
		
		//a=10;  //报错：无法从静态上下文中引用非静态 变量 a（隐式使用了 this.a）
		b=10;  //正确
		//print(); //报错:无法从静态上下文中引用非静态 方法 print()  (隐式使用了 this.print();)
		//System.out.println(a);//无法从静态上下文中引用非静态 变量 a
		
		System.out.println(b);  //10
		new TestStatic().b=100;
		System.out.println(b);  //100
		TestStatic p=new TestStatic();
		System.out.println(p.b);  //100
		
		//static定义的变量满足用户共享
		
	}
}



30.public class TestToString{
	public String toString(){
		return "abcdefgh";
	}
	
	public static void main(String[] args){
		TestToString p=new TestToString();
		//System.out.println(p);			   //TestToString@15db9742
		//System.out.println(p.toString());    //TestToString@15db9742
		
		//注意:p和p.toString()实际是一样的
		
		System.out.println(p);             //abcdefgh
		System.out.println(p.toString());  //abcdefgh
		
		/*
		若没有重载一个类的toString()方法，那么他就返回  类名@地址
		若有重载的toString()方法，那么他就返回toString()方法中的返回值
		*/
	}
}



31.//顺序表
//插入前都要判断数组容量够不够

public class MyArrayList{
	private int[] array;  /*数组名：array
							数组容量：array.length
						  */
	private int size;	  //数组中实际存的元素个数
	
	//构造方法
	public MyArrayList(){
		//1.申请空间
		array=new int[3];
		// 2. 初始化数据个数
		size=0;    //刚开始数组中没有元素
	}
	
	//后插
	public void pushBack(int element){
		ensureCapacity();	//先确保数组容量够不够
		array[size]=element;
		size++;	
	}
	
	//前插
	public void pushFront(int element){
		ensureCapacity();
		for(int i=size-1;i>=0;i--){
			array[i+1]=array[i];
		}
		array[0]=element;
		size++;
	}
	
	//插入
	public void insert(int index, int element){
		if(index<0||index>=size){
			System.out.println("输入的下标不对");
			return;
		}
		ensureCapacity();//输入下标对，确保容量够不够
		for(int i=size-1;i>=index;i--){
			array[i+1]=array[i];
		}
		array[index]=element;
		size++;
	}
	
	//从后面删
	public void popBack(){
		if(size<=0){
			System.out.println("顺序表中没有元素");
			return;
		}
		array[size-1]=0;
		size--;
	}
	
	//从前面删
	public void popFront(){
		if(size<=0){
			System.out.println("顺序表中没有元素");
			return;
		}
		for(int i=1;i<size;i++){
			array[i-1]=array[i];
		}
		array[size]=0;
		size--;
	}
	
	//从任意位置删
	public void earse(int index){
		if(size<=0){
			System.out.println("顺序表中没有元素");
			return;
		}
		if(index<0||index>=size){
			System.out.println("输入的下标不对");
			return;
		}
		for(int i=index+1;i<size;i++){
			array[i-1]=array[i];
		}
		array[--size]=0;

	}
	
	//打印
	public void print(){
		System.out.println("打印顺序表：顺序表容量是:"+array.length);
		for(int i=0;i<size;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	//保证容量够用，否则进行扩容
	private void ensureCapacity(){
		if(size<array.length){  //容量够
			return;
		}
		int newCapacity=array.length*2; //新容量
		int[] newArray=new int[newCapacity];
		for(int i=0;i<size;i++){  //拷贝
			newArray[i]=array[i];
		}
		array=newArray;
	}
	
	//返回元素值为element的元素在顺序表中第一次出现的位置
	public int indexOf(int element){
		for(int i=0;i<size;i++){
			if(array[i]==element){
				return i;
			}
		}
		return -1;  //没有找到返回-1
	}
	
	//返回下标为Index的元素在顺序表中的值
	public int get(int index){
		if(index<0||index>=size){
			System.err.println("输入的下标有误");
			return -1;
		}
		return array[index];  //返回值
	}
	
	//把下标为Index的元素的值设置为element
	public void set(int index, int element){
		if(index<0||index>=size){
			System.err.println("输入的下标有误");
			return;
		}
		array[index]=element;
	}
	
	//删除顺序表中元素值为element元素的值，出现多次只删除第一次的
	public void remove(int element){
		int index=indexOf(element);  //找到被删除元素第一次出现的下标
		if(index!=-1){   //找到该元素
			earse(index);  //删除该下标的元素
		}
	}
	
	//返回顺序表中实际存储的元素个数
	public int size(){
		return size;
	}
	
	//判断顺序表是否为空
	public boolean isEmpty(){
		return size==0;
	}
	
	//删除顺序表中所有元素值为element的元素
	public void removeAll(int element){
		
		/*第一种:时间复杂度o(n^2),空间复杂度o(1)
		int index;
		while((index=indexOf(element)!=-1){   //直到为-1没有找到才退出
			earse(index);
		}
		*/
		
		/*第二种:时间复杂度o(n),空间复杂度o(n)
		int[] newArray=new int[array.length];
		int k=0;
		for(int i=0;i<size;i++){
			if(array[i]!=element){
				newArray[k++]=array[i];
			}
		}
		size=k;
		array=newArray;
		*/
		
		//第三种:时间复杂度o(n),空间复杂度o(1)
		int k=0;
		for(int i=0;i<size;i++){
			if(array[i]!=element){
				array[k++]=array[i];
			}
		}	
		size=k;
	}
	
	public static void main(String[] args){
		MyArrayList list=new MyArrayList();
		list.print();//顺序表容量是:3    空表
		list.pushFront(1);
		list.pushFront(2);
		list.pushFront(3);
		list.pushFront(4);
		list.print();//顺序表容量是:6    4 3 2 1
		list.insert(2, 10);
		list.insert(3, 20);
		list.print();//顺序表容量是:6    4 3 10 20 2 1
		list.earse(3);
		list.earse(3);
		list.print();//顺序表容量是:6    4 3 10 1
		list.pushBack(22);
		list.pushBack(33);	
		list.pushBack(44);	
		list.print();//顺序表容量是:12   4 3 10 1 22 33 44
		list.popBack();
		list.popBack();
		list.popBack();
		list.popBack();
		list.popBack();
		list.popBack();
		list.popBack();
		list.print();//顺序表容量是:12   空表
		list.popBack();	//报错：顺序表中没有元素
		int ret=list.size();
		System.out.println(ret);  //0
		
	}
}



32.
class A {
	private int a;
	public int getA(){
		return a;
	}
}

public class Review {
	public static void main(String[] args) {
		//System.out.println(new A().a);
		System.out.println(new A().getA());  //默认值0
	}
}

/*
Review.java:7: 错误: a 在 A 中是 private 访问控制
                System.out.println(new A().a);
*/
	
	
	
33.public class TestTime{
	private int hour;   //内部的外部不可见（好比加牛肉）
	private int minute;
	private int second;
	
	public TestTime(){
		
	}

	public TestTime(int hour,int minute,int second){
		if(hour<0||hour>23){
			System.err.println("输入的小时不对");
			return;
		}
		if(minute<0||minute>59){
			System.err.println("输入的分钟不对");
			return;
		}
		if(second<0||second>59){
			System.err.println("输入的秒数不对");
			return;
		}
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}

	public TestTime immutableAfter(int seconds){
		if(seconds<0){
			System.err.println("输入的描述不正确");
			return null;  
		}
		TestTime other = new TestTime(hour, minute, second);  //相当于把隐藏的this传了进来
		other.second+=seconds;
		while(other.second>=60){
			other.second-=60;
			other.minute+=1;
			if(other.minute>=60){
				other.minute=0;
				other.hour+=1;
				if(other.hour>=24){
					other.hour=0;
				}
			}
		}
		return other;
	}

	public String toString(){
		return String.format("%02d:%02d:%02d",hour,minute,second);
		//每个分别占2位，不够用0来补
	}
	
	public static void main(String[] args){
		TestTime now=new TestTime(8,38,26);
		TestTime nowAfter=now.immutableAfter(800);
		System.out.println(now);                  //08:38:26
		System.out.println(nowAfter);			  //08:51:46
		//注意：直接打印对象，就相当于调用对象.toString()方法
		
		System.out.println(now.toString());		  //08:38:26
		System.out.println(nowAfter.toString());  //08:51:46
	}
}







	public Time immutableAfter(int minutes, int seconds) {
		return null;
	}
	
	
	public Time immutableAfter(int hours, int minutes, int seconds) {
		return null;
	}
	
	// TODO: a - b 相差多少秒
	public static int diff(Time a, Time b) {
		return 0;
	}



34.
//链表
//前驱 previous   后继next

//这个类定义结点信息

class Node{
	int val;
	Node next;  //如果next==null表明这个结点是最后一个结点
	
	public Node(int val){
		this.val=val;         //每一个结点中存放的值
		this.next=null;		  //存的是下一个节点的引用
	}
	
	public String toString(){
		return String.format("Node(%d)",val);	
	}
}

//我的链表
public class MyLinkedList{
	public static void main(String[] args){
		Node head=null;	//刚开始链表中没有值
		/*
		head其实就是链表的第一个结点
		通过第一个结点就可以找到链表中的所有结点
		链表的第一个结点往往代表整个链表
		空的链表就是一个结点都没有的链表
		head==null代表第一个结点不存在，也就是整个链表为空	
		*/
		head=pushFront(head, 1);
		head=pushFront(head, 2);
		print(head);		//打印链表：2-->1-->null
		head=pushBack(head, 3);
		head=pushBack(head, 4);
		head=pushBack(head, 5);
		head=pushFront(head, 6);
		print(head);		//打印链表：6-->2-->1-->3-->4-->5-->null
		head=popFront(head);
		head=popFront(head);
		print(head);		//打印链表：1-->3-->4-->5-->null
		head=popBack(head);
		head=popBack(head);
		head=popBack(head);
		head=popBack(head);
		print(head);		//打印链表：null
		head=popBack(head); //链表为空，无法删除
		print(head);		//打印链表：null
		
	}
	
	//打印
	private static void print(Node head){
		System.out.print("打印链表:");
		Node cur=head;  //打印链表要保存head的值，防止head被改，
						//当主方法调用其它方法用到head时,head值已变
		for(cur=head;cur!=null;cur=cur.next){
			System.out.print(cur.val+"-->");   //cur.val当前结点的值
		}
		System.out.print("null");   //最后一个结点指向null
		System.out.println();
	}
	
	/*头插
		head:原来链表的第一个结点
		val:新节点的值（要插入结点的值）
		return:返回新的链表的第一个结点的值
	*/
	private static Node pushFront(Node head, int val){
		//1.创建新结点
		Node node=new Node(val);
		//2.让原来的head成为node的下一个结点
		node.next=head;
		//3.返回新的第一个结点
		return node;
	
	}
	
	//尾插
	private static Node pushBack(Node head, int val){
		Node node=new Node(val);
		if(head==null){  //链表为空
			return node;
		}else{
			Node last=head;
			while(last.next!=null){   //找到最后一个结点
				last=last.next;
			}
			last.next=node;    //将最后一个结点的下一个节点设置为node
			return head;
		}
	
	}
	//链表
//前驱 previous   后继next

//这个类定义结点信息

class Node{
	int val;
	Node next;  //如果next==null表明这个结点是最后一个结点
	
	public Node(int val){
		this.val=val;         //每一个结点中存放的值
		this.next=null;		  //存的是下一个节点的引用
	}
	
	public String toString(){
		return String.format("Node(%d)",val);	
	}
}

//我的链表
public class MyLinkedList{
	public static void main(String[] args){
		Node head=null;	//刚开始链表中没有值
		/*
		head其实就是链表的第一个结点
		通过第一个结点就可以找到链表中的所有结点
		链表的第一个结点往往代表整个链表
		空的链表就是一个结点都没有的链表
		head==null代表第一个结点不存在，也就是整个链表为空	
		*/
		head=pushFront(head, 1);
		head=pushFront(head, 2);
		print(head);		//打印链表：2-->1-->null
		head=pushBack(head, 3);
		head=pushBack(head, 4);
		head=pushBack(head, 5);
		head=pushFront(head, 6);
		print(head);		//打印链表：6-->2-->1-->3-->4-->5-->null
		head=popFront(head);
		head=popFront(head);
		print(head);		//打印链表：1-->3-->4-->5-->null
		head=popBack(head);
		head=popBack(head);
		head=popBack(head);
		head=popBack(head);
		print(head);		//打印链表：null
		head=popBack(head); //链表为空，无法删除
		print(head);		//打印链表：null
		
	}
	
	//打印
	private static void print(Node head){
		System.out.print("打印链表:");
		Node cur=head;  //打印链表要保存head的值，防止head被改，
						//当主方法调用其它方法用到head时,head值已变
		for(cur=head;cur!=null;cur=cur.next){
			System.out.print(cur.val+"-->");   //cur.val当前结点的值
		}
		System.out.print("null");   //最后一个结点指向null
		System.out.println();
	}
	
	/*头插
		head:原来链表的第一个结点
		val:新节点的值（要插入结点的值）
		return:返回新的链表的第一个结点的值
	*/
	private static Node pushFront(Node head, int val){
		//1.创建新结点
		Node node=new Node(val);
		//2.让原来的head成为node的下一个结点
		node.next=head;
		//3.返回新的第一个结点
		return node;
	
	}
	
	//尾插
	private static Node pushBack(Node head, int val){
		Node node=new Node(val);
		if(head==null){  //链表为空
			return node;
		}else{
			Node last=head;
			while(last.next!=null){   //找到最后一个结点
				last=last.next;
			}
			last.next=node;    //将最后一个结点的下一个节点设置为node
			return head;
		}
	
	}
	
	//前删
	private static Node popFront(Node head){
		if(head==null){
			System.err.println("链表为空，无法删除");
			return null;
		}
		return head.next;   //返回第二个结点
							//原来第一个结点会因为没有指向而被回收
	}
	
	//尾删
	private static Node popBack(Node head){
		if(head==null){
			System.err.println("链表为空，无法删除");
			return null;
		}
		if(head.next==null){  //原来的链表只有一个结点
			return null;
		}else{
			Node lastSecond=head;
			while(lastSecond.next.next!=null){  //找到倒数第二个结点
				lastSecond=lastSecond.next;  //更新
			}
			lastSecond.next=null;	//把倒数第二个结点的下一个结点设置为空
			return head;
		}
	}
}
	//前删
	private static Node popFront(Node head){
		if(head==null){
			System.err.println("链表为空，无法删除");
			return null;
		}
		return head.next;   //返回第二个结点
							//原来第一个结点会因为没有指向而被回收
	}
	
	//尾删
	private static Node popBack(Node head){
		if(head==null){
			System.err.println("链表为空，无法删除");
			return null;
		}
		if(head.next==null){  //原来的链表只有一个结点
			return null;
		}else{
			Node lastSecond=head;
			while(lastSecond.next.next!=null){  //找到倒数第二个结点
				lastSecond=lastSecond.next;  //更新
			}
			lastSecond.next=null;	//把倒数第二个结点的下一个结点设置为空
			return head;
		}
	}
}
	
	
	
35./*逆置面试题
1-->2-->3-->4-->5
5-->4-->3-->2-->1
*/

/*方法1
不断从原来链表中取出结点，采用头插法到一个新链表上
*/
class Solution1{
    public ListNode reverseList(ListNode head){
		if(head==null){ //链表中无结点
			return null;
		}
		ListNode dest=null;  //空的新链表，dest为新链表的第一个结点
		ListNode cur=head;  //设置cur用来遍历旧链表
		
		while(cur!=null){  //遍历旧链表
			ListNode next=cur.next;		//cur.next的值会发生改变，所以要保留
			cur.next=dest;  //把每个遍历到的结点(cur)，头插到新链表中（dest代表的新链表）
			dest=cur;  //更新最新的第一个结点
			cur=next;	
		}
		return dest;
	}
}
     
 /*方法2
 设置三个结点p1,p2,p3
 */
class Solution2{
    public ListNode reverseList(ListNode head){
		if(head==null){	//链表中无结点
			return null;
		}
		ListNode p1=null;
		ListNode p2=head;
		while(p2!=null){
			ListNode p3=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p3;		
		}
		return p1;
	}
}

 /*方法3
 设置三个结点p1,p2,p3
 */
class Solution3{
    public ListNode reverseList(ListNode head){
		if(head==null){	//链表中无结点
			return null;
		}
		ListNode p1=null;
		ListNode p2=head;
		ListNode p3=head.next;
		
		while(p2!=null){
			p2.next=p1;
			p1=p2;
			p2=p3;	
			if(p3!=null){  //必须判断p3是否为空，因为不判断若对null进行操作，就会产生空指针异常
				p3=p3.next;  //判断无误后，进行p3值的更新
			}
		}
		return p1;
	}
}



36.class Node{
	int val;
	Node next=null;
	Node(int val){
		this.val=val;
	}
	
}

//头插
Node pushFront(Node head,int val){
	Node node=new Node(val);
	node.next=head;
	return node;
}

//尾插
Node pushBack(Node head,int val){
	Node node=new Node(val);
	if(head==null){   //尾插一定要记得链表为空的情况
		return node;
	}
	/*第一种
	Node last=null;
	while(last.next!=null){
		last=last.next;
	}
	last.next=node;
	*/
	
	//第二种
	//注意last必须定义在for循环外边，
	//要是last定义在for循环里边，那么last的作用域就为for循环内部
	//循环结束就被释放了
	Node last=null;
	for(last;last.next!=null;last=last.next){
		;
	}
	last.next=node;
	return head;
}

//逆序(第一种）
Node reverse(Node head){
	Node p1=null;
	Node p2=head;
	while(p2!=null){
		Node p3=p2.next;
		p2.next=p1;
		p1=p2;
		p2=p3;
	}
	return p1;
}

//逆序(第二种）
Node reverse(Node head){
	Node p1=null;
	Node p2=head;
	Node p3=head.next;
	while(p2!=null){
		p2.next=p1;
		p1=p2;
		p2=p3;
		if(p3!=null){  //防止空指针异常
			P3=P3.next;
		}		
	}
	return p1;
}



37.class Node{
    int val;   //结点里的值
    Node next=null;   
    Node(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return String.format("Node(%d)",val);
    }
}

public class MyLinkedList {
    public static void main(String[] args){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(2);
        head.next.next.next=new Node(4);
        print(head); //打印链表:1-->2-->2-->4-->null
        pushAfter(head.next, 200);
        pushAfter(head.next.next, 100);
        print(head);//打印链表:1-->2-->200-->100-->2-->4-->null
        popAfter(head.next);
        print(head);//打印链表:1-->2-->100-->2-->4-->null
        removeElements4(head, 2);
        print(head);//打印链表:1-->100-->4-->null
        Node l1=new Node(1);
        l1.next=new Node(10);
        Node l2=new Node(8);
        l2.next=new Node(9);
        Node paixu=mergeTwoLists2(l1, l2);
        print(paixu); //打印链表:1-->8-->9-->10-->null

    }

    //在pos位置之后插入一个结点，结点值为val
    private static void pushAfter(Node pos, int val){
        Node node=new Node(val);
        node.next=pos.next;
        pos.next=node;
    }

    //删除位置为pos的后一个结点
    private static void popAfter(Node pos){
        pos.next=pos.next.next;
    }

    /*移除链表中所有值为val的结点(方法一)
    * 创建一个新的链表，采用尾插法
    * 把所有元素值不是val的结点插到新链表
    * */
    public static Node removeElements1(Node head, int val){
        Node result=null;	//新链表
        Node cur=head;		//当前结点
        Node last=null;		//新链表的最后一个结点
        while(cur!=null){
            if(cur.val==val){ 
                cur=cur.next;  //越过当前结点，从下一个结点判断
                continue;
            }
            Node next=cur.next;//尾插法
            cur.next=null;
            if(result==null){ //新链表为空
                result=cur;
            }else {
                last.next = cur;
            }
            last=cur;
            cur=next;
        }
        return result; //rusult为新链表的头结点
    }

    //判断若被删结点刚好第一个结点是，那么特殊处理（不创建新链表）
    public static Node removeElements2(Node head, int val){
        Node prev=null;	  //当前结点的前驱结点
        Node cur=head;	  //当前结点
        while(cur!=null){
            if(cur.val==val){
                if(cur==head){
                    head=cur.next;  //头变为第二个结点
                }
                else{
                    prev.next=cur.next;
                }
            }
            else{
                prev=cur;
            }
            cur=cur.next;
        }
        return head;
    }

    //先避开一个结点回头再说（不创建新链表）
    public static Node removeElements3(Node head, int val){
        Node prev=head;//当前结点的前驱结点
        Node cur=head.next;//当前结点
        while(cur!=null){
            if(cur.val==val){
                    prev.next=cur.next;
            }
            else{
                prev=cur;
            }
            cur=cur.next;
        }
        if(head.val==val){
            head=head.next;
        }
        return head;
    }

    //强行给第一个结点找一个前驱结点，前驱结点里面的值无所谓（不创建新链表）
    public static Node removeElements4(Node head, int val){
        Node tempHead=new Node(-1);
        tempHead.next=head;
        Node prev=tempHead;//上一个结点
        Node cur=head;//当前结点
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
            }
            else{
                prev=cur;
            }
            cur=cur.next;
        }
        return tempHead.next;
    }

    //有两个升序链表  请把他们按顺序排成一个升序链表（递归法）
    public static Node mergeTwoLists1(Node l1, Node l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){ //统一以l1为链开始链接
            l1.next=mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists1(l1,l2.next);
            return l2;
        }

    }

	//有两个升序链表  请把他们按顺序排成一个升序链表（采用建立新链表，尾插法）
    public static Node mergeTwoLists2(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node result = null;   //新的链表
        Node last = null;	//新的链表的最后一个结点
        Node cur1 = l1;
        Node cur2 = l2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                Node next = cur1.next;
                cur1.next=null;
                if (result == null) { //当前链表为空
                    result = cur1;
                } else {
                    last.next = cur1;   //当前结点和最后一个结点的下一个结点相连
                }
                last = cur1;  //更新最后一个结点
                cur1 = next;
            } else {
                Node next = cur2.next;
                cur2.next=null;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;

                cur2 = next;
            }
        }
		//有可能一个链表遍历完了
        if (cur1 != null) {
            last.next = cur1;  //最后一个结点与l1剩下的结点相连
        } else {
            last.next = cur2;
        }

        return result;
    }


    //打印
    private static void print(Node head){
        System.out.print("打印链表:");
        Node cur=head;  //打印链表要保存head的值，防止head被改，
        //当主方法调用其它方法用到head时,head值已变
        for(cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.val+"-->");   //cur.val当前结点的值
        }
        System.out.print("null");   //最后一个结点指向null
        System.out.println();
    }
}



38.1.第一题
/*编写代码，以给定值x为基准将链表分割成两部分
  所有小于x的结点排在大于等于x的结点的左边
  注意分割以后保持原来的数据顺序不变
  3	1 2 4 9 5 8 6 3 9 7  假设x=5
  前：3 1 2 4 3    后： 9 5 8 6 9 7
  思路：创建两个新链表（采用尾插法）
		有可能结果只有一个链表
		保证最终链表的最后一个结点的next是null
*/

//第一种
public Node partition(Node head,int x){
	Node result1=null;  //新链表1
	Node result2=null;  //新链表2
	Node last1=null;	//新链表1的最后一个结点
	Node last2=null;	//新链表2的最后一个结点
	Node cur=head;		//当前链表的遍历结点
	while(cur!=null){
		if(cur.val<x){
			Node next=cur.next;
			cur.next=null;	//已经把当前结点的下一个节点设置为null
			if(result1==null){//空链表
				result1=cur;
			}
			else{
				last1.next=cur;
			}
			last1=cur;
			cur=next;
		}
		else{
			Node next=cur.next;
			cur.next=null;
			if(result2==null){
				result2=cur;
			}
			else{
				last2.next=cur;
			}
			last2=cur;
			cur=next;
		}
	}
	if(result1==null){
		return result2;
	}
	else if(result2==null){
		return result1;
	}
	else{
		cur1.next=result2; //两个链表都不为空的情况
		//不用给最后一个结点设置为null，因为前面已经设置了
	}
}

//第二种
public Node partition(Node head,int x){
	Node small=null;   //存小值的链表
	Node smallLast=null;  //最后一个结点
	
	Node big=null;     //存大值的链表
	Node bigLast=null;    //最后一个结点
	Node cur=head;     //用于遍历的
	while(cur!=null){
		if(cur.val<x){
			if(small==null){
				small=cur;
			}
			else{
				smallLast.next=cur;
			}
			smallLast=cur;
			cur=cur.next;
		}
		else{
			if(big==null){
				big=cur;
			}
			else{
				bigLast.next=cur;
			}
			bigLast=cur;
			cur=cur.next;
		}
	}
	if(small==null){
		return big;
	}else {   //小链表不为空的情况
		smallLast.next=big;
		if(bigLast!=null){
			bigLast.next=null;  //大链表的最后一个结点设为空
		}	
		return small;
	}
}

2.第二题
/*返回链表的中间结点
奇数返回最中间的结点1-->2-->3-->4-->5-->null    3(5/2=2走两步）
偶数返回中间的下一个结点1-->2-->3-->4-->null    3（4/2=2走两步）
*/

//第一种
class Solution {
    private int getLength(Node head){
		Node cur=head;
		int len=0;
		for(cur;cur!=null;cur=cur.next){
			len++;
		}
		return len;
	}
	public Node middleNode(Node head){
		int steps=getLength(head)/2;
		Node node=head;
		for(int i=0;i<steps;i++){
			node=node.next;
		}
		return node;
}


//第二种
/*快的走两步，慢的走一步，最后返回慢的结点
（我走了100米时，你差不多就走了50米,）
  采用快走，慢走，快走进行
*/
class Solution {
    public Node middleNode(Node head){
		Node fast=head;
		Node slow=head;
		while(fast!=null){  //只要快的不为null,那么慢的肯定不为Null
			fast=fast.next;//快的先走一步
			if(fast==null){   //快的为Null就退出，返回slow
				break;
			}
			slow=slow.next;//慢的走一步
			fast=fast.next;  //此时不用判断fast为不为null,因为进循环要判断
		}
		return slow;
	}
}


3.第三题（输出链表的倒数第k个结点）
/*
思考：如果链表长度<k怎么办
//		如果>=k怎么办
	输出链表的倒数第k个结点，链表结点要至少为K个	
*/

//第一种
/*  p1比p2先走k步，等到p1到达链表末尾
    p2也就到了倒数第k个位置
*/
public class Solution {
    public Node FindKthToTail(Node head,int k){
		Node front=head;
		Node back=head;
		for(int i=0;i<k;i++){
			if(front==null){  //链表的长度不够k
				return null;
			}
			front=front.next;
		}//走到这front比back多走了k步
		while(front!=null){  //两者都一步一步走
			back=back.next;
			front=front.next;
		}
		return back;
	}
}



//第二种
/*遍历计算出链表的结点个数
  如果小于k返回Null
*/
public class Solution {
	private int getLength(Node head){
		Node cur=head;
		int len=0;
		for(cur;cur!=null;cur=cur.next){
			len++;
		}
		return len;
	}
	
    public Node FindKthToTail(Node head,int k){
		int len=getLength(head);  //计算链表长度
		if(len<k){  //链表长度不够k
			return null;
		}
		Node cur=head;
		int steps=len-k;   //走几步就到倒数第K个结点
		for(int i=0;i<steps;i++){
			cur=cur.next;
		}
		return cur;
	}
}

4.第四题
/*知道Pos位置的结点，要求删除这个结点，不知道链表头结点在哪
---?---?---pos---?---?---null
---?---?---?---?---null
思路：把pos.next结点的值给pos
*/

public Node removePos(Node pos){
	pos.val=pos.next.val;
	pos.next=pos.next.next;
}

5.第五题(判断链表是不是回文的)
/*
先找到链表的中间节点，奇数就是最中间的，偶数就是中间的下一个
将后半部分链表逆置
比较前后两个链表  分别对应的每一个结点的值
1-->2-->3-->2-->1
1-->3-->1
*/

public class PalindromeList {
	public boolean chkPalindrome(Node A){
		Node mid=getMid(A);
		Node result=reverse(mid);//从mid结点开始往后逆序
		Node cur1=A;
		Node cur2=result;
		while(cur1!=null&&cur2！=null){//遍历
			if(cur1.val!=cur2.val){
				return false;
			}
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return true;
	}
	
	public Node getMid(Node head){  //得到链表的中间节点
		Node fast=head; 
		Node slow=head;
		while(fast!=null){   //只要fast!=null  那么slow也就不为Null
			fast=fast.next;  
			if(fast==null){
				break;  //return slow;
			}
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	public Node reverse(Node head){ //逆序采用头插法
		Node result=null;
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			cur.next=result;
			result=cur;
			cur=next;	
		}
		return result;
	}
}

6.第六题（在一个升序链表中删除链表中所有有出现两次以上的结点）
/*1-->2-->3-->3-->4-->4-->5-->6-->null
  1-->2-->5-->6-->null
*/
public class Solution {
    public Node deleteDuplication(Node Head){
		if(head==null) return null;//链表没有结点
		Node prev=null;
		Node p1=head;
		Node p2=head.next;
		while(p2！=null){//p1,p2要进行比较，p2不为空，p1也就不为空
			if(p1.val!=p2.val){
				prev=p1;
				p1=p2;   //只要前后两值不相等就遍历
				p2=p2.next;
			}
			else{
				while(p2!=null&&p1.val==p2.val){//找到值与p1不相等的结点
					p2=p2.next;
				}
				if(prev==null){
					head=p2;
				}
				else{
					prev.next=p2;
				}	
				p1=p2;//p1,p2两个从同一个位置开始重新比较
				if(p2!=null){
					p2=p2.next;//比较的时候p2要在p1的后边，所以要p2=p2.next
				}
	
			}
		}
		return head;
	}
}



39.class Node{
    int val;
    Node next=null;
    Node(int val){
        this.val=val;
    }
}

public class Solution {
    public static void main(String[] args) {
        Node head=createList();
        Node result=new Solution().removeAll(head, 6);
        for(Node cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");//6-->1-->2-->3-->null
        System.out.println();
        System.out.println("=====================");
        for(Node cur=result;cur!=null;cur=cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");//1-->2-->3-->null
        System.out.println();
        System.out.println("=====================");
        Node head1=createList1();
        Node head2=createList2();
        Node merged=new Solution().merge(head1, head2);
        for(Node cur=merged;cur!=null;cur=cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");//1-->2-->3-->6-->null
    }

    public static Node createList(){
        Node p1=new Node(6);
        Node p2=new Node(1);
        Node p3=new Node(6);
        Node p4=new Node(6);
        Node p5=new Node(2);
        Node p6=new Node(3);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        return p1;
    }

    public static Node createList1(){
        Node p1=new Node(1);
        Node p2=new Node(6);
        p1.next=p2;
        return p1;
    }

    public static Node createList2(){
        Node p1=new Node(2);
        Node p2=new Node(3);
        p1.next=p2;
        return p1;
    }

    Node removeAll(Node head, int val){
        Node prev=null;
        Node cur=head;
        while(cur!=null){
            if(cur.val==val){
                if(cur==head){
                    head=cur.next;
                }
                else{
                    prev.next=cur.next;
                }
            }
            else{
                prev=cur;
            }
            cur=cur.next;
        }
        return head;
    }

    Node merge(Node head1, Node head2){
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node result=null;
        Node last=null;
        Node cur1=head1;
        Node cur2=head2;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                if(result==null){
                    result=cur1;
                }
                else{
                    last.next=cur1;
                }
                last=cur1;
                cur1=cur1.next;
            }
            else{
                if(result==null){
                    result=cur2;
                }
                else{
                    last.next=cur2;
                }
                last=cur2;
                cur2=cur2.next;
            }
        }
        if(cur1!=null){
            last.next=cur1;
        }
        else{
            last.next=cur2;
        }
        return result;
    }
}



40./*这是一份错误的代码
  通过这份代码学会简单的调试
*/
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this(val, null); //调用另一个构造方法
    }
}


public class LinkedListInterview {
    public static void main(String[] args) {
        test();
    }

    // 三个重要节点
    // 1. 咱创建的测试链表是不是出问题了？
    // 2. 咱的分离程序是不是出问题了？
    // 3. 咱的打印程序是不是出问题了？

    private static void test() {
        // 4 5 2 7 6 3 8 1
        ListNode head = createTestList();
        ListNode result = new LinkedListInterview().separateByX(head, 5);
        // 4 2 3 1 5 7 6 8
        for (ListNode cur = result; cur != null; cur = cur.next) {
            System.out.print(cur.val+"-->");
        }
    }

    private static ListNode createTestList() {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(8);
        ListNode n8 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next=null;

        return n1;
    }

    public ListNode separateByX(ListNode head, int x) {
        ListNode sHead = null; //左半部分
        ListNode sEnd = null;
        ListNode bHead = null; //右半部分
        ListNode bEnd = null;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                if (sHead == null) {
                    sHead = cur;
                } else {
                    sEnd.next = cur;
                }
                sEnd = cur;
            } else {
                if (bHead == null) {
                    bHead = cur;
                } else {
                    bEnd.next = cur;
                }
                bEnd = cur;
            }
        }

        if (sEnd == null) {
            return bHead;
        }
        /*这里有问题,应该让bEnd.next=null;
        sEnd.next = bHead;
        return sHead;
        */

        //改正为
        sEnd.next = bHead;
        if(bEnd!=null){
            bEnd.next=null;  //一定要让链表的最后一个结点指向null
        }
        return sHead;
    }
}



41./*1.第一题
判断两个链表是否相交，如果相交返回相交交点
*/

public class Solution {
    private int getLength(Node head){//求链表的长度
		int len=0;
		Node cur=head;
		for(cur;cur!=null;cur=cur.next){
			len++;
		}
		return len;
	}

	public Node getIntersectionNode(Node headA, Node headB){
		int lenA=getLength(headA);//链表A的长度
		int lenB=getLength(headB);//链表B的长度
		
		Node longer=headA;  //假设长链表是A
		Node shorter=headB; //假设短链表是B
		int diff=lenA-lenB; //短长链表的长度差
		if(diff<0){   //如果长度差<0说明，短长链表要互换
			longer=headB;
			shorter=headA;
			diff=lenB-lenA;
		}
		for(int i=0;i<diff;i++){ //先让长链表多走diff步
			longer=longer.next;
		}
		while(longer!=shorter){  //只要结点不相交就后移
			longer=longer.next;
			shorter=shorter.next;
		}
		return shorter;//返回shorter、longer都可以
	}
}
	
/*2.第二题（判断链表中是否存在回环,若回环存在则返回环的入口点）
两种思路：1)起点设置为p，相遇点设置为q，将相遇点的.next设置为null
			就相当第一题的求相交点问题
			有相交点就有回环，相交点就是环的入口点
		  2)快慢指针法（快的每次2步，慢的每次1步）
		    一个引用从起点出发，一个引用从相遇点出发
			一定会在环的入口点相遇
		 ----快的一次n(n>=3)步不可以，有可能会一直错过
*/

//方法一
public class Solution {
    public Node detectCycle(Node head) {
	Node fast=head;
		Node slow=head;
		// fast 遇到 null，表示不带环，返回 null
		// fast == slow，表示遇到相遇点了,两点相遇了
		
		/*while循环不行，因为一开始fast本来就等于slow
		  循环会认为这是相遇点，所以先要保证循环执行一次在判断
		  需要用do...while循环
		while(fast!=slow){
			if(fast==null){
				return null;
			}
			fast=fast.next;
			if(fast==null){
				return null;
			}
			fast=fast.next;
			slow=slow.next;
		}
		*/
		
		do{
			if(fast==null){  //判断是否第一个结点就是null
				return null;
			}
			fast=fast.next;
			if(fast==null){
				return null;
			}
			fast=fast.next;
			slow=slow.next;
		}while(fast!=slow);//退出循环就是相遇点
		
		Node p=head;//起始点
		Node q=slow.next;//保存相遇点的.next
		slow.next=null;//将相遇点的.next设置为null
		//从这里开始找两个链表的交点
		Node dest=getIntersectionNode(p, q);
		if(dest!=null){
			return dest;//dest为环的入口点
		}
	}
	
	private int getLength(Node head){//求链表的长度
		int len=0;
		Node cur=head;
		for(cur;cur!=null;cur=cur.next){
			len++;
		}
		return len;
	}

	public Node getIntersectionNode(Node headA, Node headB){
		int lenA=getLength(headA);//链表A的长度
		int lenB=getLength(headB);//链表B的长度
		
		Node longer=headA;  //假设长链表是A
		Node shorter=headB; //假设短链表是B
		int diff=lenA-lenB; //短长链表的长度差
		if(diff<0){   //如果长度差<0说明，短长链表要互换
			longer=headB;
			shorter=headA;
			diff=lenB-lenA;
		}
		for(int i=0;i<diff;i++){ //先让长链表多走diff步
			longer=longer.next;
		}
		while(longer!=shorter){  //只要结点不相交就后移
			longer=longer.next;
			shorter=shorter.next;
		}
		return shorter;//返回shorter、longer都可以
	}
	
}


//方法二
public class Solution {
    public Node detectCycle(Node head) {
		Node fast=head;
		Node slow=head;
		// fast 遇到 null，表示不带环，返回 null
		// fast == slow，表示遇到相遇点了,两点相遇了
		
		/*while循环不行，因为一开始fast本来就等于slow
		  循环会认为这是相遇点，所以先要保证循环执行一次在判断
		  需要用do...while循环
		while(fast!=slow){
			if(fast==null){
				return null;
			}
			fast=fast.next;
			if(fast==null){
				return null;
			}
			fast=fast.next;
			slow=slow.next;
		}
		*/
		
		do{
			if(fast==null){  //判断当前结点是否就是null
				return null;
			}
			fast=fast.next;
			if(fast==null){
				return null;
			}
			fast=fast.next;
			slow=slow.next;
		}while(fast!=slow);//退出循环就是相遇点
		
		Node p=head;//起始点
		Node q=slow;//相遇点
		while(p!=q){  //相遇点和起始点相同则为环的入口点
			p=p.next;
			q=q.next;
		}
		return p;
	}
}



/*3.第三题（对一个链表进行拷贝）
注意：拷贝不能改变原链表，只进行值得拷贝
浅拷贝
*/

Node copy(Node head){
	Node result=null;
	Node last=null;
	Node cur=head;
	while(cur!=null){
		Node node=new Node();//开辟一个新的结点
		node.val=cur.val;//把当前结点的值复制一份到node结点
		if(result==null){
			result=node;
		}
		else{
			last.next=node;
		}
		last=node;
		cur=cur.next;
	}
}

	
/*第四题（复杂链表深拷贝）
注意只是值和指向关系的拷贝，不改变原链表的结点之间的联系
题目：给定一个链表，每个结点包含一个额外增加的随机指针，
	  该指针可以指向链表中的任何结点或空结点
	  要求返回这个链表的深拷贝
	  
思路：1.先复制所有结点
      2.处理random指向
*/	

//深拷贝
    public CNode complexCopy(CNode head) {
        if (head == null) {	//空链表返回null
            return null;
        }
        CNode p1 = head;
		//（老-新-老-新...）
        while (p1 != null) {//P1用于遍历旧链表
            CNode p2 = new CNode(p1.val);
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;//旧链表的下一个结点
        } 

        p1 = head;//从头开始
		//处理random
        while (p1 != null) {
            CNode p2 = p1.next; //和p1的值是相对那个节点，p1的下一个结点
            if (p1.random != null) {
                p2.random = p1.random.next;
            }

            p1 = p2.next;//旧链表的下一个结点
        }

        p1 = head;		//旧链表的第一个结点
        CNode newHead = head.next;//先保存一份新链表的第一个结点

        while (p1 != null) {
            CNode p2 = p1.next;//p1的下一个结点

            p1.next = p2.next;//链接旧链表
            if (p2.next != null) {
                p2.next = p2.next.next;//链接新链表
            }

            p1 = p1.next;
        }
		//p2为新链表的第一个结点和newHead类似
        return newHead;//返回新拷贝的链表
    }
	

	
42.public class CNode {
    int val;
    CNode next=null;
    CNode random=null;

    public CNode(int val){
        this.val=val;
    }
}

public class Solution {
    /*按x分割列表，小于x的放在大于等于x的前面
    遍历整个链表，把小于 x 的尾插到result1
                  把大于等于 x 的尾插到result2
    理想情况下，把result2接到sesult1后边
    1) 如果result1为null，直接返回result2(result2可能为空）
    2) 保证，返回链表的最后一个结点.next == null
    */

    /*尾插
    1. 先分情况讨论：
       1）如果当前链表为空，要插入的结点就是链表的第一个结点
       2) 如果链表不为空，
                1. 先找到当前的链表最后一个结点
                2. 让当前链表的最后一个结点.next = 要插入的结点
                3. 如果每次的最后一个结点都是我们插入的结点
                    可以记录上次插入的最后一个结点
                4. 不要忘记更新最后一个结点（即last)
     */
    public Node separateX(Node head,int x){
        Node result1=null;//记录小链表的第一个结点
        Node result2=null;//记录小链表的最后一个结点
        Node last1=null;
        Node last2=null;
        Node cur=head;
        while(cur!=null){
            if(cur.val<x){
                /* 尾插到小的链表中 */
                if(result1==null){
                    result1=cur;
                }
                else{
                    last1.next=cur;
                }
                last1=cur;
                cur=cur.next;
            }
            else{/* 尾插到大的链表中 */
                if(result2==null){
                    result2=cur;
                }
                else{
                    last2.next=cur;
                }
                last2=cur;
                cur=cur.next;
            }
        }
        if(result1==null){
            return result2;
        }
        else{
            last1.next=result2;
            if(last2!=null){
                last2.next=null;
            }
            return result1;
        }
    }


    //删除有序链表中的重复结点
    public Node deleteDuplicated(Node head){
        if(head==null) return null;
        Node prev=null;
        Node p1=head;
        Node p2=head.next;
        while(p2!=null){  //遍历，只要p2不为空，p1肯定不为空
            if(p1.val!=p2.val){
                prev=p1;   //三者同时往后走
                p1=p2;
                p2=p2.next;
            }
            else{
                while(p2!=null&&p1.val==p2.val){
                    p2=p2.next;  //直到遇见p1.val!=p2.val才退出循环
                }
                if(prev==null){
                    head=p2;  //要删除的结点就是第一个结点
                }
                else{
                    prev.next=p2;//删除prev到p2之间该删除的结点
                }
                p1=p2;//两者处于同一位置重开始判断
                if(p2!=null){//小心空指针异常
                    p2=p2.next;
                }
            }
        }
        return head;
    }

    //深拷贝
    public CNode complexCopy(CNode head) {
        if (head == null) {
            return null;
        }
        CNode p1 = head;
        while (p1 != null) {
            CNode p2 = new CNode(p1.val);
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
        }

        p1 = head;
        while (p1 != null) {
            CNode p2 = p1.next;
            if (p1.random != null) {
                p2.random = p1.random.next;
            }

            p1 = p2.next;
        }

        p1 = head;
        CNode newHead = head.next;

        while (p1 != null) {
            CNode p2 = p1.next;

            p1.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            }

            p1 = p1.next;
        }

        return newHead;
    }
}



43.public class Node {
    int val;
    Node next=null;

    public Node(int val){
        this.val=val;
    }

    public String toString(){
        return String.format("Node(%d)",val);
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        testSeparateX(solution);
        testDeleteDuplicated(solution);
        testComplexCopy(solution);
    }

    private static void testSeparateX(Solution solution) {
        Node head1 = prepareListForSeparateX1();//创建链表
        Node result1 = solution.separateX(head1, 5);
        print(result1);

        Node head2 = prepareListForSeparateX2();//创建链表
        Node result2 = solution.separateX(head2, 5);
        print(result2);

        Node head3 = prepareListForSeparateX3();//创建链表
        Node result3 = solution.separateX(head3, 5);
        print(result3);
    }

    private static void testDeleteDuplicated(Solution solution) {
        Node head1 = prepareListForDeleted1();//创建链表
        Node result1 = solution.deleteDuplicated(head1);
        print(result1);

        Node head2 = prepareListForDeleted2();//创建链表
        Node result2 = solution.deleteDuplicated(head2);
        print(result2);

        Node head3 = prepareListForDeleted3();//创建链表
        Node result3 = solution.deleteDuplicated(head3);
        print(result3);

        Node head4 = null;//创建链表使链表为Null
        Node result4 = solution.deleteDuplicated(head4);
        print(result4);
    }

    private static void testComplexCopy(Solution solution) {
        CNode n1 = new CNode(1);
        CNode n2 = new CNode(2);
        CNode n3 = new CNode(3);
        CNode n4 = new CNode(4);

        n1.random = n3; n2.random = n1; n3.random = n3;
        n1.next = n2; n2.next = n3; n3.next = n4;

        CNode result = solution.complexCopy(n1);//引用变量.方法名（）；
        System.out.println("成功");
    }

    private static Node prepareListForSeparateX1() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static Node prepareListForSeparateX2() {
        Node n1 = new Node(9);
        Node n2 = new Node(9);
        Node n3 = new Node(9);
        Node n4 = new Node(9);
        Node n5 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static Node prepareListForSeparateX3() {
        Node n1 = new Node(9);
        Node n2 = new Node(1);
        Node n3 = new Node(8);
        Node n4 = new Node(2);
        Node n5 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static Node prepareListForDeleted1() {
        Node n1 = new Node(9);
        Node n2 = new Node(9);
        Node n3 = new Node(9);
        Node n4 = new Node(9);
        Node n5 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static Node prepareListForDeleted2() {
        Node n1 = new Node(8);
        Node n2 = new Node(8);
        Node n3 = new Node(9);
        Node n4 = new Node(9);
        Node n5 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static Node prepareListForDeleted3() {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    private static void print(Node head){
        for( Node cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.println("null");
    }
}



44.//MyLinkedList.java
class Node {
    int val;
    Node next = null;   // 指向后继结点，最后一个结点的 next == null
    Node prev = null;   // 指向前驱结点，第一个结点的 prev == null

    Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    private Node head = null;//链表的第一个结点
    private Node last = null;//链表的最后一个结点
    private int size = 0;//链表中结点的个数

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();//创建一个空链表
        list.pushFront(1);//头插
        list.pushFront(2);
        list.pushFront(3);
        System.out.println("头插后：3 2 1");
        list.popFront();//头删
        list.popFront();
        list.popFront();
        System.out.println("头删后：空链表");
        list.pushBack(10);//尾插
        list.pushBack(20);
        list.pushBack(30);
        System.out.println("尾插后：10 20 30");
        list.popBack();//尾删
        list.popBack();
        list.popBack();
        System.out.println("尾删后：空链表");
        list.pushBack(1);//尾插
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        System.out.println("尾插后：1 2 3 4 5");
        list.add(1, 10);
        System.out.println("1 10 2 3 4 5");
        list.add(5, 20);
        System.out.println("1 10 2 3 4 20 5");
        list.remove(1);
        System.out.println("1 2 3 4 20 5");
        list.remove(4);
        System.out.println("1 2 3 4 5");
    }

    //头插
    public void pushFront(int val) {
        Node node = new Node(val);//先创建一个结点
        node.next = head;
        if (head != null) {
            head.prev = node;
        } else {
            last = node;
        }
        head = node;//不管怎样head都是刚插进来的结点
        size++;
    }

    //头删
    public void popFront() {
        if (size <= 0) {
            System.out.println("无法对空链表做删除");
            return;
        }
        head = head.next;
        if (head != null) {//这个新的head不为空
            head.prev = null;
        } else {
            last = null;
        }
        size--;
    }

    //尾插
    void pushBack(int val) {
        Node node = new Node(val);//先创建一个新的结点
        if (last == null) {//链表为空
            head = node;
        } else {
            last.next = node;
        }
        node.prev = last;
        last = node;//只要插入结点，这个结点就是最后一个结点
        size++;
    }

    //尾删
    void popBack() {
        if (size <= 0) {
            System.out.println("无法对空链表做删除");
            return;
        }

        if (last == head) {//原链表本来就只有一个结点删除后为空链表
            head = last = null;
        } else {
            last.prev.next = null;
            last = last.prev;//Last成倒数第二个结点
        }
        size--;
    }

    //往下标为Index的结点前插入一个结点，该节点的值为val
    public void add(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("下标错误");
            return;
        }
        if (index == 0) {
            pushFront(val);//头插
        } else if (index == size) {
            pushBack(val);//尾插
        } else {
            Node pos = getNode(index);//得到此下标处的结点
            Node node = new Node(val);//创建一个新的结点
            node.prev = pos.prev;
            node.next = pos;
            node.prev.next = node;
            node.next.prev = node;
            size++;
        }
    }

    //删除下标为Index的结点
    public void remove(int index) {
        if (size <= 0) {
            System.out.println("无法对空链表做删除");
            return;
        }

        if (index < 0 || index >= size) {
            System.out.println("下标错误");
            return;
        }

        if (index == 0) {
            popFront();//头删
        } else if (index == size - 1) {
            popBack();//尾删
        } else {
            Node pos = getNode(index);//得到下标为index处的结点
            pos.prev.next = pos.next;
            pos.next.prev = pos.prev;
            size--;
        }
    }

    //得到下标为index的结点
    private Node getNode(int index) {
        // 代码的复用性，所以创建一个方法
        // 不需要校验 index 的合法性
        // 因为使用者 add 和 remove 已经做过类似工作了
        int backwardIndex = size - index - 1;//倒着数的下标
        Node pos;
        //正着数的下标<=倒着数的下标
        if (index <= backwardIndex) {//正着来
            pos = head;
            for (int i = 0; i < index; i++) {
                pos = pos.next;
            }
        } else {//反着来
            pos = last;
            for (int i = 0; i < backwardIndex; i++) {
                pos = pos.prev;
            }
        }
        return pos;
    }

    //得到链表的结点个数
    public int size() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //将链表清空
    public void reset() {
        head = last = null;
        size = 0;
    }

}



45.public class CNode {
    int val;
    CNode next = null;//指向下一个结点
    CNode random = null;//指向随机结点

    CNode(int val) {
        this.val = val;
    }

    public String toString() {
        return String.format("CNode(%d)", val);
    }
}

public class Solution {
    //深拷贝
    public CNode copy(CNode head) {
        if (head == null) {
            return null;
        }
        CNode p1 = head;
        while (p1 != null) {
            CNode p2 = new CNode(p1.val);
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
        }
        p1 = head;
        while (p1 != null) {
            CNode p2 = p1.next;
            if (p1.random != null) {
                p2.random = p1.random.next;
            }
            p1 = p2.next;//更新p1
        }
        p1 = head;
        CNode newHead = head.next;
        while (p1 != null) {
            CNode p2 = p1.next;
            p1.next = p2.next;
            if (p2.next != null) {//害怕空指针引用
                p2.next = p2.next.next;
            }
            p1 = p1.next;
        }
        return newHead;//newHead其实和p2差不多
    }
}



46.import java.util.ArrayList;     //顺序表（java自带的）
import java.util.LinkedList;    //链表

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class TestMain {
    public static void main(String[] args) {
        /*  <>代表泛型 代表这个顺序表里面元素的类型
            这里是Person类型的
         */
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("A", 7));
        arrayList.add(new Person("B", 9));
        arrayList.add(new Person("C", 19));

        for (int i = 0; i < arrayList.size(); i++) {
            Person p = arrayList.get(i);//得到顺序表的第i个元素
            System.out.print(p.name + ":" + p.age+"   ");
        }
        System.out.println();
        for (Person p : arrayList) {//遍历 arrayList
            System.out.print(p.name + ":" + p.age+"   ");
        }
        System.out.println();

        /*  <>代表泛型 代表这个链表里面元素的类型
            这里是Person类型的
         */
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("A", 7));
        linkedList.add(new Person("B", 9));
        linkedList.add(new Person("C", 19));

        for (int i = 0; i < linkedList.size(); i++) {
            Person p = linkedList.get(i);
            System.out.print(p.name + ":" + p.age+"   ");
        }
        System.out.println();
        for (Person p : linkedList) {
            System.out.print(p.name + ":" + p.age+"   ");
        }
    }
}



47.//Stack.java
import java.util.Arrays;//引入这个包

public class Stack{
	private int[] array;//采用顺序表定义栈
	private int top;//当前栈的栈顶
	
	public Stack(int defaultCapacity){
		array=new int[defaultCapacity];
		top=0;
	}
	
	public Stack(){
		this(20);
	}
	
	//插入数据（尾插）
	public void push(int val){
		if(top==arrary.length){//栈满需要扩容
			array=Arrays.copyOf(array,array.length*2);
		}
		array[top]=val;
		top++;
	}
	
	//删除数据（尾删）
	public void pop(){
		if(top<=0){
			System.out.println("栈为空，无法删除");
			return;
		}
		top--;
		array[top]=0;	
	}
	
	//查看栈顶数据
	public int pop(){
		if(top<=0){
			System.out.println("栈为空，无法返回栈顶元素");
			return -1;
		}
		return array[top-1];
	}
	
	//返回栈内数据元素个数
	public int size(){
		return top;
	}
	
	//判断栈是否为空
	public boolean isEmpty(){
		return top==0;
	}
	
}



48.//OtherStack.java
import java.util.Arrays;//引入这个包

public class OtherStack{
	private int[] array;//采用顺序表定义栈
	private int top;//代表当前栈的栈顶位置
	
	public Stack(int defaultCapacity){
		array=new int[defaultCapacity];
		top=-1;
	}
	
	public Stack(){
		this(20);
	}
	
	//插入数据（尾插）
	public void push(int val){
		if((top+1)==arrary.length){//栈满需要扩容
			array=Arrays.copyOf(array,array.length*2);
		}
		array[top+1]=val;
		top++;
	}
	
	//删除数据（尾删）
	public void pop(){
		if(top<0){
			System.out.println("栈为空，无法删除");
			return;
		}
		array[top]=0;	
		top--;
	}
	
	//查看栈顶数据
	public int pop(){
		if(top<0){
			System.out.println("栈为空，无法返回栈顶元素");
			return -1;
		}
		return array[top];
	}
	
	//返回栈内数据元素个数
	public int size(){
		return top+1;
	}
	
	//判断栈是否为空
	public boolean isEmpty(){
		return top==-1;
	}
	
}



49./*
([{}])   括号匹配问题
遍历字符串中的每个字符：
    1.如果是左括号：全部入栈
    2.如果是右括号：判断栈是否为空：若为空说明右括号多余不匹配
                    不为空就出栈顶元素，判断栈顶元素和当前右括号是否匹配
                    若匹配，则继续循环，否则直接返回false
    3.字符串遍历完毕后判断栈是否为空，若不为空说明左括号多余，不匹配
      若为空，说明字符串左右括号匹配，返回true
 */

import java.util.ArrayList; //定义java中已经实现的顺序表

public class Match {
    public boolean isValid(String s){
        ArrayList<Character> stack=new ArrayList<>();
       // 引用类型<对象类型>  变量名=new  引用类型<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);     //获取字符串中的每一个字符
            switch(c){   //如果是左括号压栈，结束本次循环
                case '(':
                case '[':
                case '{':
                    stack.add(c);   //压栈（吧所有的左括号都要压栈）
                    break;
                case ')':   //如果是右括号
                case ']':
                case '}':
                    if(stack.isEmpty()){    //栈为空，右括号多余
                        return false;
                    }
                    char left=stack.remove(stack.size()-1); //出栈顶元素
                    if(!((left=='('&&c==')')||(left=='{'&&c=='}')
                            ||(left=='['&&c==']'))){
                        return false;
                    }
                    break;
                default:break;
            }
        }

        //字符串每个字符都判断完毕后，判断栈是否为空，若不为空则左括号多余
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}



50.MinStackA.java
/*
设计一个支持push,pop,top的操作，并能在常数时间内检索到最小元素的栈
Push（x)将元素x推入栈
pop()删除栈顶元素
top()获取栈顶元素
getMin()检索栈中最小元素

思路：设置两个栈，最终两个栈的元素个数可能不相同
      一个栈normal入所有的元素，另一个栈min入小元素
      如果刚刚压入normal栈的元素大于min的栈顶元素，则min栈什么都不做
      如果小于，则min栈入此时压入normal栈的小元素
      如果等于，入min栈的栈顶元素
 */

import java.util.ArrayList;

public class MinStackA {
    private ArrayList<Integer> normal;
    private ArrayList<Integer> min;

    public MinStackA() {
        normal=new ArrayList<>();
        min=new ArrayList<>();
    }

    public void push(int x) {
        normal.add(x);

        if(min.isEmpty()){
            min.add(x);
        }else if(x<=min.get(min.size()-1)){
            min.add(x);
        }
    }

    public void pop() {  //删除栈顶元素
        int v=normal.remove(normal.size()-1);
        if(v==min.get(min.size()-1)){
            min.remove(min.size()-1);
        }
    }

    public int top() {
        return normal.get(normal.size()-1); //返回normal栈的栈顶元素
    }

    public int getMin() {
        return min.get(min.size()-1); //返回min栈的栈顶元素
    }
}



51.MinStackB.java
/*
设计一个支持push,pop,top的操作，并能在常数时间内检索到最小元素的栈
Push（x)将元素x推入栈
pop()删除栈顶元素
top()获取栈顶元素
getMin()检索栈中最小元素

思路：设置两个栈，两个栈都入栈,最终两个栈的元素个数相同
      一个栈normal入所有的元素，另一个栈min入小元素
      如果刚刚压入normal栈的元素大于min的栈顶元素，则min栈还是入Min栈的栈顶元素
      如果小于，则min栈入此时压入normal栈的小元素
      如果等于，入min栈的栈顶元素
 */

import java.util.ArrayList; //导入java中自带的顺序表

public class MinStackB {
    private ArrayList<Integer> normal;
    private ArrayList<Integer> min;

    public MinStackB(){
        normal=new ArrayList<>();
        min=new ArrayList<>();
    }

    public void push(int x) {
        normal.add(x);  //每个元素都必须压入normal栈

        if(min.isEmpty()){
            min.add(x);
        }else if(x>min.get(min.size()-1)){  //x>min栈的栈顶元素
            min.add(min.get(min.size()-1));
        }else{
            min.add(x);
        }
    }

    //移除栈顶元素
    public void pop() {
        normal.remove(normal.size()-1);
        min.remove(min.size()-1);
    }

    //得到栈顶元素并不删除
    public int top() {
        return normal.get(normal.size()-1);
    }

    //返回最小元素
    public int getMin() {
        return min.get(min.size()-1);
    }
}



52.MyCircularQueue.java
/*
循环队列：front rear
 */

class MyCircularQueue {
    private int[] array;  //队列采用顺序表定义
    private int size;   //队列中的元素个数
    private int front;  //队列的头
    private int rear;   //队列的尾的下一个位置

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array=new int[k];
        size=0;  //队列中的元素个数为0
        front=0;
        rear=0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size==array.length){   //此时队列已满
            return false;
        }
        array[rear]=value;
        rear=(rear+1)%array.length;//队列已满，rear==0
        size++; //队列中元素个数+1
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size==0){    //队列中元素个数为0
            return false;
        }
        front=(front+1)%array.length;//队列元素全部删完front==0
        size--; //队列中元素个数-1
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(size==0){
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(size==0){
            return -1;
        }
        int index=(rear-1+array.length)%array.length;
        return array[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==array.length;
    }
}



53.MyQueue.java
/* 用栈实现队列
栈：先进后出      队列：先进先出
栈：1 2 3         队列：3 2 1
需要两个栈来实现
入栈：in     出栈：out

注意：用栈来实现队列用顺序表ArrayList
      栈通过下标访问即可
*/

import java.util.ArrayList; //导入java中自带的顺序表

public class MyQueue {
    private ArrayList<Integer> in;  //入栈
    private ArrayList<Integer> out; //出栈

    //构造方法
    public MyQueue() {
        in=new ArrayList<Integer>();
        out=new ArrayList<Integer>();
    }

    public void push(int x) {
        in.add(x);   //把所有元素都压栈到In栈
    }

    public int pop() {
        if(out.isEmpty()){  //out栈是空的
            int size=in.size();
            for(int i=0;i<size;i++){    //把in栈里的所有元素移到out栈
                int v=in.remove(in.size()-1);
                out.add(v);
            }
        }
        return out.remove(out.size()-1);//返回栈顶元素并删除
    }

    public int peek() {
        if(out.isEmpty()){  //如果out栈是空的
            int size=in.size();
            for(int i=0;i<size;i++){
                int v=in.remove(in.size()-1);
                out.add(v);
            }
        }
        return out.get(out.size()-1);  //只返回栈顶元素并不删除
    }

    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
}



54.MyStack.java
/*用队列实现栈
队列：先进先出     栈：先进后出
队列：1 2 3        栈：3 2 1

注意：用队列来实现栈用链表LinkedList
      因为队列需要知道front  rear

 */

import java.util.LinkedList;    //导入java中自带的链表

class MyStack {
    private LinkedList<Integer> queue;//定义一个链表用来表示队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x); //把x放到当前队列的最后一个元素下一个位置
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for(int i=0;i<queue.size()-1;i++) {//先把队列内n-1个元素往后移
            int v=queue.pollFirst();//得到队列中的第一个元素
            queue.addLast(v);//把v放到当前队列的最后一个元素下一个位置
        }
        return queue.pollFirst();//返回队列中的第一个元素的值
    }

    /** Get the top element. */
    public int top() {
        for(int i=0;i<queue.size()-1;i++) {
            int v=queue.pollFirst();
            queue.addLast(v);
        }
        int v=queue.pollFirst();//得到队列中的第一个元素的值
        queue.addLast(v);//把队列中的第一个元素移动到队列的最后一个元素的下一个位置
        return v;
    }

    /** Returns whether the stack is empty. */
    public boolean empty(){
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */



55.Queue.java
class Node{
    int val;
    Node next;

    Node(int val,Node next){
        this.val=val;
        this.next=next;
    }

    Node(int val){
        this(val,null);
    }
}

//队列
public class Queue {
    private Node front=null; //队列的第一个结点
    private Node rear=null;  //队列的最后一个结点
    private int size=0;   //队列中的元素个数

    // 尾插
    public void push(int val){
        Node node=new Node(val);
        if(front==null){
            front=node;
        }else{
            rear.next=node;
        }
        rear=node;
        size++;
    }

    // 头删
    public void pop(){
        if(size<=0){
            System.out.println("队列为空，无法删除");
            return;
        }
        front=front.next;
        if(front==null){
            rear=null;
        }
        size--;
    }

    //返回队首元素
    public int front(){
        if(size<=0){
            System.out.println("队列为空，无法返回队首元素");
            return -1;
        }
        return front.val;
    }

    //返回队尾元素
    public int rear(){
        if(size<=0){
            System.out.println("队列为空，无法返回队尾元素");
            return -1;
        }
        return rear.val;
    }

    //返回当前队列有多少个元素
    public int size(){
        return size;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return size==0;
    }
}



56.//复习
class Node{
    int val;
    Node next;

    public Node(int val){
        this.val=val;
        next=null;
    }
}


public class Soution {
    //逆置链表1
    public static Node reverse1(Node head){
        Node p1=null;
        Node p2=head;
        Node p3=head.next;
        while(p2!=null){
            p2.next=p1;
            p1=p2;
            p2=p3;
            if(p3!=null){
                p3=p3.next;
            }
        }
        return p1;
    }

    //逆置链表2(把链表中的结点头插到一个新的空链表）
    public static Node reverse2(Node head){
        Node result=null;
        Node cur=head;
        while(cur!=null){//遍历旧链表
            Node next=cur.next;//保留当前结点的下一个结点
            cur.next=result;
            result=cur;
            cur=next;//更新cur
        }
        return result;
    }

    //逆置链表3(递归法）
    public static Node reverse3(Node head){
        if(head==null||head.next==null) {
            return head;
        }
        Node result=reverse3(head.next);
        head.next.next=head;
        head.next=null;
        return result;
    }

    //合并有序链表(新链表分情况讨论）
    public static Node merge1(Node head1,Node head2){
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node p1=head1;
        Node p2=head2;
        Node result=null;
        Node last=null;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                if(result==null){
                    result=p1;
                }else{
                    last.next=p1;
                }
                last=p1;
                p1=p1.next;
            }
            else{
                if(result==null){
                    result=p2;
                }else{
                    last.next=p2;
                }
                last=p2;
                p2=p2.next;
            }
        }
        if(p1!=null){
            last.next=p1;
        }else{
            last.next=p2;
        }
        return result;
    }

    //合并有序链表（新链表中有一个结点存在）
    public static Node merge2(Node head1,Node head2){
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node p1=head1;
        Node p2=head2;
        Node result=new Node(1);
        Node last=result;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                last.next=p1;
                p1=p1.next;
            }
            else{
                last.next=p2;
                p2=p2.next;
            }
            last=last.next; //更新最后一个结点
        }
        if(p1!=null){
            last.next=p1;
        }else{
            last.next=p2;
        }
        return result.next;
    }
}



57.//顺序表
   //子类
import java.util.Arrays;
public class ArrayList extends List{
    private int[] a=new int[10]; //只有本类可以访问

    @Override
    public void insert(int index, int element) {
        for(int i=size;i>index;i--){
            a[i]=a[i-1];
        }
        a[index]=element;
        size++;
    }

    public void print(){
        System.out.println(Arrays.toString(Arrays.copyOfRange(a,0,size)));
    }

    /*  print()方法注解
        int[] array=Arrays.copyOfRange(a,0,size);
        String s=Arrays.toString(array);
        System.oy.println(s);
     */
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.print();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.print();
        list.insert(2,100);
        list.insert(3,200);
        list.print();
    }
}



58.class A {
    static {
        System.out.println("这是 A 的静态代码块");
    }
}

class B extends A {
    static {
        System.out.println("这是 B 的静态代码块");
    }
}


public class ClassLoadOrder extends B {
    public static void main(String[] args) {
        System.out.println("开始");
        new B();
        new B(); //静态代码始终只被加载一次，所以结果只能打印一次
        new B();
        System.out.println("结束");
    }
}

/*
这是 A 的静态代码块
这是 B 的静态代码块
开始
结束
 */



59.//HelloB.java
class HelloA {
    //构造⽅法
    public HelloA(){
        System.out.println("Hello A!⽗类构造⽅法");
    }
    //⾮静态代码块
    {
        System.out.println("i'm A class.⽗类⾮静态代码块");
    }
    //静态代码块
    static{
        System.out.println("static A ⽗类静态代码块");
    } }
public class HelloB extends HelloA {
    //构造⽅法
    public HelloB() {
        System.out.println("Hello B! 构造⽅法");
    }

    //⾮静态代码块
    {
        System.out.println("i'm B class.⾮静态代码块");
    }

    //静态代码块
    static {
        System.out.println("static B 静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("---start---");
        new HelloB();
        new HelloB();
        System.out.println("---end---");
    }
}

/*
static A ⽗类静态代码块
static B 静态代码块
---start---
i'm A class.⽗类⾮静态代码块
Hello A!⽗类构造⽅法
i'm B class.⾮静态代码块
Hello B! 构造⽅法
i'm A class.⽗类⾮静态代码块
Hello A!⽗类构造⽅法
i'm B class.⾮静态代码块
Hello B! 构造⽅法
---end---
 */



60.//InstanceOrder.java
class AA {
    int a = initA();
    private int initA() {
        System.out.println("AA 的初始化");
        return 0;
    }
    {
        System.out.println("AA 的构造代码块");
    }
    AA(int x) {
        System.out.println("AA 的构造方法");
    }
}

class BB extends AA {
    int b = initB();
    private int initB() {
        System.out.println("BB 的初始化 ");
        return 0;
    }
    {
        System.out.println("BB 的构造代码块");
    }
    BB(int x) {
        super(x);
        System.out.println("BB 的有参构造方法");
    }
    BB() {
        this(100);
        System.out.println("BB 的无参构造方法");
    }
}

//实例的顺序
public class InstanceOrder {
    public static void main(String[] args) {
        new BB();  //打印一次
       // new BB();有这句话打印两次
    }
}

/*
AA 的初始化
AA 的构造代码块
AA 的构造方法
BB 的初始化
BB 的构造代码块
BB 的有参构造方法
BB 的无参构造方法
 */


61.//LinkedList.java
//链表
//子类
import java.util.Arrays;//引入这个包

class Node{
    int val;
    Node next;
}
public class LinkedList extends List{
    private Node head=null;  //链表的第一个结点


    @Override
    public void insert(int index, int element) {
        Node node=new Node();  //把插入的元素包装到一个结点中
        node.val=element;
        if(index==0){  //头插
            node.next=head;
            head=node;
        }else if(index==size){ //尾插
            Node last=head;
            while(last.next!=null){
                last=last.next;  //找到当前链表的最后一个结点
            }
            last.next=node;
            last=node;
            last.next=null;
        }else{  //中间任意位置插
            Node prev=head;
            for(int i=0;i<index-1;i++){
                prev=prev.next;   //找到插入位置的前驱结点
            }
            node.next=prev.next;
            prev.next=node;
        }
        size++;
    }

    public void print(){
        //先把链表中的值复制到一个数组中
        int[] array=new int[size];
        Node cur=head;
        for(int i=0;i<size;i++){
            array[i]=cur.val;
            cur=cur.next;
        }
        String s=Arrays.toString(array);
        System.out.println(s);
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.pushFront(4);
        list.pushFront(5);
        list.pushFront(6);
        list.print();
        list.pushBack(50);
        list.pushBack(60);
        list.pushBack(70);
        list.print();
        list.insert(2,100);
        list.insert(3,200);
        list.print();
    }
}



62.//List.java
//线性表
//父类
public class List {
    protected int size=0;

    //往下标为Index处插入元素
    public void insert(int index,int element){
        System.out.println("父类中的方法，并没有实现");
    }

    //头插
    public void pushFront(int element){
        insert(0,element);
    }

    //尾插
    public void pushBack(int element){
        insert(size,element);
    }
}



63.//删除链表中的重复结点
class Node{
    int val;
    Node next;
}
public class Soultion {
    public Node deleteDuplicated(Node head){
        if(head==null)return null;
        if(head.next==null)return head;
        Node prev=new Node();//先创建一个结点
        prev.next=head;
        Node first=prev;//保存prev
        Node p=head;
        Node q=head.next;//用来遍历链表
        while(q!=null){
            if(p.val!=q.val){
                prev=p;
                p=q;
                q=q.next;
            }else{
                while(q!=null&&p.val==q.val){
                    q=q.next;
                }
                prev.next=q;
                p=q;
                if(q!=null){
                    q=q.next;
                }
            }
        }
        return first.next;
    }
}



64.import java.lang.reflect.Array;

//List是父类   ArrayList是子类
public class Demo {
    private static List getList() {
        return new ArrayList();
    }

    private static void fill(List list) {
        list.pushBack(0);
        list.pushBack(1);
    }

    public static void main(String[] args) {
        // list1 是一个 List 类型的引用，
        // list1 指向一个 ArrayList 类型的对象
        List list1 = new ArrayList();
        List list2 = getList();  //return new ArrayList();
        fill(list1);
        fill(list2);
        ArrayList list3 = new ArrayList();
        fill(list3);
    }
}



65.//定义一个接口（接口中的方法都不实现,只定义）
public interface List {
    void pushFront(int element);
    void pushBack(int element);
    void insert(int index,int element);
}

class Node{
    int val;
    Node next;
}

//定义一个抽象类AbstractList实现接口List
abstract class AbstractList implements List{
    protected int size=0;

    @Override
    public void pushFront(int element) {
        insert(0,element);
    }

    @Override
    public void pushBack(int element) {
        insert(size,element);
    }
}

//定义一个类ArrayList继承抽象父类AbstractList并且实现接口List
class ArrayList extends AbstractList implements List{
    private int[] array=new int[10];
    @Override
    public void insert(int index, int element) {
        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        size++;
    }
}

//定义一个类LinkedList继承抽象父类AbstractList并且实现接口List
class LinkedList extends AbstractList implements List{
    private Node head=null;

    @Override
    public void insert(int index, int element) {
        Node node=new Node();
        node.val=element;
        if(index==0){
            node.next=head;
            head=node;
        }else if(index==size){
            Node last=head;
            while(last.next!=null){//注意是last.next!=null
                last=last.next;
            }
            last.next=node;
            last=node;
            last.next=null;
        }else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }
}



66.
class A {
    public void method() {
        System.out.println("A 的普通方法");
    }

    public static void staticMethod() {
        System.out.println("A 的静态方法");
    }
}

class B extends A {
    @Override
    public void method() {
        System.out.println("B 的普通方法");
    }

    //在这里写@Override是错误的，因为静态方法没有重载一说
    public static void staticMethod() {
        System.out.println("B 的静态方法");
    }

    public void methodOfB() {
        System.out.println("只有 B 所拥有的方法");
    }
}

//B类继承A类   A父类  B子类
public class Main {
    public static void main(String[] args) {
        A aa = new A();
        B bb = new B();
        A ab = new B();

        //B ba = new A(); //编译错误

        aa.method(); //A 的普通方法
        ab.method(); //B 的普通方法

        // aa.methodOfB(); 编译错误  编译看的是引用类型不是实际类型
        // ab.methodOfB(); 编译错误
        bb.method();    //B 的普通方法
        bb.methodOfB(); //只有 B 所拥有的方法

        System.out.println("=============");

        // 警告，永远不要这么写   ！！！类名.方法名（）
        aa.staticMethod();  //A 的静态方法
        ab.staticMethod();  //A 的静态方法   静态方法看引用类型
        bb.staticMethod();  //B 的静态方法

        System.out.println("=============");

        // 向下类型转化
        if (ab instanceof B) {
            B b = (B) ab;
            b.methodOfB();  //只有 B 所拥有的方法
        }

        if (aa instanceof B) {
            B c = (B) aa;
            c.methodOfB();
        }
    }
}



67.//产生随机数
import java.util.Random; //导入这个包

/*
java.util.Random类：
    Random(seed:long)以一个特定值作为种子创建一个Random对象
    nextInt(n:int):int 返回一个0到n(不包含n）之间的随机Int类型的值
 */
public class RandomNumber {
    public static void main(String[] args) {
        Random number=new Random(20190907);
        System.out.print("随机数字为：");
        for(int i=0;i<5;i++){
            System.out.print(number.nextInt(100)+" ");
        }
    }
}



68.//YangHuiSanJiao.java
import java.util.ArrayList;
import java.util.List;

public class YangHuiSanJiao {
    public List<List<Integer>> generate1(int numRows) {  //numRows是行数
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>()); //给list增加numRows行
        }
        //将每行中的数字全部置为1
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                list.get(i).add(1);//给第i+1行全部置为1
            }
        }
        //修改
        for(int i=2;i<numRows;i++){ //从第三行开始修改
            for(int j=1;j<i;j++) {
                int a = list.get(i - 1).get(j - 1);
                int b = list.get(i - 1).get(j);
                list.get(i).set(j,a+b);
            }
        }
        return list;
    }

    /*
    int[][] array= {{1},
                    {1,2},
                    {1,2,1},
                    {1,3,3,1},
                    {1,4,6,4,1}}
     */
    public List<List<Integer>> generate2(int numRows) {  //numRows是行数
        List<List<Integer>> list=new ArrayList<>();
        //第一行
        list.add(new ArrayList<>());
        list.get(0).add(1);
        //第二行
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);
        //第三行
        list.add(new ArrayList<>());
        list.get(2).add(1);
        list.get(2).add(2);
        list.get(2).add(1);
        //第四行
        list.add(new ArrayList<>());
        list.get(3).add(1);
        list.get(3).add(3);
        list.get(3).add(3);
        list.get(3).add(1);
        //第五行
        list.add(new ArrayList<>());
        list.get(4).add(1);
        list.get(4).add(5);
        list.get(4).add(10);
        list.get(4).add(10);
        list.get(4).add(5);
        list.get(4).add(1);

        if(numRows==5){
            return list;
        }

        if(numRows<5){
            return list.subList(0,numRows);
        }

        return null;
    }

    public List<List<Integer>> generate3(int numRows) {  //numRows是行数
        List<List<Integer>> list=new ArrayList<>();
        //第一行
        list.add(new ArrayList<>());
        list.get(0).add(1);
        //第二行
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);
        //从第三行开始
        for(int i=2;i<numRows;i++){
            list.add(new ArrayList<>());//增加一行
            list.get(i).add(1);//第一个为1
            for(int j=1;j<i;j++){
                int a=list.get(i-1).get(j-1);
                int b=list.get(i-1).get(j);
                list.get(i).add(a+b);
            }
            list.get(i).add(1);//最后一个为1
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new YangHuiSanJiao().generate1(4));
        System.out.println(new YangHuiSanJiao().generate2(4));
        System.out.println(new YangHuiSanJiao().generate3(6));
    }
}



69.//CollectionDemo.java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        /* Collection相当于一个集合（容器）   里面的元素类型为String类型
            ArrayList实现了Collection接口
         */
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        list.add("我");
        list.add("爱");
        list.add("Java");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        list.remove("我");
        for(String s:list){
            System.out.print(s+" ");
        }
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        Object[] array=list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println("======================");

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        list.clear();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}



70.import java.util.Scanner;
/*
    输入一个数字number   问最少还差几步可以得到最近的斐波那契数
    即到离他最近的斐波那契数还需要几步  每次只能走减1加1步
 */
public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int number=input.nextInt();
        int steps=getStep(number);
        System.out.println(steps);
    }

    private static int getStep(int n){
        for(int i=0;i<n;i++){
            int num=Fibonacci(i);
            if(n==num){
                return 0;
            }else if(n>Fibonacci(i)&&n<Fibonacci(i+1)){
                int a=n-Fibonacci(i);
                int b=Fibonacci(i+1)-n;
                if(a<b){
                    return a;
                }else if(a==b){
                    return a;
                }else{
                    return b;
                }
            }
        }
        return 0;
    }

    private static int  Fibonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

}



71.//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
class Solution {
    public String reverseVowels(String s) {
        if(s.length()==0){
            return "";
        }
       char[] a=s.toCharArray();
        int i=0,j=a.length-1;
        while(i<j){
            while(i<j&&!isHave(a[i])){
                i++;
            }
            while(i<j&&!isHave(a[j])){
                j--;
            }
            char c=a[i];
            a[i]=a[j];
            a[j]=c;
            i++;
            j--;
        }
        return String.valueOf(a);
    }
    
    private boolean isHave(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'e' || c == 'u' || c == 'A' || c == 'E' || c == 'I'                                   || c == 'O' || c == 'E' || c == 'U');
    }
    
}




72./*
输出一个数字，表示把字符串B插入字符串A之后，
构成一个回文串的方法数
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s1=input.nextLine();
        String s2=input.nextLine();
        int len=s1.length();
        int count=0;
        for(int i=0;i<=len;i++){
            StringBuilder s3=new StringBuilder(s1);
            s3.insert(i,s2);
            if(isTrue(s3.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isTrue(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}



73.import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = "abc";
        StringBuilder s2=new StringBuilder(s1);
        System.out.println(s2);
        StringBuilder s3=s2.reverse();
        System.out.println(s2);
        System.out.println(s3);
    }
}



74./*

输出一个数字，表示把字符串B插入字符串A之后，
构成一个回文串的方法数
 */
import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        String s1=input.nextLine();
        String s2=input.nextLine();
        int count=0;
        if(isPlindrome(s2+s1,0,s1.length()+s2.length()-1)){
            count++;
        }
        for(int i=1;i<s1.length();i++){
            if(isPlindrome(s1.substring(0,i)+s2+s1.substring(i),0,s1.length()+s2.length()-1)){
                count++;
            }
        }
        if(isPlindrome(s1+s2,0,s1.length()+s2.length()-1)){
            count++;
        }
        System.out.println(count);
    }
    public static boolean isPlindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}



75./*
有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，
则这两个数字组成一个逆序对。请设计一个高效的算法，
计算给定数组中的逆序对个数。
给定一个int数组A和它的大小n,请返回A中
的逆序对个数。保证n小于等于5000。

测试样例:
[1,2,3,4,5,6,7,0],8
返回: 7

 */
import java.util.*;

public class Main {
    public int count(int[] A, int n) {
        int count=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}



76./*
有这样-道智力题:“某商店规定:三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水
瓶，她最多可以换多少瓶汽水喝?”答案是5瓶，方法如下:先用9个空瓶子换3瓶汽水,喝
掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶， 喝掉这瓶满的,这时候剩2个空瓶子。然
后你让老板先借给你一瓶汽水,喝掉这瓶满的，喝完以后用3个空瓶子换-瓶满的还给老
板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽气水喝?

输入描述:
输入文件最多包含10组测试数据，每个数据占一行，仅包含一一个正整数n (1<=n<=100) ,表
示手上的空汽水瓶数。I
n=0表示输入结束，你的程序不应当处理这一行。
输出描述:
对于每组测试数据，输出一行，表示最多可以.喝的汽水瓶数。如果一瓶也喝不到，输出0。
 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=0;
        while(input.hasNext()){
            n=input.nextInt();
            nums(n);
        }
    }

    private static void nums(int n) {
        int kong=n;
        if(n<2){
            System.out.println(0);
        }else if(n==2){
            System.out.println(1);
        }else{
            int he,count=0;
            while(kong>2){
                he=kong/3;
                count+=he;
                kong= kong-he*3+he;
            }
            if(kong==2){
                System.out.println(count+1);
            }else{
                System.out.println(count);
            }
        }
    }
}



77./*
输入一个字符串，输出其中最长的数字串
 */
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        int count=0;    //数字的个数
        int max=0;      //最大的数字串长度
        int end=0;      //最大的数字串结束于end下标
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='0')&&(s.charAt(i)<='9')) {
                count++;
                if (count > max) {
                    max = count;
                    end = i;
                }
            }else{
                   count=0;
            }
        }
        System.out.println(s.substring(end-max+1,end+1));
    }
 }



78./*合法括号序列判断：
给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串
一个合法的括号串定义为：
1.只包括括号字符
2.左括号和右括号匹配
（）（）a,5     //false
(())(),6        //true
 */
import java.util.*;

public class Main4{
    public static void main(String[] args) {
        System.out.println(chkParenthesis("((a)",4));
    }
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> t=new Stack<>();
        for(int i=0;i<n;i++){
            if(A.charAt(i)!='('&&A.charAt(i)!=')'){
                return false;
            }
            if(A.charAt(i)=='('){
                t.push('(');
            }else{
                if(A.charAt(i)==')'){
                    if(t.isEmpty()){
                        return false;
                    }else{
                        t.pop();
                    }
                }
            }
        }
        if(t.isEmpty()){
            return true;
        }
        return false;
    }
}



79./*
删除公共字符串
 */
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s1=input.nextLine();
        String s2=input.nextLine();
        String s3=delete(s1,s2);
        System.out.println(s3);
    }

    private static String delete(String s1, String s2) {
        if(s1==null||s2==null){
            return s1;
        }
        String s3="";
        for(int i=0;i<s1.length();i++){
                if(!s2.contains(s1.charAt(i)+"")){
                    s3 += s1.charAt(i);
                }
        }
        return s3;
    }
}



80./*
用两个栈实现一个队列
 */
import java.util.Stack;

public class Main7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}



81./*
有一个神奇的口袋，总的容积是40,用这个口袋可以变出- -些物品，这些物
品的总体积必须是40。有n个想要得到的物品，每个物品的体积分别是a1 ,
a.....n.有多少种不同的选择物品的方式。

 */
import java.util.Scanner;

public class Main8 {
    static int count=0;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();   //你想要的物品数
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=input.nextInt();  //你要要的每个物品的体积
        }
        koudai(a,40,n);
        System.out.println(count);
    }
    //i为剩余物品体积，n为剩余可选物品数
    private static void koudai(int[] a,int i, int n) {
        if(i==0){  //如果剩余物品体积为0  ，刚好装满
            ++count;
            return;
        }
        if(i<0||(i>0&&n<1)){
            return;
        }
        koudai(a,i-a[n],n-1);//从后往前装，装上a[n]后，若剩余物品任然有解
        koudai(a,i,n-1);  //若装了a[n]后无解，删除该包，尝试第n-1个
    }

}



82.import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        System.out.println(num(a,n));
    }

    private static int num(int[] a, int n) {
        Arrays.sort(a);
        return a[n/2];
    }
}



83.import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            int[] arr=new int[4];
            for(int i=0;i<4;i++){
                arr[i]=input.nextInt();
            }
            float a=(arr[0]+arr[2])/2;
            float b=(arr[1]+arr[3])/2;
            float c=b-arr[1];
            int a1=(int)a;
            int b1=(int)b;
            int c1=(int)c;
            if(a!=a1){
                System.out.println("No");
            }
            if(b!=b1){
                System.out.println("No");
            }
            if(c!=c1){
                System.out.println("No");
            }
            if(a<0){
                System.out.println("No");
            }else if(b<0){
                System.out.println("No");
            }else if(c<0){
                System.out.println("No");
            }else{
                System.out.println(a+" "+b+" "+c);
            }
    }
}



84.import java.util.Scanner;
/*
二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，
网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，
任意两块蛋糕的欧几里得距离不能等于2。
对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
小易想知道最多可以放多少块蛋糕在网格盒子里。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        int n=input.nextInt();
        int res=0;
        if(m%4==0||n%4==0){
            res=m*n/2;
        }else{
            res=m*n/2+1;
        }
        System.out.println(res);
    }
}



85.import java.util.Scanner;
/*
正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，
设计一个算法，求输入A和B的最小公倍数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        System.out.println(mix(a,b));
    }

    private static int mix(int a, int b) {
        int n=a*b;
        for(int i=2;i<=n;i++){
            if((i%a==0)&&(i%b==0)){
                return i;
            }
        }
        return n;
    }
}



86.import java.util.Arrays;
import java.util.Scanner;
/*
找出n个数里最小的k个
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String s=input.nextLine();
            String[] a=s.split(" ");
            int[] b=new int[a.length-1];
            for(int i=0;i<b.length;i++){
                b[i]=Integer.valueOf(a[i]);
            }
            int k=Integer.valueOf(a[a.length-1]);
            Arrays.sort(b);
            for(int i=0;i<k;i++){
                System.out.print(b[i]+" ");
            }
        }
    }
}



87.import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
有一个数组a[n]顺序存放0~n-1,要求每隔两个数删除一个数，到末尾时循环至开头继续进行删除，
求最后一个被删掉的数的原始下标，以8个数为列子：0--》1--》2删除--》3--》4--》5删除--》6--》7--》0删除
如此循环直到最后一个数被删除
 */
/*
其实就是相当于这样的一个游戏：n个人
围城一圈，开始报数，报数为3的退出。问存活的是谁？

都是从0到n-1的数字。因为每次删除的都是当前位置的后面第2个，那么我们就可以这样写：
(i+2)%size; 当i==0的时候，我们移除的就是2号下标，接着需要移除4号下标，
那么新的i =(i+2)%size; 那么结束条件应该是什么？
我们要找到存活的，显而易见当集合的size等于1的时候停止删除。
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n>1000){
                n=999;
            }
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            int i=0;
            while(list.size()>1){
                i=(i+2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }

    }
}



88.import java.util.Scanner;
/*      n！末尾有多少个0
计算阶乘里面的每一个元素包含5的个数
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(counts(n));
    }

    private static int counts(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int j=i;
            while(j%5==0){
                count++;
                j/=5;
            }
        }
        return count;
    }
}



89.import java.util.Scanner;
/*
输入一个整数  ，输出它的逆序
100      001
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(reverseInt(n));
    }

    private static String reverseInt(int n) {
        String s=String.valueOf(n);
        StringBuilder ss=new StringBuilder(s);
        return ss.reverse().toString();
    }
}



90.import java.util.Scanner;
/*
给一个数n,把n变成离他最近的斐波那契数，需要走几步
每一只能走1步
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int steps=counts(n);
        System.out.println(steps);
    }

    private static int counts(int n) {
        for(int i=0;i<=n;i++){
            if(Fib(i)==n){
                return 0;
            }else{
                if(Fib(i)<=n&&Fib(i+1)>=n){
                    int a=n-Fib(i);
                    int b=Fib(i+1)-n;
                    if(a==b){
                        return a;
                    }else if(a<b){
                        return a;
                    }else{
                        return b;
                    }
                }
            }
        }
        return 0;
    }

    private static int Fib(int n){
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            return Fib(n-1)+Fib(n-2);
        }
    }
}



91.import java.util.Scanner;
/*
给一个数n,把n变成离他最近的斐波那契数，需要走几步
每一只能走1步
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int steps=counts(n);
        System.out.println(steps);
    }

    private static int counts(int n) {
        for(int i=0;i<=n;i++){
            if(Fib(i)==n){
                return 0;
            }else{
                if(Fib(i)<=n&&Fib(i+1)>=n){
                    int a=n-Fib(i);
                    int b=Fib(i+1)-n;
                    if(a==b){
                        return a;
                    }else if(a<b){
                        return a;
                    }else{
                        return b;
                    }
                }
            }
        }
        return 0;
    }

    private static int Fib(int n){
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            return Fib(n-1)+Fib(n-2);
        }
    }
}



92.import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
输入：100311
输出：
    0:2
    1:3
    3:1
 */
public class Main {
    public static void main(String[] args) {
        Scanner intput=new Scanner(System.in);
        String s=intput.nextLine();
        char[] a=s.toCharArray();
        int[] b=new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=a[i]-'0';
        }
        Map<Integer,Integer> map=new TreeMap<>(); //有序
        for(int i=0;i<b.length;i++){
            int num=map.getOrDefault(b[i],0);
            map.put(b[i],num+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int aa=e.getKey();
            int bb=e.getValue();
            System.out.println(aa+":"+bb);

        }
    }
}



93.import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {
    public static int[] multiply(int[] A) {
        int[] c=new int[A.length];
        if(A.length==0){
            return null;
        }
        for(int i=0;i<A.length;i++){
            int[] a= Arrays.copyOfRange(A,0,i);
            int[] b=Arrays.copyOfRange(A,i+1,A.length);
            c[i]=num(a,b);
        }
        return c;
    }

    private static int num(int[] a, int[] b) {
        ArrayList<Integer> list=new ArrayList<>();
        int result=1;
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            list.add(b[i]);
        }
        for(int i=0;i<list.size();i++){
            result*=list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] c=multiply(a);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}



94.import java.util.*;
/*
输入：100311
输出：
    0:2
    1:3
    3:1
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner intput=new Scanner(System.in);
        String s=intput.nextLine();
        char[] a=s.toCharArray();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(0);
        }
        for(int i=0;i<a.length;i++){
            list.set(a[i]-'0',list.get(a[i]-'0')+1);
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)>0){
                System.out.println(i+":"+list.get(i));
            }
        }
    }
}




95.import java.util.Scanner;
/*
问题描述:
　　输入一个单词，请输出这个单词中第一个出现的元音字母。
　　元音字母包括 a, e, i, o, u，共五个。
输入格式:
　　输入一行，包含一个单词，单词中只包含小写英文字母。
输出格式:
　　输出一行包含一个字母，为单词中第一个出现的元素字母。若单词中不存在元音字母，输出字母n。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        char[] a=s.toCharArray();
        boolean flag=true;
        for(int i=0;i<a.length;i++){
            if(a[i]=='a'||a[i]=='e'||a[i]=='i'||a[i]=='o'||a[i]=='u'){
                System.out.println(a[i]);
                flag=false;
                break;
            }
        }
        if(flag==true) {
            System.out.println('n');
        }
    }
}
	


96.import java.util.Scanner;
/*
　　给定三个整数 a, b, c，
    如果一个整数既不是 a 的整数倍也不是 b 的整数倍还不是 c 的整数倍，
    则这个数称为反倍数。
　　请问在 1 至 n 中有多少个反倍数。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String aa=sc.nextLine();
        int n=Integer.valueOf(aa);
        String s=sc.nextLine();
        String[] a=s.split(" ");
        int[] b=new int[3];
        for(int i=0;i<3;i++){
            b[i]=Integer.valueOf(a[i]);
        }
        int count=0;
        for(int i=1;i<=n;i++){
            if((i%b[0]!=0)&&(i%b[1]!=0)&&(i%b[2]!=0)){
                count++;
            }
        }
        System.out.println(count);
    }
}



97.import java.util.Scanner;
/*
小明非常不喜欢数字 2，包括那些数位上包含数字 2 的数。
如果一个数的数位不包含数字 2，小明将它称为洁净数。
　　请问在整数 1 至 n 中，洁净数有多少个？
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            String s=String.valueOf(i);
            if(!s.contains(String.valueOf(2))){
                count++;
            }
        }
        System.out.println(count);
    }
}



98.import java.util.Scanner;
/*
问题描述:
　　对于一个 n 行 m 列的表格，我们可以使用螺旋的方式给表格依次填上正整数
，我们称填好的表格为一个螺旋矩阵。
　　例如，一个 4 行 5 列的螺旋矩阵如下：
　　1 2 3 4 5
　　14 15 16 17 6
　　13 20 19 18 7
　　12 11 10 9 8
输入格式:
　　输入的第一行包含两个整数 n, m，分别表示螺旋矩阵的行数和列数。
　　第二行包含两个整数 r, c，表示要求的行号和列号。
输出格式:
　　输出一个整数，表示螺旋矩阵中第 r 行第 c 列的元素的值。
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int r=s.nextInt();
        int rr=s.nextInt();
        int[][] arr=new int[m][n];
        int x;
        int y;
        int z=1;
        int c=0;
        while(true){
            if(z>m*n)
                break;
            for(x=c,y=c;y<n-c;y++){
                arr[x][y]=z;
                z++;
            }
            for(x=c+1,y=n-1-c;x<m-c;x++){
                arr[x][y]=z;
                z++;
            }
            for(x=m-1-c,y=n-2-c;y>=c;y--){
                arr[x][y]=z;
                z++;
            }
            for(x=m-2-c,y=c;x>c;x--){
                arr[x][y]=z;
                z++;
            }
            c++;
        }
        System.out.print(arr[r-1][rr-1]);
    }
}



99.public class Main1 {
    public String[] getGray(int n) {
        String[] g=new String[(int)Math.pow(2,n)];
        if(n==1){
            g[0]="0";
            g[1]="1";
            return g;
        }
        String[] s=getGray(n-1);
        for(int i=0;i<s.length;i++){
            g[i]="0"+s[i];   //从头开始加
            g[g.length-1-i]="1"+s[i];   //从尾开始加
        }
        return g;
    }
}



100.public class Main {
    public static int[] exchangeAB(int[] AB) {
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];
        return AB;
    }
}



101.import java.util.Scanner;
/*
Fibonacci数列是这样定义的：
F[0] = 0
F[1] = 1
for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...
在Fibonacci数列中的数我们称为Fibonacci数。给
你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1
现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=0,b=1,c=1;  //第一个数   第二个数  第三个数
        while(c<n){   //迭代减少了递归的重复计算
            a=b;      //找到大于等于n的Fib数就退出循环
            b=c;      //n一定在b和c之间
            c=a+b;
        }
        int step1=n-b;
        int step2=c-n;
        System.out.println((step1<step2)?step1:step2);
    }
}



102.




