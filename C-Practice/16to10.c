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
