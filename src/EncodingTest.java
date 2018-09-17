import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by wchevreuil on 17/04/2018.
 */
public class EncodingTest {

  public static void main(String[] args) throws Exception {
//    Charset charset = Charset.defaultCharset();
//    System.out.println("Default encoding: " + charset + " (Aliases: "
//        + charset.aliases() + ")");
//
//    Map<String, Charset> charsets = Charset.availableCharsets();
//
//    byte[] test = "test\u00FC.txt".getBytes();
////    for(String key : charsets.keySet()){
////      System.out.println(key + " - " + charsets.get(key) + ", " + charsets.get(key).aliases());
////      String decoded = new String(test,charsets.get(key));
//    String decoded = new String(test,charset);
//      System.out.println(decoded);
//      System.out.println("test\303\274.txt");
//      decoded = new String("test\303\274.txt".getBytes(),charset);
//      System.out.println(decoded);
//      System.out.println(">>>>>>>>");

//    }
//
//    char ch = '\u00FC';
//    String ss=Integer.toHexString(ch);
//    System.out.println(ss);
//    System.out.println(ch);
//
//    StringBuffer sb = new StringBuffer();
//    sb.append(ch);
//    System.out.println(sb);
//
//    System.out.println("test\303\274.txt");

    URL url = new URL(args[0]);

    HttpURLConnection connection = (HttpURLConnection)url.openConnection();

    connection.setRequestMethod(args.length>1?args[1]:"GET");

    InputStreamReader is = new InputStreamReader(connection.getInputStream());

    System.out.println("---->Stream encoding: " + is.getEncoding());

    BufferedReader reader = new BufferedReader(is);

    String line = null;

    while( (line = reader.readLine()) != null) {

      if(line.contains("testü"))
        System.out.println(line);

    }

  }

}
