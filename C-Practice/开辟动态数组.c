#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

struct A
{
	int num;
	int *p;
};

int main()
{
	struct A *ap = (struct A *)malloc(sizeof(struct A));//申请一个结构体大小

	ap->num = 10;
	ap->p = (int *)malloc(sizeof(int)*ap->num);   //申请的数组大小
	int i = 0;
	for (i = 0; i < ap->num; i++)
	{
		ap->p[i] = i;
	}
	free(ap->p);    //必须先释放这个指针
	free(ap);
	system("pause");
	return 0;
}
