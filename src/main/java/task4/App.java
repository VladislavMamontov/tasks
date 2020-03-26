package task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    TrafficLight trafficLight = new TrafficLight();
    Thread thread = new Thread(trafficLight);
    thread.setDaemon(true);
    thread.start();

    while (true) {
      System.out.println("commands:\n1 - push button; 2 - check current status; 3 - switch working mode; 4 - end;\n");
      String command = reader.readLine();
      switch (command) {
        case "1":
          trafficLight.pushButton();
          break;
        case "2":
          trafficLight.getCurrentStatus();
          break;
        case "3":
          trafficLight.switchMode();
          break;
        case "4":
          return;
        default:
          System.out.println("wrong command");
          break;
      }
    }
  }
}
