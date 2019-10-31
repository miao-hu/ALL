import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        while (true) {
            // 1. 打印操作界面
            menu();
            // 2. 用户输入选择
            int selected = scanner.nextInt();
            scanner.nextLine();  //把\n读掉
            // 3. 根据用户的选择，执行不同的动作
            switch (selected) {
                case 1:
                    add(contact, scanner);
                    contact.show();
                    break;
                case 2:
                    search(contact, scanner);
                    break;
                case 3:
                    remove(contact, scanner);
                    contact.show();
                    break;
                case 4:
                    update(contact, scanner);
                    contact.show();
                    break;
                default:
                    System.out.println("指令错误");
            }
        }
    }

    private static void menu() {
        System.out.println("| 1. 添加");
        System.out.println("| 2. 查找");
        System.out.println("| 3. 删除");
        System.out.println("| 4. 更新");
        System.out.print("请选择正确的选项:");
    }

    private static void remove(Contact contact, Scanner scanner){
        System.out.print("请输入要删除的人的姓名:");
        String name=scanner.nextLine();
        try{
            contact.remove(name);
            System.out.println("删除成功");
        }catch(NameNotFoundException ex){
            System.out.println("通讯录没有这个人，删除失败");
        }
    }

    private static void search(Contact contact, Scanner scanner){
        System.out.print("请输入要查找的人的姓名:");
        String name=scanner.nextLine();
        User use=contact.get(name);
        if(use==null){
            System.out.println("通讯录没有此人");
        }else{
            System.out.println("手机电话为:" +use.mobilePhone);
            System.out.println("办公室电话为:" +use.officePhone);

        }
    }

    private static void add(Contact contact, Scanner scanner){
        System.out.print("请输入姓名:");
        String name = scanner.nextLine();
        System.out.print("请输入手机:");
        String mobilePhone = scanner.nextLine();
        System.out.print("请输入办公室电话:");
        String officePhone = scanner.nextLine();
        try{
            contact.add(name,mobilePhone,officePhone);
            System.out.println("添加成功");
        }catch (NameExistException ex){
            System.out.println("这个人已经存在，无法添加");
        }
    }

    private static void update(Contact contact, Scanner scanner){
        System.out.print("请输入要更新的人的姓名: ");
        String name = scanner.nextLine();
        System.out.println("请选择要更新的字段: ");
        System.out.println("1. 姓名");
        System.out.println("2. 手机号");
        System.out.println("3. 办公室电话");
        int selected=scanner.nextInt();
        scanner.nextLine();
        switch(selected){
            case 1: {
                System.out.print("请输入新的名字:");
                String newName = scanner.nextLine();
                User user = contact.get(name);
                if (user == null) {
                    System.out.println("查无此人");
                } else {
                    try {
                        contact.add(newName, user.mobilePhone, user.officePhone);
                        try {
                            contact.remove(name);

                        } catch (NameNotFoundException ex) {

                        }
                    } catch (NameExistException ex) {
                        System.out.println("这个新名字已经存在");
                    }
                }
                break;
            }
            case 2: {
                System.out.print("请输入新的手机号码:");
                String newMobilePhone= scanner.nextLine();
                User user = contact.get(name);
                if(user==null){
                    System.out.println("查无此人");
                }
                else {
                   user.mobilePhone=newMobilePhone;
                    System.out.println("手机号码修改成功");
                }
                break;
            }
            case 3:{
                System.out.print("请输入新的办公室号码:");
                String newOfficePhone= scanner.nextLine();
                User user = contact.get(name);
                if(user==null){
                    System.out.println("查无此人");
                }
                else {
                    user.officePhone=newOfficePhone;
                    System.out.println("办公室号码修改成功");
                }
                break;
             }
        }
    }
}
