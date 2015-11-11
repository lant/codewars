import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxRepsTest {

  @Test
  public void basicTest() {
    MaxReps m = new MaxReps();
    List<String> data = new ArrayList<String>(6);
    data.add("a");
    data.add("a");
    data.add("b");
    data.add("b");
    data.add("a");
    data.add("c");
    assertThat("a", is(m.getMaxReps(data)));
  }

}