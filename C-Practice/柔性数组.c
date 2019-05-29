#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

struct A
{
	int num;
	int a[0];
};

int main()
{
	printf("%d\n", sizeof(struct A));
	struct A *p = (struct A *)malloc((sizeof(struct A) + sizeof(int)* 10));
	p->num = 10;
	int i = 0;
	for (; i < p->num; i++)
	{
		p->a[i] = i;
	}
	free(p);
	system("pause");
	return 0;
}
