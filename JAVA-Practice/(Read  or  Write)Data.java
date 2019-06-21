//（写/读数据）写一个程序去创建一个名为Exercise12_15.txt的文件，如果该文件不存在的话。
//            使用文本I/O设备往文件中写100的随机整数，在文件中这些数字用空格分开。
//            然后从文件中读取数字，并且展示这个数字以升序的方式。


import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;

public class ReadNumberData
{
    public static void main(String [] args) throws Exception
    {
        File file = new File("Exercise12_15.txt");//创建一个文件对象file
        PrintWriter output = null;  //创建一个PrintWriter对象output
        if (!file.exists())//若文件不存在
        {
            output = new PrintWriter(file);
        }
        Random random = new Random(7);
        for (int i = 0; i < 100; i++)
        {
            output.print(random.nextInt(100) + " ");//往文件中写随机数
        }

        output.close();//关闭文件

        Scanner input = new Scanner(file);  //创造一个Scanner对象，从文件键入
        int[] numbers = new int[100];
        int index = 0;
        while (input.hasNext())  //文件还没有读取完
        {
            numbers[index++] = input.nextInt();
            input.skip(" ");     //跳过空格字符串
        }
        input.close(); //关闭

        Arrays.sort(numbers);  //升序排序数组
//for(int i : index)的意思就是说
//遍历index数组，每次遍历的对象用i 这个对象去接收。
//相当于：
//int i=0; //用于接收index数组中的某一个对象
//for(int j = 0;j<index.length;j++){
//i = index[j];
//} 
        for (int number : numbers)
        {
            System.out.println(number);
        }
    }
}
