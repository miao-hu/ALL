#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>

//第一种
#if 0
int main()
{
	int num = 12;
	int count = 0;
	while (num)
	{
		if (num % 2 == 1)
			count++;
		num = num / 2;
	}
	printf("%d\n", count);
	system("pause");
	return 0;
}
#endif

//第二种
#if 0
int main()
{
	int num = 12;
	int count = 0,i=0;
	for (i = 0; i < 32; i++)      //必须循环32次
	{
		if ((num>>i)& 1 == 1)
			count++;
	}
	printf("%d\n", count);
	system("pause");
	return 0;
}
#endif

//第三种
#if 0
int main()                        //有多少个1就循环了几次，算法高效
{
	int num = 12;
	int count = 0;
	while (num)
	{
		count++;
		num = num&(num - 1);
	}
	printf("%d\n", count);
	system("pause");
	return 0;
}
#endif

//第四种
int main()
{
	int num = 12;
	int count = 0,i=0;
	for (i = 0; i < 32;i++)
	{
		if （(num&(1 << i))！=0）
			count++;
	}
	printf("%d\n", count);
	system("pause");
	return 0;
}
