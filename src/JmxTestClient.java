import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JmxTestClient {

  public static void main(String[] args) throws Exception {

    JMXServiceURL url =
        new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + args[0] + ":" + args[1] + "/jmxrmi");

    JMXConnector jmxConnector = JMXConnectorFactory.connect(url);

    MBeanServerConnection mbeanServerConnection = jmxConnector.getMBeanServerConnection();

    // TODO Auto-generated method stub
    ObjectName name = new ObjectName("test_jmx:name=TestJMX");

    TestJMXBean mbeanProxy = (TestJMXBean) MBeanServerInvocationHandler
        .newProxyInstance(mbeanServerConnection, name, TestJMXBean.class, true);

    System.out.println(mbeanProxy.getMessage());

  }

}
