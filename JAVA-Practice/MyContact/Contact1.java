import java.util.Map;
import java.util.TreeMap;

public class Contact1 {
    Map<String,User> map=new TreeMap<>();
    //名字   信息
    public void remove(String name) throws NameNotFoundException {
        if(!map.containsKey(name)){
            throw new NameNotFoundException();
        }
        map.remove(name);
    }

    public User get(String name) {
        return map.get(name);  //返回值为Null或者对应的value
    }

    public void add(String name, String mobilePhone, String officePhone) throws NameExistException {
        if(map.containsKey(name)){
            throw new NameExistException();
        }
        User user=new User(name,mobilePhone,officePhone);
        map.put(name,user);
    }


    public void show() {
        System.out.println("通讯录信息如下：");
        for(Map.Entry<String,User> e:map.entrySet()){
            System.out.println(e.getValue());
        }
    }
}
