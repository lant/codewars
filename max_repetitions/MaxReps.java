import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MaxReps {

  public String getMaxReps(List<String> input) {
    // expected size of 'count', this should be the upper limit.
    Map<String, Data> data = new HashMap<>(input.size());

    for (String s : input) {
      if (!data.containsKey(s)) {
        data.put(s, new Data(s));
      }
      data.get(s).incrementOcurrence();
    }

    TreeSet<Data> result = new TreeSet<>(data.values());
    return result.first().getString();
  }

  static class Data implements Comparable<Data> {
    String data;
    long occurrence;

    public Data(String data) {
      this.data = data;
      this.occurrence = 0L;
    }

    public void incrementOcurrence() {
      this.occurrence++;
    }

    public String getString() {
      return this.data;
    }

    public long getOccurrence() {
      return occurrence;
    }

    @Override
    public int compareTo(Data o) {
      assert (o != null);
      return Long.compare(o.getOccurrence(), this.occurrence);
    }
  }

}
