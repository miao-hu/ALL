//忽略一个字符串中不是字母或数字的字符判断该字符串是不是回文
import java.util.Scanner;

public class PalindromeIgnoreNonAlphanumeric{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
	
	System.out.print("Enter a string:");
	String s=input.nextLine();   //读取一行
	
	System.out.println("Ingnoring nonalphanumeric characters,\nis "+
						s+" a palindrome ? "+isPalindrome(s));
  }
  
  public static boolean isPalindrome(String s){
    String s1=filter(s);      //去掉字符串中不是字母或数字的字符
	  String s2=reverse(s1);    //逆置字符串s1
  	return s2.equals(s1);     //判断回文
  }
  
  public static String filter(String s){
	  StringBuilder stringBuilder=new StringBuilder();     //创建一个空的字符串生成器
	  for(int i=0;i<s.length();i++){
	    if(Character.isLetterOrDigit(s.charAt(i)))
		  stringBuilder.append(s.charAt(i));         //在字符串生成器末尾追加该i下标处的字符
	  }
	return stringBuilder.toString();     //从字符串生成器返回一个字符串对象
  }
  
  public static String reverse(String s){
	  StringBuilder stringBuilder=new StringBuilder(s);
	  stringBuilder.reverse();       //颠倒生成器中的字符
	  return stringBuilder.toString();
  }
}
  
	  
	  
	  
	  
