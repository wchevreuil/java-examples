import java.io.*;

/**
 * Created by wchevreuil on 18/10/2017.
 */
public class FSIMageHeaderInserter {

  public static void main (String[] args) throws Exception {

    String filePath = args[0];

    byte[] magicHeader = "HDFSIMG1".getBytes();

    File newFile = new File("./new_image_" + System.currentTimeMillis());

    InputStream is = new FileInputStream(filePath);

    OutputStream os = new FileOutputStream(newFile);

    os.write(magicHeader);

    byte[] buffer = new byte[8];

    while(is.read(buffer)>=0){
      os.write(buffer);
    }

    os.flush();
    os.close();
    is.close();



  }
}
