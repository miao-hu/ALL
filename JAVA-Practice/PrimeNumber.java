//显示素数：在5行中显示前50个素数，每行包含10个数

public class PrimeNumber{
  public static void main(String[] args){
  final int total=50;   //显示的总素数个数
	final int lang=10;    //每行显示的素数个数
	int count=0;
	int number=2;
	
    System.out.println("    The first 50 prime numbers are \n");
	
	while(count<total){
	  boolean isPrime=true; 
	  for(int div=2;div<=number/2;div++){
	    if(number/div==0){   //不是素数
	      isPrime=false;
		    break;
	    }
	  }
	if(isPrime){
	  count++;   //总的个数加1
	  if(count%lang==0)      //每行10个数的最后一个数
	    System.out.println(number);
	  else 
	    System.out.printf("%4d",number);
	}
	  number++;   //判断下一个数
	}	
  
  }
}
	  
	  
	 
