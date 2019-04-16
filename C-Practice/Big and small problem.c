#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int main()
{
	int n = 0x11223344;
	int *pi = &n;
	char *pc = (char *)&n;
	*pc = 0;           //44被置0  因为char类型一个字节，因此把权值位最低的赋值为0，权值位最低的位为44
	*pi = 0;           //全被置0
	system("pause");
	return 0;
}

//计算机：小端模式
