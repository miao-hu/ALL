求两个数a、b之间较大的数，不使用if、while、switch、for、?:/以及任何比较语句

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//第一种
#if 0
int Compare1(int a, int b)
{
	return a > b ? a : b;     //返回最大值
}
int main()
{
	int a, b;
	printf("Please enter two number:");
	scanf("%d %d", &a, &b);
	int ret = Compare1(a, b);
	printf("ret=%d\n", ret);
	system("pause");
	return 0;
}
#endif

//第二种
#if 0
int Compare2(int a, int b)
{
	//return ((a + b) - abs(a - b)) / 2;    //返回较小值
	return ((a+b)+abs(a-b))/2;          //返回较大值
}
int main()
{
	int a, b;
	printf("Please enter two number:");
	scanf("%d %d", &a, &b);
	int ret = Compare2(a, b);
	printf("ret=%d\n", ret);
	system("pause");
	return 0;
}
#endif

//第三种
//求两个数a、b之间较大的数
//不使用if、while、switch、for、?:/以及任何比较语句
int Compare3(int a, int b)
{
	int d_value = a - b;     //差值
	int flag = (d_value >> 31)&1;    //判断差值的符号位  1负数，0正数
	int arr[] = { b, a };
	return arr[flag];      //返回较小值
}
int main()
{
	int a, b;
	printf("Please enter two number:");
	scanf("%d %d", &a, &b);
	int ret_min = Compare3(a, b);
	printf("ret_min=%d\n", ret_min);
	system("pause");
	return 0;
}
