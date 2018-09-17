/**
 * Created by wchevreuil on 05/12/2017.
 */
public abstract class TestBuilder {

  int attr;

  abstract void method1();

  public TestBuilder build() {
    return new TestBuilder() {
      @Override
      void method1() {

      }
    };
  }


}
