import java.util.ArrayList;
import java.util.List;

public class TestAssert {

  public static void main(String[] args) {

    assert 1 == 1;

    System.out.println("assert true");

    assert 1 == 2;

    System.out.println("assert false");

    List<String> list = new ArrayList<String>();

    list.add(null);
  }

}
