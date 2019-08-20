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



36.
	
	
	
	
	
	
	
	
	
	
	
	
