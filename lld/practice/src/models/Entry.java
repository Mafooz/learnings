package models;

import java.util.List;

public class Entry {
    TicketController ticketController;
    ParkingLevel parkingLevel;

    public Entry(TicketController ticketController, ParkingLevel parkingLevel) {
        this.ticketController = ticketController;
        this.parkingLevel = parkingLevel;
    }
    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot parkingSpot = this.parkingLevel.getAnEmptySpot(vehicle.getVehicleType());
        if (parkingSpot!=null) {
            Ticket ticket = new Ticket(vehicle, parkingSpot);
            ticketController.addTicket(ticket);
            parkingSpot.setOccupied(true);
            return ticket;
        }
        System.out.println("No space found!!!");
        return null;
    }
}
