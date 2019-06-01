#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int Ret(int arr[], int len)
{
	int i,temp=0;
	for (i = 0; i < len ;i++ )
	{
		temp ^= arr[i];
	}
	return temp;
}


int main()
{
	int arr[7] = { 2,3,2,3,4,4,1};
	int len = sizeof(arr) / sizeof(arr[0]);
	int result=Ret(arr, len);
	printf("result=%d\n", result);
	system("pause");
	return 0;
}
