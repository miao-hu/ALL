import java.util.Map;
import java.util.TreeMap;

public class Solution {
    /*统计一个数组中各个数字出现的次数
        [2  2  5  6  1  1  3 ]
        [2-->2, 5-->1, 6-->1, 1-->2, 3-->1]
     */
    public static Map<Integer, Integer> calcCount(int[] nums){
        Map<Integer,Integer> map=new TreeMap<>();
        for(int n:nums){
            Integer old=map.get(n);  //如果map中有这个数则返回它对应的value，也就是出现的次数
            if(old==null){          //如果没有这个数侧返回null
                map.put(n,1);       //自动装箱
            }else{
                map.put(n,old+1);
            }
            /* 或者直接写作：
                   int old=map.getOrDefault(n,0);
                   map.put(n,old+1);
             */
        }
        return map;
    }

    /*
      在一个数组中，查找只出现一次的数字
     */
    public static int singleNumber(int[] nums){
        Map<Integer,Integer> map=new TreeMap<>();
        for(int n:nums){
            int old=map.getOrDefault(n,0);
            map.put(n,old+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int a=entry.getKey();
            int b=entry.getValue();
            if(b==1){
                return a;
            }
        }
        return -1;//没有出现一次的数字返回-1
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map=new TreeMap<>();
        int[] a={2,2,3,3,1,1,1,5};
        map=calcCount(a);
        System.out.println(map);  //{1=3, 2=2, 3=2, 5=1}
        System.out.println(singleNumber(a));  //5
    }
}
