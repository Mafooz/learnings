package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketController {

    private Map<String, Ticket> ticketList;
    public TicketController() {
        ticketList = new HashMap<>();
    }

    public void addTicket(Ticket ticket) {
        ticketList.put(ticket.getId(), ticket);
    }
}
