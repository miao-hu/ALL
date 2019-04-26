#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int number, i, n, flag = 0;    //n为项数
	float a;    //等差数列的首项不一定为整数
	printf("输入判断的整数:");
	scanf("%d", &number);
	for (n = 2; n <= number; n++)
	{
		a = (2 * number + n - n*n) / (2.0*n);  //求的首项
		if ((int)(a) == a&&a > 0)  //如果为正整数，则满足要求
		{
			printf("%d=%d", number, (int)(a));//输出的序列第一项
			for (i = 1; i <= n - 1; i++)
			{
				printf("+%d", (int)(a + i));//等差数列的其他项也为整数，a+i实质是整数，强制转换
			}
			printf("\n");
			flag++;   //flag记录满足要求的序列的个数
		}
		if (flag == 0)   //flag初始为0，通过上面的循环，如果有满足的在则不为0，为0则说明不能写成等差数列
			printf("%d不能被表示成n连续正整数之和\n", number);
	}
	system("pause");
	return 0;
}
