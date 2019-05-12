#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>   
void swap(char *x, char *y, int size)
{
	int i = 0;
	for (i = 0; i < size; i++)
	{
		char temp = *x;
		*x = *y;
		*y = temp;
	}
}
void show(int a[], int num)
{
	int i = 0;
	for (i = 0; i < num; i++)
		printf("%d ", a[i]);
	printf("\n");
}
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
void MyQsort(void *base, int num, int size, \
										int(*cmp)(const void*, const void*))
{
	assert(base);   //检测指针是否存在
	assert(cmp);
	char *start = (char *)base;//为了方便按照字节交换
	int i = 0, j = 0;
	for (i = 0; i < num - 1; i++)  //控制冒泡排序的趟数
	{
		int flag = 0;
		for (j = 0; j < num - i - 1; j++)  //控制每一趟中进行比较的次数
		{
			if (cmp(start + j*size, start + (j + 1)*size)>0)
			{
				flag = 1;
				swap(start + j*size, start + (j + 1)*size, size);
			}
		}
		if (!flag)   //已经有序
		{
			break;
		}
	}
}
int main()
{
	int a[8] = { 45, 2, 68, 35, 66, 300, 4562, 6 };
	int num = sizeof(a) / sizeof(a[0]);
	show(a, num);
	MyQsort(a, num, sizeof(int), cmpInt);
	show(a, num);
	system("pause");
	return 0;
}
