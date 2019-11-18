public class OneTwoThree5 {
    private static class Foo {
        private volatile int n = 1;  //保证了可见性

        // 条件不满足，让出 CPU的占有权,并且进入该对象的等待集
        // 不再参加 CPU 的争夺
        public void oneMethod() throws InterruptedException {
            if (n != 1) {
                synchronized (this) {
                    this.wait();
                }
                return;
            }
            System.out.println("one");
            n = 2;
            synchronized (this) {
                this.notifyAll();
            }
        }

        public void twoMethod() throws InterruptedException {
            if (n != 2) {
                synchronized (this) {
                    this.wait();
                }
                return;
            }
            System.out.println("two");
            n = 3;
            synchronized (this) {
                this.notifyAll();
            }
        }

        public void threeMethod() throws InterruptedException {
            if (n != 3) {
                synchronized (this) {
                    this.wait();
                }
                return;
            }
            System.out.println("three");
            n = 1;
            synchronized (this) {
                this.notifyAll();
            }
        }

        private static Foo foo = new Foo();

        private static class oneThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    try {
                        foo.oneMethod();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static class twoThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    try {
                        foo.twoMethod();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static class threeThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    try {
                        foo.threeMethod();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[] args) {
            Thread t1 = new oneThread();
            Thread t2 = new twoThread();
            Thread t3 = new threeThread();
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
