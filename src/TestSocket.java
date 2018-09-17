import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class TestSocket {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    ServerSocketChannel channel = ServerSocketChannel.open();

    // Bind the server socket to the local host and port
    // channel.socket().setReuseAddress(getReuseAddress());
    InetSocketAddress addr = new InetSocketAddress("localhost", 9010);
    channel.socket().bind(addr);

    channel.open();

    System.out.println("finished!");

    // Set to non blocking mode
    // _acceptChannel.configureBlocking(false);
  }

}
