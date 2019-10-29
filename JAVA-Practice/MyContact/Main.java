import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Contact contact=new Contact();  //创建一个通讯录
        while(true){
            // 1. 打印操作界面
            menu();
            // 2. 用户输入选择
            int selected=input.nextInt();
            input.nextLine();//把\n读掉
            // 3. 根据用户的选择，执行不同的动作
            switch (selected){
                case 1:
                    add(contact,input);
                    break;
                case 2:
                    search(contact,input);
                    break;
                case 3:
                    remove(contact,input);
                    break;
                case 4:
                    update(contact,input);
                    break;
                case 5:
                    showContact(contact);
                    break;
                default:
                    System.out.println("你输入的选择有误，请输入数字1-4");
            }
        }
    }

    private static void showContact(Contact contact) {
        contact.showContact();
    }

    private static void add(Contact contact, Scanner input) {
        System.out.print("请输入姓名：");
        String name=input.nextLine();
        System.out.print("请输入手机号码：");
        String mobilePhone=input.nextLine();
        System.out.print("请输入办公室电话：");
        String officePhone=input.nextLine();

        try{
            contact.add(name,mobilePhone,officePhone);
            System.out.println("用户添加成功");
        }catch(NameExistException ex){
            System.out.println("添加失败，用户已经存在");
        }
    }

    private static void search(Contact contact, Scanner input) {
        System.out.print("请输入要查找的人的姓名：");
        String name=input.nextLine();
        try{
            contact.search(name);
            System.out.println("用户查找成功");
        }catch (NotExistPersonException ex){
            System.out.println("该通讯录没有这个人存在");
        }

    }

    private static void remove(Contact contact, Scanner input) {
        System.out.print("请输入要删除的人的姓名：");
        String name=input.nextLine();
        try{
            contact.remove(name);
            System.out.println("用户删除成功");
        }catch (NotExistPersonException ex){
            System.out.println("该通讯录没有这个人存在，无法删除");
        }finally{
            contact.showContact();
        }
    }

    private static void update(Contact contact, Scanner input) {
        System.out.print("请输入要更新的人的姓名：");
        String name=input.nextLine();;
        try {
            contact.search(name);
            contact.update(name,input);
            System.out.println("更新成功");
        }catch(NotExistPersonException ex){
            System.out.println("该通讯录没有这个人存在，无法更新");
        }finally {
            contact.showContact();
        }
    }

    private static void menu(){
        System.out.println("====================");
        System.out.println("==   1.添加人员    ==");
        System.out.println("==   2.查找人员    ==");
        System.out.println("==   3.删除人员    ==");
        System.out.println("==   4.更新人员    ==");
        System.out.println("==   5.展示通讯录  ==");
        System.out.println("====================");
        System.out.print("请输入你的选择：");
    }
}
