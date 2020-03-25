package task1.ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HappyTicketService {

  public List<Ticket> getAllHappyTickets() {

    return Stream.iterate(0, n -> n + 1)
        .limit(1000000)
        .map(this::createTicket)
        .filter(this::isHappy)
        .collect(Collectors.toList());
  }

  private boolean moscowHappyTicket(Ticket ticket) {

    int[] number = ticket.getTicketNumber();

    return number[0] + number[1] + number[2] == number[3] + number[4] + number[5];
  }

  private boolean spbHappyTicket(Ticket ticket) {

    int[] number = ticket.getTicketNumber();

    return number[0] + number[2] + number[4] == number[1] + number[3] + number[5];
  }

  private boolean isHappy(Ticket ticket) {
    return moscowHappyTicket(ticket) && spbHappyTicket(ticket);
  }

  private Ticket createTicket(int number) {

    int[] result = new int[6];

    for (int i = 5; i >= 0; i--) {

      result[i] = number % 10;
      number /= 10;
      if (number == 0) {
        break;
      }
    }

    return new Ticket(result);
  }
}
