package task1;

import task1.ticket.HappyTicketService;

public class App {

  public static void main(String[] args) {

    HappyTicketService happyTicketService = new HappyTicketService();
    System.out.println("All happy tickets:");
    happyTicketService.getAllHappyTickets().forEach(System.out::println);
  }
}
