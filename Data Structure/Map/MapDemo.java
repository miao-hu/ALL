import com.sun.javafx.collections.MappingChange;

/*
Collection实现的toString()方法是[]   它是按顺序打印
Map实现的toString()方法是{}  Map打印顺序不唯一
 */
import java.util.Map;
import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));  //没有作者返回Null
        System.out.println(map.getOrDefault("作者","默认"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("默认"));
        System.out.println("====================");

        map.put("作者","鲁迅");
        map.put("标题","狂人日记");
        map.put("发表时间","1981");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者","默认"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("默认"));
        System.out.println("====================");

        //Map打印的顺序是无序的
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.print(entry.getKey()+"  ");
            System.out.println(entry.getValue());
        }

        System.out.println("====================");
        for(Map.Entry<String,String> e:map.entrySet()){
            System.out.println(e);
        }
    }
}
