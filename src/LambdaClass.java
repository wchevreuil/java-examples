import java.io.IOException;

/**
 * Created by wchevreuil on 26/10/2017.
 */
public class LambdaClass {

  public static void main(String[] args) throws Exception {

      LambdaClass myClass = new LambdaClass();

      myClass.myMethod("hi", "there", (x,y) -> myClass.test1( "hi", "there"));
      myClass.myMethod("hi", "there", (x,y) -> myClass.test2( "hi", "there"));
  }

  public void test1(String arg1, String arg2){
    System.out.println(arg1 + " -> " + arg2);
  }

  public void test2(String arg1, String arg2){
    System.out.println(arg1 + " <- " + arg2);
  }

  public void myMethod(String word1, String word2, Consumer<String,String> targetMethod) throws IOException {
    targetMethod.accept(word1,word2);
  }

  @FunctionalInterface
  interface Consumer<Arg1,Arg2>{
    public void accept(Arg1 arg1, Arg2 arg2) throws IOException;
  }

}
