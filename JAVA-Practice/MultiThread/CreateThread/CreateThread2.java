public class CreateThread2 {
    private static class MyThread extends Thread{
        private int n=0;

        @Override
        public void run() {
            while(n<10){
                System.out.println(n);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n++;
            }
        }
    }

    private static class ShareResource{
        private static int n;
    }
    private static class MyThread2 extends Thread{
        ShareResource resource;

        public MyThread2(ShareResource resource){
            this.resource=resource;
        }

        @Override
        public void run() {
            while(resource.n<10){
                System.out.println(resource.n);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.n++;
            }
        }
    }

    public static void main(String[] args) {
        /*
        Thread t1=new Thread();  无结果
        Thread t2=new Thread();
        */

        //没有共享
        /*
        Thread t1=new MyThread();  0 0 1 1 2 2...9 9
        Thread t2=new MyThread();
        */
        /*
        Thread t1=new Thread(new MyThread());   0 0 1 1 2 2...9 9
        Thread t2=new Thread(new MyThread());
        */


        //共享
        /*
        MyThread t=new MyThread();  0 0 1 2 3 4 5 6 7 8 9
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        */
        ShareResource resource=new ShareResource(); //0 0 1 1 2 3 4 5 6 7 8 9
        Thread t1=new MyThread2(resource);
        Thread t2=new MyThread2(resource);
        t1.start();
        t2.start();
    }
}
