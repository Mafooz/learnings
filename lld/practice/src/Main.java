import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<VehicleType> parkingSpotList = new ArrayList<>();
        for(int i=0;i<3;i++) {
            parkingSpotList.add(VehicleType.WHEELER_2);
        }
        for(int i=0;i<3;i++) {
            parkingSpotList.add(VehicleType.WHEELER_4);
        }

        ParkingLevel parkingLevel = new ParkingLevel(parkingSpotList);
        TicketController ticketController = new TicketController();
        Entry entry = new Entry(ticketController, parkingLevel);
        Exit exit = new Exit(ticketController, parkingLevel);
        Vehicle vehicle1 = new Vehicle(VehicleType.WHEELER_2);
        Vehicle vehicle2 = new Vehicle(VehicleType.WHEELER_2);
        Vehicle vehicle3 = new Vehicle(VehicleType.WHEELER_2);
        Vehicle vehicle4 = new Vehicle(VehicleType.WHEELER_4);
        Vehicle vehicle5 = new Vehicle(VehicleType.WHEELER_4);
        Vehicle vehicle6 = new Vehicle(VehicleType.WHEELER_4);
        Vehicle vehicle7 = new Vehicle(VehicleType.WHEELER_2);
        Ticket ticket1 = entry.generateTicket(vehicle1);
        Ticket ticket2 = entry.generateTicket(vehicle2);
        Ticket ticket3 = entry.generateTicket(vehicle3);
        Ticket ticket4 = entry.generateTicket(vehicle4);
        Ticket ticket5 = entry.generateTicket(vehicle5);
        Ticket ticket6 = entry.generateTicket(vehicle6);
        Ticket ticket7 = entry.generateTicket(vehicle7);
        exit.generateBill(ticket1);
        printTicket(ticket1);
        printTicket(ticket2);
        printTicket(ticket3);
        printTicket(ticket4);
        printTicket(ticket5);
        printTicket(ticket6);
        printTicket(ticket7);
        Thread.sleep(10000);
        if (ticket1!=null) {
            System.out.println(exit.generateBill(ticket1));
        }
        printTicket(ticket1);

    }

    public static void printTicket(Ticket ticket) {
        if (ticket==null) {
            System.out.println("Null ticket!!!");
            return ;
        }
        System.out.println("Ticket id: " + ticket.getId() + " Parking Spot occupied " + ticket.getParkingSpot().isOccupied() + " isValid " + ticket.isValid() + " generated Time " + ticket.getGeneratedTime().toString() + " exit Time " + ticket.getExitTime());
    }
}
