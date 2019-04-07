#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int amount=0, Board[100][100];
void Cover(int tr, int tc, int dr, int dc, int size)

{

	int s, t;

	if (size<2)

		return;

	amount++;

	t = amount;

	s = size / 2;

	if (dr<tr + s&&dc<tc + s)

	{

		Cover(tr, tc, dr, dc, s);

		Board[tr + s - 1][tc + s] = t;

		Board[tr + s][tc + s - 1] = t;

		Board[tr + s][tc + s] = t;

		Cover(tr, tc + s, tr + s - 1, tc + s, s);

		Cover(tr + s, tc, tr + s, tc + s - 1, s);

		Cover(tr + s, tc + s, tr + s, tc + s, s);

	}

	else if (dr<tr + s&&dc >= tc + s)

	{
		Cover(tr, tc + s, dr, dc, s);

		Board[tr + s - 1][tc + s - 1] = t;

		Board[tr + s][tc + s - 1] = t;

		Board[tr + s][tc + s] = t;



		Cover(tr, tc, tr + s - 1, tc + s - 1, s);

		Cover(tr + s, tc, tr + s, tc + s - 1, s);

		Cover(tr + s, tc + s, tr + s, tc + s, s);

	}

	else if (dr >= tr + s&&dc<tc + s)

	{
		Cover(tr + s, tc, dr, dc, s);

		Board[tr + s - 1][tc + s - 1] = t;

		Board[tr + s - 1][tc + s] = t;

		Board[tr + s][tc + s] = t;



		Cover(tr, tc, tr + s - 1, tc + s - 1, s);

		Cover(tr, tc + s, tr + s - 1, tc + s, s);

		Cover(tr + s, tc + s, tr + s, tc + s, s);

	}

	else

	{
		Cover(tr + s, tc + s, dr, dc, s);

		Board[tr + s - 1][tc + s - 1] = t;

		Board[tr + s - 1][tc + s] = t;

		Board[tr + s][tc + s - 1] = t;



		Cover(tr, tc, tr + s - 1, tc + s - 1, s);

		Cover(tr, tc + s, tr + s - 1, tc + s, s);

		Cover(tr + s, tc, tr + s, tc + s - 1, s);

		

	}

}



void OutputBoard(int size)

{

	for (int i = 0; i <size; i++)

	{

		for (int j = 0; j < size; j++)

			printf("%5d ", Board[i][j]);

		printf("\n");

	}

}
int main()

{

	int size= 1, x,y,i,k;

	printf("输入2残缺棋盘的规模:2^k,k=");

	scanf("%d", &k);

	for (i = 1; i <= k; i++)

		size *= 2;

	printf("输入棋盘残缺位置对应的坐标(x,y):");

	scanf("%d %d", &x, &y);

	Cover(0, 0, x,y, size);

	OutputBoard(size);
	system("pause");
	return 0;

}
