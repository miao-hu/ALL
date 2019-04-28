#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//第一种
#if 0
void 	PrintArr1(int arr[3][3],int row,int col)
{
	int i, j;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}
int main()
{
	int arr[3][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	PrintArr1(arr,3,3);  //传数组名传递的是整个数组
	system("pause");
	return 0;
}
#endif

//第二种
#if 0
void 	PrintArr2(int *arr,int row,int col)  
{
	int i, j;
	for (i = 0; i <row; i++)
	{
		for (j = 0; j < col; j++)
		{
			printf("%d ",arr[i*col+j]);//看成了一个一位数组
		}
		printf("\n");
	}
}
int main()
{
	int arr[3][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	PrintArr2((int*)arr,3,3);     //第一个元素的地址
	system("pause");
	return 0;
}
#endif

//第三种
void PrintArr3(int(*arr)[3], int row, int col)  //数组指针:是指针
{//定义了一个名为arr的指针变量，它可以指向每行有三个整型元素的一维数组
	int i, j;
	for (i = 0; i <row; i++)
	{
		for (j = 0; j < col; j++)
		{
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}
int main()
{
	int arr[3][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	PrintArr3(arr, 3, 3);   
	//数组名arr，表示首元素的地址
	//二维数组的首元素是二维数组的第一行
	//这里传递的arr，其实相当于第一行的地址，是一位数组的地址，可以用数组指针来接收
	system("pause");
	return 0;
}
