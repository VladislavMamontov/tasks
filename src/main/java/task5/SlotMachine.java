package task5;

import java.util.Random;

public class SlotMachine {

  private int[][] numbers = new int[3][3];
  private Random random = new Random();

  public void play() {

    generate();
    print();
    if (check()) {
      System.out.println("You win!");
    }
    else {
      System.out.println("You loose :(");
    }
  }

  private void generate() {

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        numbers[i][j] = random.nextInt(10);
      }
    }
  }

  private void print() {

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        System.out.print(numbers[i][j] + " ");
      }
      System.out.println();
    }
  }

  private boolean check() {

    for (int i = 0; i < numbers.length; i++) {
      int x = numbers[i][0];
      int count = 0;

      for (int j = 0; j < numbers[i].length; j++) {
        if (numbers[i][j] == x) {
          count++;
        }
      }

      if (count == numbers[i].length) {
        return true;
      }
    }

    return false;
  }

}
