import java.util.*;

public class MinCommNode {

  static String mcn(String targetNode1, String targetNode2, List<String> input) {
    Set<String> commonParents = new HashSet<>();
    Map<String, Relation> relations = new HashMap<>();

    for (String relation : input) {
      String[] parts = relation.split(" ");
      relations.put(parts[1], new Relation(parts[1], parts[0]));
    }

    // check easy case.
    if (relations.containsKey(targetNode1) && relations.get(targetNode1).getFather().equals(targetNode2)) {
      return targetNode2;
    } else if (relations.containsKey(targetNode2) && relations.get(targetNode2).getFather().equals(targetNode1)) {
      return targetNode1;
    } else {
      // first check all the targetNode1 bosses.
      String currentNode = targetNode1;
      while(relations.containsKey(currentNode)) {
        commonParents.add(relations.get(currentNode).getFather());
        currentNode = relations.get(currentNode).getFather();
      }

      // now iterate over the second employee bosses.
      currentNode = targetNode2;
      while(relations.containsKey(currentNode)) {
        if (commonParents.contains(relations.get(currentNode).getFather())) {
          // this is the first common father.
          return relations.get(currentNode).getFather();
        } else {
          commonParents.add(relations.get(currentNode).getFather());
          currentNode = relations.get(currentNode).getFather();
        }
      }
      return null;
    }
  }

  static class Relation {
    String nodeId;
    String father;

    public Relation(String nodeId, String father) {
      this.nodeId = nodeId;
      this.father = father;
    }

    public String getFather() {
      return this.father;
    }
  }
}
