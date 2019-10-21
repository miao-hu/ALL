import java.util.*;
import java.util.stream.Collectors;

/*前K个高频单词：
        给一非空的单词列表，返回前 k 个出现次数最多的单词。
        返回的答案应该按单词出现频率由高到低排序。
        如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class TpK {
    /*
        统计每个单词出现的次数
        the   4
        is    4
        student   6
     */
    public static Map<String, Integer> calcCount(String[] words){
        Map<String,Integer> map=new TreeMap<>();
        for(String w:words){
            int count=map.getOrDefault(w,0);
            map.put(w,count+1);
        }
        return map;
    }

    /*
        把单词出现次数相同的统计在一起
        4  [the,is,student]
        5  [book]
        1  [new]
        字符串类型的数组我们定义为List<String>
     */
    public static Map<Integer, List<String>> calcCountOfWords(Map<String, Integer> map){
        Map<Integer, List<String>> ret=new TreeMap<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String word=e.getKey();  //得到每一个key
            int count=e.getValue();  //得到每一个value

            if(!ret.containsKey(count)){  //如果没有包含，先创建一个空的顺序表
                ret.put(count,new ArrayList<>());
            }
            ret.get(count).add(word); //包含了直接在顺序表里面增加字符串
        }
        return ret;
    }

    /*
        Integer自带的自然顺序的比较是升序
        和我们想要的比较顺序不一样，所以要定义一个比较器
        这个比较器按逆序排序
     */
    private static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args){
        String[] words = {"the", "day", "is", "sunny", "is", "the", "the", "the", "sunny", "is", "is"};
        int k = 3;   //返回前3个出现频率最高的单词

        //[the=4,day=5,is=1]
        Map<String, Integer> wordCount = calcCount(words);
        System.out.println(wordCount);

        //4=[the,is,a]    5=[an,new]   1=[left]
        Map<Integer, List<String>> countToWordList = calcCountOfWords(wordCount);
        System.out.println(countToWordList);

        //从countToWordList得到每一个key   也就是单词出现的次数列表[4 5 2 1]
        Set<Integer> count=countToWordList.keySet();
        System.out.println(count);

        //把单词出现的次数列表降序排列 [5 4 2 1]
        List<Integer> countList=new ArrayList<>(count);
        Collections.sort(countList,new IntegerComparator());//这个比较器规则逆序排序
        System.out.println(countList);

        //输出前K个出现次数最多的单词
        List<String> list=new ArrayList<>();
        int i=0;
        int n=0;
        while(n<k){ //取单词
            int r=countList.get(i);   //从逆序列表中不断取元素
            i++;   //取降序列表的下一个元素

            List<String> ws=countToWordList.get(r);  //取出出现次数为r的所有字符串放到ws中
            Collections.sort(ws);//对出现次数为r的  字符串数组里面的字符串进行升序排序

            if(ws.size()<=k-n){  // 如果候选人数量小于需要人数，全部录取
                list.addAll(ws);
                n+=ws.size();
            }else{   // 否则，只录取需要的人数
                list.addAll(ws.subList(0,k-n));
                n+=(k-n);
            }
            System.out.println(list);
        }
    }
}
