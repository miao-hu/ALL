int main()
{
	int a = 10;
	int b = 20;
	printf("before:  a=%d b=%d\n", a, b);
	a = a^b;       
	b = a^b;       //b=a^b^b==a==10     一个数异或它本身为0，一个数异或0为它本身
	a = a^b;       //a=a^b^a==b==20
	printf("afetr:  a=%d b=%d\n", a, b);
	system("pause");
	return 0;
}
