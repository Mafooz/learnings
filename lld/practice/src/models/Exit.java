package models;

import java.util.Date;

public class Exit {

    TicketController ticketController;
    ParkingLevel parkingLevel;

    public Exit(TicketController ticketController, ParkingLevel parkingLevel) {
        this.ticketController = ticketController;
        this.parkingLevel = parkingLevel;
    }

    public float generateBill(Ticket ticket) {
        if (!ticket.isValid()) {
            System.out.println("Ticket is already checked out!!!");
            return -1;
        }
        ticket.setValid(false);
        Date date = ticket.getGeneratedTime();
        ticket.getParkingSpot().setOccupied(false);
        ticket.setExitTime(new Date());
        return getTotalValue(date, ticket.getExitTime());
    }
    public float getTotalValue(Date prevDate, Date currDate) {
        return (float) (currDate.getTime() - prevDate.getTime())/100;
    }
}
