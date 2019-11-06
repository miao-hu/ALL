import java.util.Scanner;

class FibonacciThread2 extends Thread{
    private int n;

    FibonacciThread2(int n){
        this.n=n;
    }
    @Override
    public void run() {
        long result=Fibonacci.calc(n);
        System.out.printf("fib(%d)=%d%n",n,result);
    }
}

public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("请输入要计算第几项的斐波那契数:");
            int n=scanner.nextInt();
            Thread t=new FibonacciThread2(n);
            System.out.println("正在计算中");
            t.start();
            while(t.isAlive()){
                Thread.sleep(1000);
                System.out.print(".");
            }
        }
    }
}
