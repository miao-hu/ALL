import java.util.Scanner;

public class GuessNumber{
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	
	System.out.println("Guess a magic number between 0 and 100");
	int number=(int)(Math.random()*101);      //产生一个0-100之间的随机数
	int guess=-1;
  
	while(guess!=number){
	  System.out.print("\nEnter your guess:");
	  guess=input.nextInt();
	  
	  if(guess==number){
		System.out.print("Yes,the number is "+number);
	  }
	  else if(guess>number){
			System.out.print("Your guess is too high");
			}
		   else
		   System.out.print("Your guess is too low");
	}
  }
}
