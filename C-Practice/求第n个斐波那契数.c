#pragma warning(disable:4996)     
#include<stdio.h>
#include<stdlib.h>
//这个题中，迭代法显然比较快，可以输入n=50来进行比较，因为递归法重复调用函数了很多次

//递归法
int count = 0;       //count为全局变量
int fib(int n)
{
	if (n == 3)         //计算fib(3)被调用了几次
		count++;
	if (n > 2)
		return fib(n - 1) + fib(n - 2);
	else
		return 1;
}
int main()
{
	int n;
	printf("请输入一个数:");
	scanf("%d", &n);
	int ret = fib(n);
	printf("result=%d,count=%d", ret,count);
	system("pause");
	return 0;
}


//迭代法
#if 0
int fib(int n)
{
	int first = 1;
	int second = 1;
	int third = 1;
	int i = 2;
	while (i<n)
	{
		third = first + second;
		first=second;
		second=third;
		i++;
	}
	return third;
}
int main()
{
	int n;
	printf("请输入一个数:");
	scanf("%d", &n);
	int ret = fib(n);
	printf("result=%d\n", ret);
	system("pause");
	return 0;
}
#endif
