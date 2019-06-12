#if 0
一.需求分析
    本演示程序用c语言编写，完成设计学校的平面图，至少包括10个以上场所，每两个场所之间可以有不同的路，
    且路长也可能不同，找出从任意场所到达另一场所的最佳路径（最短路）功能。
    具体要求为设计校园平面图，在校园景点选10个左右景点。以图中顶点表示校园内各景点，存放景点名称、代号、简介等信息，以边表示路径，
    存放路径长度等有关信息。同时为来访客人提供图中任意景点相关信息的查询和为来访客人提供任意景点的问路查询
    ，即查询任意两个景点之间的一条最短路径。 

(1)输入的形式和输入值的范围:
  查询任意景点信息时输入景点代号,范围为1-10.
  查找任意两个景点之间的最短路径时,需要输入起点和终点.
  （注:在所有输入中,元素的值都是整数）
(2)输出的形式
  在查询景点信息时显示景点名称,代号,简介.
  在查找任意两个景点之间的最短路径时先输出最短路径,在输出最短路径长度.
  若两景点之间无路径存在时,输出无路径存在!
(3)程序所能达到的功能
  设计要求：设计学校的平面图，至少包括10个以上场所，每两个场所之间可以有不同的路，且路长也可能不同，找出从任意场所到达另一场所的最佳路径（最短路）。
  基本要求：
①　设计校园平面图，在校园景点选10个左右景点。以图中顶点表示校园内各景点，存放景点名称、代号、简介等信息，以边表示路径，存放路径长度等有关信息。
②　为来访客人提供图中任意景点相关信息的查询。
③　为来访客人提供任意景点的问路查询，即查询任意两个景点之间的一条最短路径。
(4)测试数据
a.查询任意景点信息时输入景点代号2
输出结果:景点编号:2 景点名称:实验楼 景点简介:222
b.查找任意两个景点之间的最短路径时,需要输入起始节点2和终止节点4
输出结果: v2到v4的最短路径为:v2--50→v3--60→v4
         2→4的最短路径是：110
c.查找任意两个景点之间的最短路径时,需要输入起始节点3和终止节点3
输出结果：节点3和节点3之间没有路径存在！
d.退出系统输入3
输出结果：谢谢使用！
#endif



二.实验代码

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include<string.h>
 

#define INFINTY 32768  
#define N 10             /*目前景点个数*/
 
typedef struct
{
    char name[30];          /*景点名称*/
    char number[10];        /*景点代号*/
    char introduce[10];    /*景点介绍*/	
}Elemtype;                  /*景点信息*/
 
typedef struct
{
    int num;              /*景点编号*/
    Elemtype date;        /*景点信息*/
}View;                    /*定义景点*/
 
typedef struct
{
    View view[N];         /*存放顶点的一维数组，数组第零单元没有用上*/
    int length[N][N];  /*存放路径长度*/
    int m,n;
}MGraph;
 
MGraph MGr;              /*全局变量,定义MGr为MGraph类型*/
void init()
{
    int i,j;
    MGr.view[1].num=1;
    strcpy(MGr.view[1].date.name,"正门");
    strcpy(MGr.view[1].date.number,"1");
    strcpy(MGr.view[1].date.introduce,"111");
	
    MGr.view[2].num=2;
    strcpy(MGr.view[2].date.name,"实验楼");
    strcpy(MGr.view[2].date.number,"2");
    strcpy(MGr.view[2].date.introduce,"222");
	
    MGr.view[3].num=3;
    strcpy(MGr.view[3].date.name,"教学楼");
    strcpy(MGr.view[3].date.number,"3");
    strcpy(MGr.view[3].date.introduce,"333");
	
    MGr.view[4].num=4;
    strcpy(MGr.view[4].date.name,"人工湖");
    strcpy(MGr.view[4].date.number,"4");
    strcpy(MGr.view[4].date.introduce,"444");
	
    MGr.view[5].num=5;
    strcpy(MGr.view[5].date.name,"图书馆");
    strcpy(MGr.view[5].date.number,"5");
    strcpy(MGr.view[5].date.introduce,"555");
	
    MGr.view[6].num=6;
    strcpy(MGr.view[6].date.name,"文苑");
    strcpy(MGr.view[6].date.number,"6");
    strcpy(MGr.view[6].date.introduce,"666");
	
    MGr.view[7].num=7;
    strcpy(MGr.view[7].date.name,"东环操场");
    strcpy(MGr.view[7].date.number,"7");
    strcpy(MGr.view[7].date.introduce,"777");
	
    MGr.view[8].num=8;
    strcpy(MGr.view[8].date.name,"餐厅");
    strcpy(MGr.view[8].date.number,"8");
    strcpy(MGr.view[8].date.introduce,"888");
	
    MGr.view[9].num=9;
    strcpy(MGr.view[9].date.name,"校医院");
    strcpy(MGr.view[9].date.number,"9");
    strcpy(MGr.view[9].date.introduce,"999");
	
    MGr.view[10].num=10;
    strcpy(MGr.view[10].date.name,"东门");
    strcpy(MGr.view[10].date.number,"10");
    strcpy(MGr.view[10].date.introduce,"1010");
	
    for(i=1;i<=N;i++)
	{
		for(j=1;j<=N;j++)
        {
			MGr.length[i][j]=INFINTY;
        }
    }
    
    MGr.length[1][2]=MGr.length[2][1]=50;
    MGr.length[2][3]=MGr.length[3][2]=50;
    MGr.length[3][4]=MGr.length[4][3]=60;
    MGr.length[3][5]=MGr.length[5][3]=100;
    MGr.length[5][6]=MGr.length[6][5]=100;
    MGr.length[6][7]=MGr.length[7][6]=220;
	MGr.length[6][9]=MGr.length[9][6]=80;
    MGr.length[7][8]=MGr.length[8][7]=250;
    MGr.length[8][9]=MGr.length[9][8]=100;
	MGr.length[8][10]=MGr.length[10][8]=150;
    MGr.length[1][1]=MGr.length[2][2]=MGr.length[3][3]=MGr.length[4][4]=0;
    MGr.length[5][5]=MGr.length[6][6]=MGr.length[7][7]=MGr.length[8][8]=0;
    MGr.length[9][9]=MGr.length[10][10]=0;
}
 
void introduce()
{
    int m;
    printf("请输入查询景点编号:\n");
    scanf("%d",&m); 
    switch(m)
    {
	case 1:
		printf("景点编号:%s\t",MGr.view[1].date.number);
		printf("景点名称:%s\n",MGr.view[1].date.name);
		printf("景点简介:%s\n",MGr.view[1].date.introduce);
		break;
	case 2:
		printf("景点编号：%s\t",MGr.view[2].date.number);
		printf("景点名称：%s\n",MGr.view[2].date.name);
		printf("景点简介：%s\n",MGr.view[2].date.introduce);
		break;
	case 3:
		printf("景点编号：%s\t",MGr.view[3].date.number);
		printf("景点名称：%s\n",MGr.view[3].date.name);
		printf("景点简介：%s\n",MGr.view[3].date.introduce);
		break;
	case 4:
		printf("景点编号：%s\t",MGr.view[4].date.number);
		printf("景点名称：%s\n",MGr.view[4].date.name);
		printf("景点简介：%s\n",MGr.view[4].date.introduce);
		break;
	case 5:
		printf("景点编号：%s\t",MGr.view[5].date.number);
		printf("景点名称：%s\n",MGr.view[5].date.name);
		printf("景点简介：%s\n",MGr.view[5].date.introduce);
		break;
	case 6:
		printf("景点编号：%s\t",MGr.view[6].date.number);
		printf("景点名称：%s\n",MGr.view[6].date.name);
		printf("景点简介：%s\n",MGr.view[6].date.introduce);
		break;
	case 7:
		printf("景点编号：%s\t",MGr.view[7].date.number);
		printf("景点名称：%s\n",MGr.view[7].date.name);
		printf("景点简介：%s\n",MGr.view[7].date.introduce);
		break;
	case 8:
		printf("景点编号：%s\t",MGr.view[8].date.number);
		printf("景点名称：%s\n",MGr.view[8].date.name);	
		printf("景点简介：%s\n",MGr.view[8].date.introduce);
		break;
	case 9:
		printf("景点编号：%s\t",MGr.view[9].date.number);
		printf("景点名称：%s\n",MGr.view[9].date.name);
		printf("景点简介：%s\n",MGr.view[9].date.introduce);
		break;
	case 10:
		printf("景点编号：%s\t",MGr.view[10].date.number);
		printf("景点名称：%s\n",MGr.view[10].date.name);
		printf("景点简介：%s\n",MGr.view[10].date.introduce);
		break;
	default:
		printf("输入序号错误。\n");
		break;
    }
    printf("\n");
}
 

 

 
  /*最短路径算法*/
int D[11];
int S[11],P[11];
int source,sink;

int top = -1;                    
int Stack[11];   
         
void input()                  
{
	int i;
	printf("\n请输入起始节点:");
	scanf("%d",&source);
	printf("\n请输入结束节点:");
	scanf("%d",&sink);
	for ( i = 1; i <= N; i++ )
	{
		S[i] = 0;                     
		D[i] = MGr.length[source][i];      
		P[i] = source;      
	}
	S[source] = 1;          
	D[source] = 0;
}

void Push(int value)
{
	if ( top >= 11)
	{
		printf("没有路径存在!\n\n");
		exit(1);
	}
	else
		Stack[++top] = value;
}

int Pop()
{
	if ( top < 0 )
	{
		printf("没有路径存在!\n\n");
		exit(1);
	}
	return Stack[top--];
}

int minD()
{
	int i,t=0;
	long int minimum =INFINTY ;
	for ( i=1;i<=N;i++ )
		if ( (S[i] == 0) && D[i] < minimum )
		{
			minimum = D[i];
			t = i;
		}
		return t;
}
 
void output_path()
{
	int node = sink;   //终点
	
	if ( (sink == source) || (D[sink] == INFINTY) )
	{
		printf("\n节点%d与节点%d之间没有路径存在！\n\n",source,sink);
		return;
	}
	printf("\n");
	
	while ( node != source )
	{
		Push(node);
		node  = P[node];
	} 
	printf("V%d到V%d的最短路径为:\n",source,sink);
	printf("  V%d",source);
	while( node != sink)
	{
		node = Pop();
		printf(" --%ld-->",MGr.length[ P[node] ][node]);
		printf("V%d",node);
	}
	printf("\n");
	printf("\n %d->%d的最短路径是： %ld\n",source,sink,D[sink]);
	printf("\n");
}

void distance()
{   
	int step = 1;
	int t,I;
	input();
	for ( step =2;step <=N; step++ )
	{	
		t = minD();
		S[t] = 1;
		
		for ( I=1; I <= N; I++ )
			if ( (S[I] == 0) && (D[t]+MGr.length[t][I] <= D[I]) )
			{
				D[I] = D[t] + MGr.length[t][I];
				P[I] = t;
			}
	}
	output_path();
} 


int main()
{
    char k;
    init();
	printf("*           欢迎使用校园导航系统 !                     *\n");

    printf("\n");
    while(1)
    {   
		printf("1.景点信息查询请按“1”键;\n");
		printf("2.景点最短路径查询请按“2”键;\n");
		printf("3.退出系统请按“”键;\n");
		printf("请选择: \n");
		scanf("%c",&k);
		
		switch(k)
		{
		case '1':printf("景点介绍查询（请输入1-10）。\n");
			introduce();break;
	
		case '2':printf("景点最短路径查询。");
			distance();break;
		case '3':printf("谢谢使用!\n");exit(0);
		}
    }
    system("pause");
	return 0;
}

