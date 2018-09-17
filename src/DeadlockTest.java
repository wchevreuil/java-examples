import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wchevreuil on 11/10/2017.
 */
public class DeadlockTest {

  public static Object lock1 = new Object();

  public static Object lock2 = new Object();

  public static void main(String[] args) throws Exception {

    ThreadPoolExecutor pool =  new ThreadPoolExecutor(2, 2, 60,
        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory(){

      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r);
      }
    });
    Long startTime = System.currentTimeMillis();
    pool.submit(new Runnable(){
       public void run(){
         synchronized(lock1){
           System.out.println(System.currentTimeMillis());
           System.out.println(Thread.currentThread().toString() + " got lock1, now is going to sleep for 5 secs, then try to get lock2");
           try {
             Thread.sleep(5000);
           } catch (InterruptedException e) {
             e.printStackTrace();
           }
           System.out.println(System.currentTimeMillis());
           System.out.println(Thread.currentThread().toString() + " finished sleeping, still has lock1, and is going to try get lock2");
           synchronized(lock2){
             System.out.println(System.currentTimeMillis());
             System.out.println(Thread.currentThread().toString() + "got lock2");
           }
         }
       }
    });

    pool.submit(new Runnable(){
      public void run(){
        synchronized(lock2){
          System.out.println(System.currentTimeMillis());
          System.out.println(Thread.currentThread().toString() + " got the lock2, now is going to sleep for 5 secs, then try to get lock1");
          try {
            Thread.sleep(120000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(System.currentTimeMillis());
          System.out.println(Thread.currentThread().toString() + " finished sleeping, still has lock2, and is going to try get lock1");
          synchronized(lock1){
            System.out.println(System.currentTimeMillis());
            System.out.println(Thread.currentThread().toString() + "got lock1");
          }
        }

      }
    });

    pool.awaitTermination(100, TimeUnit.SECONDS);
    System.out.println("elapsed time: " + (System.currentTimeMillis() - startTime));

  }
}
