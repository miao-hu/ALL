#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

1.
int main()
{
	printf("%d", printf("%d", printf("%d", 43)));
	system("pause");
	return 0;
}
//结果为4321,printf实际控制输出的字符数，返回值为字符个数
//先输出43，然后43是两个字符，返回2 ，因此输出2，然后2是一个字符，返回1，因此结果为4321



2.
int main()
{
	printf("hello""bit\n");   //hellobit
	printf("hello"",""bit");  //hello,bit
	system("pause");
	return 0;           //相邻字符串进行连接
}
