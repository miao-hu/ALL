1.文件的打开与关闭

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>
int main()
{
	FILE *fp = fopen("60_log.txt", "w+");   //文件名：60_log.txt   打开方式：读写
	if (NULL == fp)   //打开失败
	{
		printf("%s:%d\n",strerror(errno), errno);  //错误原因，错误号
	}
	fclose(fp);  //关闭文件
	system("pause");
	return 0;
}


2.fgetc

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int fgetc(FILE *stream);
//从一个文件流读一个字符
//fgetc有可能获取字符失败，返回值为Int可以表示失败情况
//若返回值为char，则放入的都被认为是char型数据，无法表示失败情况

int main()
{
	FILE *fp = fopen("60_log.txt", "w");  //只写方式
	if (NULL == fp)    //打开失败
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 0;
	for (; i < 26; i++)
	{
		fputc('a' + i, fp);
		fputc(' ', fp);      //写入文件a-z字母
	}
	fclose(fp);
	fp = fopen("60_log.txt", "r");  //只读方式
	if (NULL == fp)    //打开失败
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
    i = 0;
	int c;
	for (; i < 26; i++)
	{
		c = fgetc(fp);
		printf("%c", c);
		c = fgetc(fp);
		printf("%c",c);
	}
	fclose(fp);
	system("pause");
	return 0;
}


3.putchar

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>

//int putchar(int c);
//写一个字符到标准输出stdout

//第一种
//int main()
//{
//	putchar('x');   //写一个字符到标准输出stdout
//	system("pause");
//	return 0;                //x
//}


//第二种
int main()
{
	putchar('x');
	fputc('x', stdout);
	system("pause");         //xx
	return 0;
}


//fgetc/fputc/fgets/fputs--->getchar/putchar/gets/puts
//后面的这些接口不用传stdout，底层已经实现

//同理:printf函数的底层肯定有一个参数也传入了stdout，表示它是往显示器上边打


4.fputc

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int fputc( int c, FILE *stream );
//写一个字符到文件流

//第一种
#if 0
int main()
{
	int i = 0;
	for (; i < 26; i++)
	{
		fputc('a' + i, stdout);  //往显示器打
		fputc(' ', stdout);
	}
	system("pause");     //a b c d e .....x y z
	return 0;
}
#endif

//第二种
int main()
{
	FILE *fp = fopen("60_log.txt", "w");   //只写方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 0;
	for (; i < 26; i++)
	{
		fputc('a' + i, fp);
		fputc(' ', fp);
	}
	fclose(fp);                  //a b c d e .....x y z
	system("pause");
	return 0;
}


5.fputs

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int fputs( const char *string, FILE *stream );
//写一个字符串到文件流

//第一种
#if 0
int main()
{
	char *msg = "hello";
	fputs(msg, stdout);   //往显示器打（C程序会默认打开一个流:stdin,stdout,stderror
	system("pause");      //hello
	return 0;
}
#endif


//第二种
#if 0
int main()
{
	char *msg = "hello!%d,%c,%f";
	fputs(msg, stdout);      //纯正的IO输出
	system("pause");         //hello!%d,%c,%f
	return 0;
}
#endif


//第三种
int main()
{
	char *msg = "hello!%d,%c,%f\n";
	FILE *fp = fopen("60_log.txt", "w+");  //读写方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 0; 
	while (i < 10)    //在文件中打印10遍hello!%d,%c,%f
	{
		fputs(msg, fp);
		i++;
	}
	fclose(fp);
	system("pause");
	return 0;
}


6.fgets

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//char *fgets( char *string, int n, FILE *stream );
//从文件流得到一个字符串
//缓冲区存放得到的字符串，读的个数，文件流

int main()
{
	char *msg = "hello world!%d,%c,%f\n";
	FILE *fp = fopen("60_log.txt", "w+");  //读写方式
	fputs(msg, fp);    //把字符串写到文件中
	fclose(fp);
	fp = fopen("60_log.txt", "r");  //只读方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 0;
	char buf[32];  //缓冲区
	while (i < 10)    //读10遍
	{
		fgets(buf, 32, fp);  //把文件fp的内容读到buf中
		i++;
		fputs(buf, stdout);  //把buf中的内容从显示器打印出来
	}
	fclose(fp);
	system("pause");
	return 0;
}


7.fseek

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int fseek( FILE *stream, long offset, int origin );
//文件，偏移量，起始位置
//把文件指正移到一个特殊的位置
//根据文件指针的位置和偏移量来定位文件指针

int main()
{
	FILE *fp = fopen("60_log.txt", "w");  //只写方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 'a';
	for (; i <= 'z'; i++)
	{
		putc(i, fp);       //往文件中写入a-z字符    abcdef....xyz
	}

	//fseek(fp, 3, SEEK_SET);   //起始位置为 文件开头
	//fputs("DEF", fp);

	//fseek(fp, -3, SEEK_END);  //起始位置为 文件结尾
	//fputs("123", fp);

	fseek(fp, 0, SEEK_CUR);     //起始位置为 文件指针当前位置
	fputs("hello", fp);
	fclose(fp);
	system("pause");
	return 0;
}


8.puts

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//int puts( const char *string );
//写一个字符串到显示器

int main()
{
	puts("hello");   //网显示器上打
	system("pause");    //hello
	return 0;
}


9.fprintf

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int fprintf( FILE *stream, const char *format [, argument ]...);
//打印格式化的数据到文件流

int main()
{
	FILE *fp = fopen("60_log.txt", "w+");  //读写方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 10;
	char c = 'a';
	float d = 3.14;
	printf("%d,%c,%f\n", i, c, d);
	fprintf(fp,"%d,%c,%f\n", i, c, d);
	fclose(fp);
	system("pause");
	return 0;
}


10.fscanf

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int fscanf( FILE *stream, const char *format [, argument ]... );
//读格式化的数据到文件流

int main()
{
	FILE *fp = fopen("60_log.txt", "w+");  //读写方式
	int i = 10;
	char c = 'a';
	float d = 3.14;
	fprintf(fp, "%d,%c,%f\n", i, c, d);  //往文件中写数据
	fclose(fp);
	fp = fopen("60_log.txt", "r");  //只读
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	
	//scanf("%d %c %f", &i, &c, &d);     //从标准输入读取
	//printf("%d,%c,%f", i, c, d);

	fscanf(fp,"%d,%c,%f", &i, &c, &d);     //从文件中读
	printf("%d,%c,%f\n", i, c, d);
	fclose(fp);
	system("pause");
	return 0;
}


11.ftell

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//long ftell( FILE *stream );
//得到文件指针的当前位置

int main()
{
	FILE *fp = fopen("60_log.txt", "r");  //只读方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 'a';
	for (; i <='z'; i++)                            //ftell:0
	{												//ftell:1
		printf("ftell:%d\n", ftell(fp));			//ftell:2
		putc(i, fp);								//.......
	}												//ftell:25
	fseek(fp, -10, SEEK_END);						
	printf("ftell:%d\n", ftell(fp));				//ftell:16
	fclose(fp);
	system("pause");
	return 0;
}


12.rewind

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//void rewind( FILE *stream );
//让文件指针回到文件的起始位置

int main()
{
	FILE *fp = fopen("60_log.txt", "r");  //只读方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 'a';
	for (; i <= 'z'; i++)                           //ftell:0
	{												//ftell:1
		printf("ftell:%d\n", ftell(fp));			//ftell:2
		putc(i, fp);								//.......
	}												//ftell:25
	fseek(fp, -10, SEEK_END);
	printf("ftell:%d\n", ftell(fp));				//ftell:16
	rewind(fp);
	printf("ftell:%d\n", ftell(fp));				//ftell:0
	fclose(fp);
	system("pause");
	return 0;
}

	
13.feof

---------文本文件
#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int feof( FILE *stream );
//测试文件是否被读到了结尾

int main()
{
	FILE *fp = fopen("60_log.txt", "w");   //只写方式
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	int i = 0;
	for (; i < 26; i++)
	{
		fputc('a' + i, fp);
	}
	fclose(fp);                  //abcde .....xyz
	fp = fopen("60_log.txt", "r");   //只读方式
	int c;
	while ((c = fgetc(fp) )!= EOF)    //fgetc的返回值为int
	{
		printf("%c\n", c);
	}
	if (feof(fp))
	{
		printf("read file end!\n");
	}
	else if (ferror(fp))
	{
		printf("fgetc error!\n");
	}
	fclose(fp);
	system("pause");
	return 0;
}


--------二进制文件
#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int feof( FILE *stream );
//测试文件是否被读到了结尾

int main()
{
	FILE *fp = fopen("60_log.txt", "wb");   //二进制方式写
	int a[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	fwrite(a, sizeof(*a), 10, fp);   //把a数组的内容写到文件中
	fclose(fp);
	fp = fopen("60_log.txt", "rb");   //二进制方式读
	int x;   //缓冲区x
	while (fread(&x, sizeof(int), 1, fp) >= 1)
	{
		printf("%d\n", x);
	}
	if (feof(fp))
	{
		printf("read end a file!\n");
	}
	else if (ferror(fp))
	{
		printf("error reading!\n");
	}
	fclose(fp);
	system("pause");
	return 0;
}


14.sprintf

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<string.h>

//int sprintf( char *buffer, const char *format [, argument] ... );
//按格式输出到对应缓冲区

int main()
{
	FILE *fp = fopen("60_log.txt", "w+");  //读写方式
	int i = 10;
	char c = 'a';
	float d = 3.14;
	fprintf(fp, "%d,%c,%f\n", i, c, d);  //往文件中写数据
	fclose(fp);
	fp = fopen("60_log.txt", "r");  //二进制读
	if (NULL == fp)
	{
		printf("%s:%d\n", strerror(errno), errno);
	}
	fscanf(fp, "%d,%c,%f", &i, &c, &d);
	printf("%d,%c,%f\n", i, c, d);   

	//int:1,char:a,double:3.140000
	//把i,c,d格式化输出为此种形式放到buf中
	char buf[64];
	sprintf(buf, "int:%d,char:%c,double:%f", i, c, d);
	printf("%s\n", buf);
	fclose(fp);
	system("pause");
	return 0;
}


15.sscanf

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

//int sscanf( const char *buffer, const char *format [, argument ] ... );
//把字符串中的内容按格式输出出来

int main()
{
	char *msg = "a:10,b:20";
	int a, b;
	sscanf(msg, "a:%d,b:%d", &a, &b);    //把10和20从字符串提取出来
	printf("%d,%d\n", a, b);
	system("pause");
	return 0;
}


