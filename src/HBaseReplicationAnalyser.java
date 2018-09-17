import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by wchevreuil on 19/12/2017.
 */
public class HBaseReplicationAnalyser {

  public static void main (String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream("/Users/wchevreuil/Downloads/replication3.out")));

    String line = reader.readLine();

    while(line!=null){

      if(line.contains("SOURCE:")){
        String[] sources = line.split("SOURCE");
        for(String source : sources) {
          if(source.contains("AgeOfLastShippedOp=")) {
            int index = source.indexOf("AgeOfLastShippedOp=") + "AgeOfLastShippedOp=".length();
            int stop = source.indexOf(',', index);
            long ageOfLastShippedOp = Long.parseLong(source.substring(index, stop));
            if (ageOfLastShippedOp > 0) {
              String[] peers = source.split("PeerID=");
              for(String peer : peers) {
                System.out.println("PeerID=" + peer);
              }
            }
          }
        }
      }

      line = reader.readLine();

    }

    reader.close();

  }
}
