目录:

一.交换排序
1.冒泡排序
2.快速排序

二.插入排序
1.直接插入排序
2.希尔排序

三.选择排序
1.直接选择排序
2.堆(Heap)排序

四.归并排序
 
 
正文:

一.交换排序
　　交换排序的基本思想都为通过比较两个数的大小，当满足某些条件时对它进行交换从而达到排序的目的。
  
1.冒泡排序
　　基本思想：比较相邻的两个数，如果前者比后者大，则进行交换。每一轮排序结束，选出一个未排序中最大的数放到数组后面。
  
#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>

void bubbleSort(int *arr, int n)
{
	int i=0, j=0,temp=0;
	for (i = 0; i < n - 1; i++)   //排序n-1趟
	{
		for (j = 0; j < n - i - 1; j++)
		{
			if (arr[j]>arr[j + 1])   //若前者比后者大交换
			{
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}
int main()
{
	int arr[] = { 4, 7, 24, 0, 67, 46, 89 };
	int n = sizeof(arr) / sizeof(arr[0]);
	printf("排序前的数组为:");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	bubbleSort(arr, n);
	printf("排序后的数组为:");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	system("pause");
	return 0;
}

分析：最差时间复杂度为O(n^2),平均时间复杂度为O(n^2)。稳定性：稳定。辅助空间O(1)

--------- 升级版冒泡排序法：通过从低到高选出最大的数放到后面，再从高到低选出最小的数放到前面，
   如此反复，直到左边界和右边界重合。当数组中有已排序好的数时，这种排序比传统冒泡排序性能稍好。 
   
#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>

void bubbleSort_1(int *arr, int n)
{
	//设置数组左右边界
	int left = 0,right = n - 1,i,j,temp;
	while (left < right)   //当左右边界未重合时进行排序
	{
		// 从左到右遍历选出最大的数放到数组右边
		for (i = left; i < right; i++)  //5个数排4次
		{
				if (arr[i]>arr[i+1])
				{
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			right--;
		}
	//从右到左遍历选出最小的数放到数组左边
	for (j= right; j>left; j--)
	{
		if (arr[j]>arr[j + 1])
		{
			temp = arr[j];
			arr[j] = arr[j + 1];
			arr[j + 1] = temp;
		}
	}
	left++;
}	
int main()
{
	int arr[] = { 4, 7, 24, 0, 67, 46, 89 };
	int n = sizeof(arr) / sizeof(arr[0]);
	printf("排序前的数组为:");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	bubbleSort_1(arr, n);
	printf("排序后的数组为:");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	system("pause");
	return 0;
}




