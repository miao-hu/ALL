#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<windows.h>
int main()
{
	char input[20] = {0};
	system("shutdown -s -t 60");
again:
	printf("请注意:你的电脑将在60秒后关机，若你输入:我是猪则可以解除关机命令\n");
	scanf("%s", input);
	if (strcmp(input,"我是猪") == 0)
	{
		system("shutdown -a");
	}
	else
	{
		goto again;
	}
	return 0;
}
