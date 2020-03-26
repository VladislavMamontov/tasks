package task4;

public class TrafficLight implements Runnable {

  private Light currentLight = Light.GREEN;
  private boolean serviceMode = false;
  private boolean isButtonPushed = false;

  @Override
  public void run() {

    if (serviceMode) {
      service();
    }

    greenLight();
  }

  private void greenLight() {

    currentLight = Light.GREEN;
    System.out.println("The green light turned on");

    while (!isButtonPushed && !serviceMode) {
      try {
        Thread.sleep(30000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    isButtonPushed = false;
    if (serviceMode) {
      service();
    }
    else {
      yellowLight(Light.GREEN);
    }
  }

  private void yellowLight(Light lastLight) {

    currentLight = Light.YELLOW;
    System.out.println("The yellow light turned on");

    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (serviceMode) {
      service();
    }
    else {
      if (lastLight == Light.GREEN) {
        redLight();
      }
      else {
        greenLight();
      }
    }
  }

  private void redLight() {

    currentLight = Light.RED;
    System.out.println("The red light turned on");

    try {
      Thread.sleep(15000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (serviceMode) {
      service();
    }
    else {
      yellowLight(Light.RED);
    }
  }

  private void service() {

    System.out.println("service mode turn on");

    while (serviceMode) {
      try {
        Thread.sleep(500);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    serviceMode = false;
    System.out.println("service mode turn off");
    greenLight();
  }

  public void pushButton() {

    isButtonPushed = true;
    System.out.println("button is pushed");
  }


  public void getCurrentStatus() {
    System.out.println("current light - " + currentLight + ", service mode - " +
        serviceMode + ", is button pushed - " + isButtonPushed);
  }

  public void switchMode() {

    serviceMode = !serviceMode;
    System.out.println("service mode - " + serviceMode);
  }
}
