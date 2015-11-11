import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MinCommNodeTest {

  @Test
  public void basicTest() {
    List<String> relations = new ArrayList<>();
    relations.add("a b");
    assertThat(MinCommNode.mcn("a", "b", relations), is("a"));
  }

  @Test
  public void basicTest2() {
    List<String> relations = new ArrayList<>();
    relations.add("b a");
    assertThat(MinCommNode.mcn("a", "b", relations), is("b"));
  }

  @Test
  public void test3() {
    List<String> relations = new ArrayList<>();
    relations.add("c a");
    relations.add("c b");
    assertThat(MinCommNode.mcn("a", "b", relations), is("c"));
  }

  @Test
  public void test4() {
    List<String> relations = new ArrayList<>();
    relations.add("c d");
    relations.add("d b");
    relations.add("c a");
    assertThat(MinCommNode.mcn("a", "b", relations), is("c"));
  }
}