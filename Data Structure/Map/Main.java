import java.util.*;
/*
    由用户输入字符串序列，每个字符串由若干个词组构成，每两个词组之间用空格隔开
    问总共有多少个不同的词组
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        Map<String,Integer> map=new TreeMap<>();
        while(input.hasNext()){         //ctrl+D  表示输入结束
            String s=input.nextLine();  //每次读取一行
            list.add(s);
        }
        for(int i=0;i<list.size();i++){
            String[] a=list.get(i).split(" ");
            for(int j=0;j<a.length;j++){
                int n=map.getOrDefault(a[j],0);
                map.put(a[j],n+1);
            }
        }
        int sum=0;
        for(Map.Entry<String,Integer> e:map.entrySet()){
            sum+=1;
        }
        System.out.println(sum);
    }
}
