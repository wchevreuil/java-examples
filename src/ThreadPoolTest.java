import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wchevreuil on 02/08/2017.
 */
public class ThreadPoolTest {

  public static void main(String[] args) throws InterruptedException {

    ExecutorService service = new ThreadPoolExecutor(1,1,60*60*1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());

    Runnable run1 = new TestRunnable("t1");

    Runnable run2 = new TestRunnable("t2");

    service.execute(run1);

    Thread.sleep(2*60*1000);

    System.out.println("Gonna send second thread to the pool....");

    service.execute(run2);

  }

  private static class TestRunnable implements Runnable, Comparable {

    String name;
    TestRunnable(String name){
      this.name = name;
    }

    @Override
    public void run()  {
      System.out.println("I'm thread " + name + " and am going to sleep for 5 mins");

      try {
        Thread.sleep(10*1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    @Override
    public int compareTo(Object o) {
      return ((TestRunnable)o).name.compareTo(this.name);
    }
  }
}
