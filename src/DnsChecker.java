import java.net.InetAddress;

/**
 * Created by wchevreuil on 18/04/2018.
 */
public class DnsChecker {

  public static void main(String[] args) throws Exception {
    InetAddress addr = InetAddress.getLocalHost();
    System.out.println( String.format(
        "IP:%s hostname:%s canonicalName:%s",
        addr.getHostAddress(), // The "default" IP address
        addr.getHostName(), // The hostname (from gethostname())
        addr.getCanonicalHostName() // The canonicalized hostname (from resolver)
    ));

  }
}
