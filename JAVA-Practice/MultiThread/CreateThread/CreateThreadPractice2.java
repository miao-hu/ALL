public class CreateThreadPractice2 {
    private interface F{
        int f(int n);  //抽象方法：返回n值
    }

    private static class F1 implements F{

        @Override
        public int f(int n) {
            return n;
        }
    }

    private static class Calculator{
        private long calc(int n,F f) {
            long sum = 0;
            for (int i = 1; i <=n;i++){
                sum+=f.f(i);
            }
            return sum;
        }
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            Calculator calculator=new Calculator();
            long sum=calculator.calc(10_0000,new F1());
            System.out.println("和为"+sum);
        }
    }

    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();
    }
}








