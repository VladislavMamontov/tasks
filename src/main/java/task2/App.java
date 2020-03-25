package task2;

public class App {

  public static void main(String[] args) {
    int[] coins = {50, 50, 50, 20, 20, 10, 10};
    System.out.println(combine(0, coins, 70, 80));
  }

  static int combine(int index, int[] coins, int target1, int target2) {

    if (target1 == 0 && target2 == 0) {
      return 1;
    }

    if (index >= coins.length) {
      return 0;
    }

    if (target1 < 0 || target2 < 0) {
      return 0;
    }

    return combine(index + 1, coins, target1, target2) +
        combine(index + 1, coins, target1 - coins[index], target2) +
        combine(index + 1, coins, target1, target2 - coins[index]);
  }
}




