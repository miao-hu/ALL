#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//升序排列
#if 0
int cmpInt(const void *xp, const void *yp)
{
	int *x = (int *)xp;
	int *y = (int *)yp;
	if (*x > *y)
	{
		return 1;
	}
	else if (*x < *y)
	{
		return -1;
	}
	else
		return 0;
}
void show(int a[], int num)
{
	int i = 0;
	for (i = 0; i < num; i++)
		printf("%d ", a[i]);
	printf("\n");
}
int main()
{
	int a[8] = { 33, 1, 56, 23, 90, 46, 77, 5 };
	int num = sizeof(a) / sizeof(a[0]);
	show(a, num);
	qsort(a, num, sizeof(int), cmpInt);
	show(a, num);
	system("pause");
	return 0;
}
#endif


//降序排列
#if 0
int cmpInt(const void *xp, const void *yp)
{
	int *x = (int *)xp;
	int *y = (int *)yp;
	if (*x > *y)
	{
		return -1;
	}
	else if (*x < *y)
	{
		return 1;
	}
	else
		return 0;
}
void show(int a[], int num)
{
	int i = 0;
	for (i = 0; i < num; i++)
		printf("%d ", a[i]);
	printf("\n");
}
int main()
{
	int a[8] = { 33, 1, 56, 23, 90, 46, 77, 5};
	int num = sizeof(a) / sizeof(a[0]);
	show(a, num);
	qsort(a, num, sizeof(int), cmpInt);
	show(a, num);
	system("pause");
	return 0;
}
#endif


int cmpDouble(const void *xp, const void *yp)   //传进来的为元素类型不明确的指针
{
	double *x = (double *)xp;  //你肯定知道你要比较的数据都是什么类型
	double *y = (double *)yp;  //因此你强转过来就行
	if (*x > *y)
	{
		return 1;   //前者大返回1
	}
	else if (*x < *y)
	{
		return -1;   //后者大返回-1
	}
	else
		return 0;    //两者相等返回0
}
void show(double a[], int num)   //展示数组
{
	int i = 0;
	for (i = 0; i < num; i++)
		printf("%f  ", a[i]);
	printf("\n");
}
int main()
{
	double a[8] = { 1.1,8.33,4.66,9.0,67.8,45.369,3.9,99.1 };
	int num = sizeof(a) / sizeof(a[0]);   //元素个数
	show(a, num);
	qsort(a, num, sizeof(double), cmpDouble);
	//a为目标数据的起始地址 ，sizeof(double)为每一个元素的大小， cmpDouble为回调函数
	//qsort快排，与类型无关
	//设置回调函数就是提供对两个类型不明确的元素进行比较的方法
	show(a, num);
	system("pause");
	return 0;
}
