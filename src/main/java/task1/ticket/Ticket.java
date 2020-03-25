package task1.ticket;

import java.util.Arrays;

public class Ticket {

  private final int[] ticketNumber;

  public Ticket(int[] ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public int[] getTicketNumber() {
    return ticketNumber;
  }

  @Override
  public String toString() {
    return "ticket number is " + Arrays.toString(ticketNumber);
  }
}
