#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//第一种
#if 0
void Menu()
{
	printf("*****************************\n");
	printf("*****1.Add      2.Sub********\n");
	printf("*****3.Mul      4.Div********\n");
	printf("*****           0.Exit*******\n");
	printf("*****************************\n");
}
int Add(int a, int b)
{
	return a + b;
}
int Sub(int a, int b)
{
	return a - b;
}
int Mul(int a, int b)
{
	return a *b;
}
int Div(int a, int b)
{
	return a /b;
}
int main()
{
	int input=1,ret=0;
	int a, b;
	while (input)
	{
		Menu();
		printf("Please enter number:");
		scanf("%d", &input);
		switch (input)
		{
		case 0:
			printf("退出\n");
			break;
		case 1:
			printf("请输入两个数:");
			scanf("%d %d", &a, &b);
			ret = Add(a, b);
			break;
		case 2:
			printf("请输入两个数:");
			scanf("%d %d", &a, &b);
			ret = Sub(a, b);
			break;
		case 3:
			printf("请输入两个数:");
			scanf("%d %d", &a, &b);
			ret = Mul(a, b);
			break;
		case 4:
			printf("请输入两个数:");
			scanf("%d %d", &a, &b);
			ret = Div(a, b);
			break;
		default:
			printf("你输入的有误");
			break;
		}
		printf("result=%d\n", ret);
	}
	system("pause");
	return 0;
}
#endif

//第二种
void Menu()
{
	printf("*****************************\n");
	printf("*****1.Add      2.Sub********\n");
	printf("*****3.Mul      4.Div********\n");
	printf("*****           0.Exit*******\n");
	printf("*****************************\n");
}
int Add(int a, int b)
{
	return a + b;
}
int Sub(int a, int b)
{
	return a - b;
}
int Mul(int a, int b)
{
	return a *b;
}
int Div(int a, int b)
{
	return a / b;
}
int main()
{
	int input = 1, ret = 0;
	int a, b;
	int(*p[5])(int a,int b)= { 0, Add, Sub, Mul, Div };//转移表
	while (input)
	{
		Menu();
		printf("Please enter number:");
		scanf("%d", &input);
		if (input >= 1 && input <= 4)
		{
			printf("请输入两个操作数:");
			scanf("%d %d", &a, &b);
			ret = p[input](a, b);
		}
		else
		{
			printf("输入错误\n");
		}
		printf("result=%d\n", ret);
	}
	system("pause");
	return 0;
}
