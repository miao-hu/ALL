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
1*2=2   2*2=4
1*3=3   2*3=6   3*3=9
1*4=4   2*4=8   3*4=12  4*4=16
1*5=5   2*5=10  3*5=15  4*5=20  5*5=25
1*6=6   2*6=12  3*6=18  4*6=24  5*6=30  6*6=36
1*7=7   2*7=14  3*7=21  4*7=28  5*7=35  6*7=42  7*7=49
1*8=8   2*8=16  3*8=24  4*8=32  5*8=40  6*8=48  7*8=56  8*8=64
1*9=9   2*9=18  3*9=27  4*9=36  5*9=45  6*9=54  7*9=63  8*9=72  9*9=81
	
	
	
//第二种
public class MultiplicationTable{
	public static void main(String[] args){
	for(int i=1;i<10;i++){
		for(int j=1;j<=i;j++){
			System.out.printf("%d*%d=%-4d",j,i,i*j);
		}
		System.out.println();
		}
	}
}
