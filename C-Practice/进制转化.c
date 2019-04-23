//写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串(注意可能存在的一个测试用例里的多组数据)。 

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main()
{
   int num = 0;   
   while (~scanf("%x", &num))
   {
	   printf("%d\n", num);
   }
   system("pause");
   return 0;
}

//写出一个程序，接受一个八进制的数值字符串，输出该数值的十进制字符串(注意可能存在的一个测试用例里的多组数据)。

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num = 0;
	while (~scanf("%o", &num))
	{
		printf("%d\n", num);
	}
	system("pause");
	return 0;
}

//写出一个程序，接受一个十进制的数值字符串，输出该数值的十六进制字符串(注意可能存在的一个测试用例里的多组数据)。

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num = 0;
	while (~scanf("%d", &num))
	{
		printf("%x\n", num);
	}
	system("pause");
	return 0;
}

//写出一个程序，接受一个十进制的数值字符串，输出该数值的八进制字符串(注意可能存在的一个测试用例里的多组数据)。

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int num = 0;
	while (~scanf("%d", &num))
	{
		printf("%o\n", num);
	}
	system("pause");
	return 0;
}
