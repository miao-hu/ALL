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


//设计一个小程序来判断当前机器的字节序

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//int check_sys()
//{
//	int i = 1;  //0000 0000 0000 0000 0000 0000 0000 0001
//	return(*((char *)&i));
//}

int check_sys()
{
	union
	{
		int i;
		char c;
	}un;
	un.i = 1;
	return un.c;
}
int main()
{
	int ret = check_sys();
	if (1 == ret)
	{
		printf("小端\n");
	}
	else
	{
		printf("大端\n");
	}
	system("pause");
	return 0;
}
