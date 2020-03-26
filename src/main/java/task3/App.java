package task3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class App {

  public static void main(String[] args) {

    Integer[] array = {1, 3, -1, 5, 2, 6, 7, 8, 3, 4, 4, 0, 11};
    System.out.println(findPairs(10, array));
  }

  static Map<Integer, Integer> findPairs(Integer target, Integer... array) {

    Map<Integer, Integer> pairs = new ConcurrentHashMap<>();

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i != j) {
          if (array[i] + array[j] == target) {
            pairs.put(array[i], array[j]);
          }
        }
      }
    }

    for (Integer key : pairs.keySet()) {
      if (pairs.containsKey(pairs.get(key))) {
        pairs.remove(key);
      }
    }

    return pairs;
  }
}
