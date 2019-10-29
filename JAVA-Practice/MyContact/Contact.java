import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Contact {
    Map<String,User> map=new TreeMap<>();//根据名字排序

    public void add(String name, String mobilePhone, String officePhone) throws NameExistException {
        User user=new User(name,mobilePhone,officePhone);
        if(map.containsKey(name)){
            throw new NameExistException();
        }
        map.put(name,user); //添加用户
    }

    public void search(String name) throws NotExistPersonException {
        if(!map.containsKey(name)){
          throw new NotExistPersonException();
        }
        for(Map.Entry<String,User> e:map.entrySet()){
            if(name.equals(e.getKey())){
                System.out.println(map.get(name));
            }
        }

    }

    public void remove(String name) throws NotExistPersonException {
        if(!map.containsKey(name)){
            throw new NotExistPersonException();
        }
        map.remove(name);
    }

    public void showContact(){
        System.out.println("通讯录名单如下：");
        for(Map.Entry<String,User> e:map.entrySet()){
            User u=e.getValue();
            System.out.println(u.toString());
        }
    }

    public void update(String name,Scanner input) throws NotExistPersonException {
        if(!map.containsKey(name)){
            throw new NotExistPersonException();
        }
        map.remove(name);
        System.out.print("请输入新的名字:");
        String newName=input.nextLine();
        System.out.print("请输入新的电话号码:");
        String newMobilePhone=input.nextLine();
        System.out.print("请输入新的办公室电话:");
        String newOfficePhone=input.nextLine();

        User u=new User(newName,newMobilePhone,newOfficePhone);
        map.put(newName,u);
    }
}
