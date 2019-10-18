import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BrokenKeyboard {
    /*第二题：旧键盘 (找出旧键盘损坏的键）：
            输入：7_This_is_a_test   正确值
                  _hs_s_a_es         错误值
            输出：7TI
            思路：把所有的错误值放到Set中
                  看Set中是否包含正确值   不包含则输出
                  注意  错误键全部输出为大写，并且只输出一次
     */
    public void BrokenKeyboard(){
        Scanner input=new Scanner(System.in);
        String right=input.nextLine();
        String wrong=input.nextLine();

        Set<Character> set=new TreeSet<>();
        for(char w:wrong.toCharArray()){
            set.add(w);
        }

        Set<Character> written=new TreeSet<>();//统计已经写过的
        for(char r:right.toCharArray()) {
            if (!set.contains(r)) {
                char c = Character.toLowerCase(r);  //把每个字母转换为大写
                if (!written.contains(c)) {
                    System.out.println(c);
                    written.add(c); //已经打印过的记入writen  以后出现不再打印
                }
            }
        }
    }
}
