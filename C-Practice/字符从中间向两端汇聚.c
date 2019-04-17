#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<windows.h>

int main()
{
		char arr1[] = { "I want to kill you, Zhangdingyu" };
		char arr2[] = { "*******************************" };
		int left = 0;                                       //左下标
		int right = strlen(arr1) - 1;                       //右下标     strlen()求字符串长度，不包含\0
		printf("%s\n", arr2);
		while (left <= right)
		{
			arr2[left] = arr1[left];                      //交换字符串内容
			arr2[right] = arr1[right];
			printf("%s\n", arr2);
			Sleep(1000);                 //间隔1秒
			system("cls");        //清屏
			left++;
			right--;		
		}

		system("pause");
		return 0;
	}
