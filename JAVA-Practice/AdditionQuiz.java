//（游戏：加法实验）随机产生一个加法问题。
//随机产生一个计算两个小于100的整数的加法问题。



import java.util.Scanner;

public class AdditionQuiz{
  public static void main(String[] args){
  
    int number1=(int)(Math.random()*100);
    int number2=(int)(Math.random()*100);
    
    System.out.print("What is"+number1+"+"+number2+"?");
    
    Scanner input=new Scanner(System.in);
    int answer=input.nextInt();
    
    if(number+number==answer)
      System.out.println("You are correct!");
    else{
        System.out.println("You answer is wrong");
        System.out.println(number1+"+"number2+"should be"+(number1+number2));
        }
    }
}
    
