import java.util.Map;
import java.util.TreeMap;

public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<>();
        System.out.println(map.get("宋老师"));  //null
        System.out.println(map.getOrDefault("张老师","没有此人"));  //没有此人

        //put()方法返回的是以前的value值
        String oldValue = map.put("汤老师", "12345678");
        System.out.println(oldValue);  //null
        oldValue = map.put("汤老师", "9999999");
        System.out.println(oldValue);  //12345678

        map.put("唐老师","123456789");
        map.put("李老师","465465435");
        map.put("胡老师","454534544");

        //返回所有 key 的不重复集合
        System.out.println(map.keySet()); //[唐老师, 李老师, 汤老师, 胡老师]
        for(String key:map.keySet()){
            System.out.println(key);
        }

        //返回所有 value 的可重复集合
        System.out.println(map.values()); //[123456789, 465465435, 9999999, 454534544]
        for(String value:map.values()){
            System.out.println(value);
        }

        //返回所有的 key-value 映射关系
        System.out.println(map.entrySet()); //[唐老师=123456789, 李老师=465465435, 汤老师=9999999, 胡老师=454534544]
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            /*
                唐老师 123456789
                李老师 465465435
                 汤老师 9999999
                 胡老师 454534544

             */
        }

        System.out.println(map.containsValue("99999999"));  //false
        System.out.println(map.containsKey("胡老师"));       //true
    }
}
