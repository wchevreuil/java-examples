import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AuditParser {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    File f = new File(
        "/Users/wchevreuil/Downloads/audits/manager03/hdfs-NAMENODE-fadc398fb4242efd163b0497ce90b946-HdfsAuditLogger-1481902083300");

    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

    String line = reader.readLine();

    while (line != null) {
      if (line.indexOf("AdBlocker") >= 0) {
        // long time = Long.parseLong(line.split("eventTime\":")[1].split(",")[0]);
        // if (time > 1482885240000L && time < 1483315200000L) {
        //
        // System.out.println(line);
        //
        // }
        System.out.println(line);
      }

      // System.out.println(line);
    }

    reader.close();
  }



}
