//打印1-9乘法表

            MultiplicationTable
    1    2    3    4    5   6    7    8    9
------------------------------------------------
1 | 1    2    3    4    5   6    7    8    9
2 | 2    4    6    8    10
3 |
4 |
5 |
6 |
7 |
8 |
9 |


		    
//第一种
public class MultiplicationTable{ 
	public static void main(String[] args){
	  System.out.println("\n           MultiplicationTable");
	  System.out.print("\n   ");
	  for(int i=1;i<=9;i++){
		System.out.printf("%4d",i);
	  }
	  System.out.println("\n-----------------------------------------");
	  for(int j=1;j<=9;j++){
		System.out.print(j+" |");
		for(int k=1;k<=9;k++){
		  System.out.printf("%4d",j*k);
		}
		System.out.println();
	  }
	}
}




1*1=1
2*1=2   2*2=4
3*1=3   3*2=6   3*3=9
4*1=4   4*2=8   4*3=12  4*4=16
5*1=5   5*2=10  5*3=15  5*4=20  5*5=25
6*1=6   6*2=12  6*3=18  6*4=24  6*5=30  6*6=36
7*1=7   7*2=14  7*3=21  7*4=28  7*5=35  7*6=42  7*7=49
8*1=8   8*2=16  8*3=24  8*4=32  8*5=40  8*6=48  8*7=56  8*8=64
9*1=9   9*2=18  9*3=27  9*4=36  9*5=45  9*6=54  9*7=63  9*8=72  9*9=81
	
	
	
//第二种
public class MulTable{
	public static void main(String[] args){
	for(int i=1;i<10;i++){
		for(int j=1;j<=i;j++){
			System.out.printf("%d*%d=%-4d",i,j,i*j);
		}
		System.out.println();
		}
	}
}
