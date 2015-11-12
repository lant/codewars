import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxReps {

  public String getMaxReps(List<String> input) {
    // expected size of 'count', this should be the upper limit.
    Map<String, IncLong> data = new HashMap<>(input.size());

    String common = null;

    for (String s : input) {
      if (common == null) {
        common = s;
      }

      if (!data.containsKey(s)) {
        data.put(s, new IncLong());
      }

      long currentOcc = data.get(s).increment();

      if (currentOcc > data.get(common).get()) {
        common = s;
      }
    }

    return common;

  }

  static class IncLong {
    private long occurrence = 1L;

    public long increment() {
      return ++this.occurrence;
    }

    public long get() {
      return occurrence;
    }

  }

}
