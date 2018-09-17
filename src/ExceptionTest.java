import java.io.IOException;

/**
 * Created by wchevreuil on 16/10/2017.
 */
public class ExceptionTest {

  public static void main(String[] args){

    ExceptionTest test = new ExceptionTest();

    try{
      test.method3();
    } catch(IOException e){
      e.printStackTrace();
    }

  }

  public void method1() throws IOException{
    throw new IOException("this came from method1");
  }

  public void method2(){
    try {
      method1();
    } catch (IOException e) {
      RuntimeException wrapper = new RuntimeException();
      wrapper.addSuppressed(e);
      throw wrapper;
    }
  }

  public void method3() throws  IOException{
    try{
      method2();
    } catch(RuntimeException e){
      throw (IOException) e.getSuppressed()[0];
    }
  }



}
