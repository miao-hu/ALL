题目：编写一个程序，提示用户读取两个整数，然后显示它们的和。程序应该在输入不正确时提示用户再次读取数字。

import java.util.Scanner;
import java.util.InputMismatchException;

//import java.util.*；可以代替上面两个

public class CalculateSum{
        Scanner input = new Scanner(System.in);
        boolean continueInput = false;
        
        while (!continueInput) {
            try{
                int a = input.nextInt();  //当执行这条语句时，如果键入的输入不是一个整数，就会出现一个InputMismatchException异常
                int b = input.nextInt();  //然后控制被转移到catch块
                System.out.println(a + " + " + b + " = " + (a + b));
                continueInput = true;
            }
            catch (InputMismatchException ex){
                System.out.print("Try again. Enter two Integer: ");
			        	input.nextLine();    //丢弃当前输入行，用户可以键入一个新行
            }   
        }
    }
}
