/*
让李四先开始工作       ================去掉join()方法后结果
李四工作结束了，让王五开始工作
王五工作结束
李四：我正在工作
王五：我正在工作
王五：我正在工作
李四：我正在工作
王五：我正在工作
李四：我正在工作
李四：我正在工作
王五：我正在工作
李四：我正在工作
王五：我正在工作
王五：我正在工作
李四：我正在工作
王五：我的工作结束了
李四：我的工作结束了
 */
/*
让李四先开始工作      ================加上join()方法后结果
李四：我正在工作
李四：我正在工作
李四：我正在工作
李四：我正在工作
李四：我正在工作
李四：我正在工作
李四：我的工作结束了
李四工作结束了，让王五开始工作
王五：我正在工作
王五：我正在工作
王五：我正在工作
王五：我正在工作
王五：我正在工作
王五：我正在工作
王五：我的工作结束了
王五工作结束
 */
public class UseJoin {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for(int i=0;i<6;i++){
                try{
                    System.out.println(Thread.currentThread().getName()+"：我正在工作");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"：我的工作结束了");
        };

        Thread t1=new Thread(runnable,"李四");
        Thread t2=new Thread(runnable,"王五");
        System.out.println("让李四先开始工作");
        t1.start();
        t1.join();
        System.out.println("李四工作结束了，让王五开始工作");
        t2.start();
        t2.join();
        System.out.println("王五工作结束");
    }
}
