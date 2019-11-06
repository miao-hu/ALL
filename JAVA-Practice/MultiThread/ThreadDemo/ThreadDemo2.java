/*
    普通方法发生了死循环
    只打印 我在方法2中打印  这句话，没有打印我在main方法中打印
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        method2();
        while(true){
            System.out.println("我在main方法中打印");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void method2() {
        while(true){
            System.out.println("我在方法2中打印");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
