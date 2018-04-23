 /**
  *假如有三个线程Thread1、Thread2和Thread3都在等待对象objectA的monitor，
  *此时Thread4拥有对象objectA的monitor，当在Thread4中调用objectA.notify()方法之后，
  *Thread1、Thread2和Thread3只有一个能被唤醒。
  *注意，被唤醒不等于立刻就获取了objectA的monitor。
  *假若在Thread4中调用objectA.notifyAll()方法，则Thread1、Thread2和Thread3三个线程都会被唤醒，
  *至于哪个线程接下来能够获取到objectA的monitor就具体依赖于操作系统的调度了。
  *
　*上面尤其要注意一点，一个线程被唤醒不代表立即获取了对象的monitor，
  *只有等调用完notify()或者notifyAll()并退出synchronized块，释放对象锁后，
  *其余线程才可获得锁执行。
  */

  /*
  无论运行多少次，运行结果必定是：

线程Thread-1调用了object.notify()
线程Thread-1释放了锁
线程Thread-0获取到了锁

  */
  
public class Test {
    public static Object object = new Object();
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
         
        thread1.start();
         
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        thread2.start();
    }
     
    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
            }
        }
    }
     
    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
            }
            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
        }
    }
}