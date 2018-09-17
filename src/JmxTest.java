
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;


public class JmxTest implements TestJMXBean {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    
    JmxTest test = new JmxTest();
    
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    ObjectName name = new ObjectName("test_jmx:name=TestJMX");

    server.registerMBean(test, name);

    while (true) {
      Thread.sleep(1000);
    }
  }

  public String getMessage() {
    return "test jmx";
  }

  @Override
  public void setMessage(String message) {
    // TODO Auto-generated method stub

  }

}

