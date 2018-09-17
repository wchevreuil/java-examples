import java.io.*;

/**
 * Created by wchevreuil on 08/05/2018.
 */
public class KVsIntersection {

  public static void main(String[] args) throws Exception {

    File file1 = new File(args[0]);
    File file2 = new File(args[1]);

    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));

    String line = reader.readLine();

    StringBuffer source = new StringBuffer();

    while (line != null) {

      source.append(line);

      line = reader.readLine();

    }

    reader.close();

    reader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));

    StringBuffer target = new StringBuffer();

    line = reader.readLine();

    while (line != null) {

      target.append(line);

      line = reader.readLine();

    }

    String targetKVs = target.toString();

    int sourceSize = 0;

    for(String kv : source.toString().split(",")){

         if(targetKVs.indexOf(kv)<0) {

          System.out.println(kv);

         }

         String kvSize = kv.split("vlen=")[1].split("/")[0];

         sourceSize += Integer.parseInt(kvSize);

    }

    System.out.println(sourceSize);

  }

}
