#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*
4. 编写一个函数 reverse_string(char * string)（递归实现）
实现：将参数字符串中的字符反向排列。
要求：不能使用C函数库中的字符串操作函数。
abcdef  ===>  fedcba  ==>字符数组
*/

//循坏法
void reverse_string(char * string)
{
	char *left = string;       //char类型的数组就设立char类型的指针
	char *right = string+strlen(string) - 1;
	while (left <=right)
	{
		int temp = *left;
		*left =* right;
		*right = temp;
		left++;
		right--;
	}
}
int main()
{
	char s[] = "abcdef";                 //注意：此处必须为数组
	/*	    char *str = "abcdef";        //readOnly只读，不能修改
			*(str+1) = 'g';           //b-->g是错误的
	*/

	printf("%s\n", s);       
	reverse_string(s);
	printf("%s\n", s);
	system("pause");
	return 0;
}

//递归法
void reverse_string(char * string)
{

}
int main()
{
	char s[] = "abcdef";                 //注意：此处必须为数组
	printf("%s\n", s);
	reverse_string(s);
	printf("%s\n", s);
	system("pause");
	return 0;
}
