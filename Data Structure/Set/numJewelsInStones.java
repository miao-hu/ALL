import java.util.Set;
import java.util.TreeSet;

public class numJewelsInStones {
    /*第一题：宝石与石头：
                   J代表宝石序列，S代表石头序列
                   统计石头序列中宝石的数目
    */
    public int numJewelsInStones(String J, String S) {
        // 把所有宝石放到 Set 中
        Set<Character> jewels=new TreeSet<>();
        for(char j:J.toCharArray()){
            jewels.add(j);
        }

        // 遍历所有的石头,统计宝石数目
        int count=0;
        for(char s:S.toCharArray()){
            if(jewels.contains(s)){
                count++;
            }
        }
        return count;
    }

}
