#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//递归
/*
1       A-->C                                                1
2       A-->B  A-->C  B-->C                                  3
3       A-->C  A-->B  C-->B  A-->C  B-->A  B-->C  A-->C      7
4
64     2^64-1
*/
//这个用电脑算出来要好几百年
void Move(char pos1,char pos2)
{
	printf("%c-->%c\n", pos1, pos2);
}
void Hanoi(int num, char pos1, char pos2, char pos3)
{
	if (num == 1)                //只有一个盘子，直接从A挪到C
	{
		Move(pos1, pos3);
	}
	else
	{
		Hanoi(num-1,pos1,pos2,pos3);     //把n-1个盘子从A挪到B，借助C
		Move(pos1, pos3);           //把剩余的一个盘子直接从A挪到C
		Hanoi(num - 1, pos2, pos3, pos1);        //把刚刚挪的n-1个盘子从B挪到C，借助A
	}
}

int main()
{
	int num;
	printf("请输入盘子的个数:>");
	scanf("%d", &num);
	Hanoi(num, 'A', 'B', 'C');           //三个位置分别设为A,B,C
	system("pause");
	return 0;
}
