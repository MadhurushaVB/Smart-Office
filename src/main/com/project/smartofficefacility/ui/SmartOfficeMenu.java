package main.com.project.smartofficefacility.ui;


//import java.util.Scanner;
//
//public class SmartOfficeMenu {
//    private OfficeConfiguration office;
//    private Scanner scanner;
//
//    public SmartOfficeMenu(OfficeConfiguration office, Scanner scanner) {
//        this.office = office;
//        this.scanner = scanner;
//    }
//
//    public void displayMenu() {
//        boolean exit = false;
//        while (!exit) {
//            System.out.println("\nPlease choose an option:");
//            System.out.println("1. Book a room");
//            System.out.println("2. Cancel a booking");
//            System.out.println("3. Add occupants to a room");
//            System.out.println("4. Check room status");
//            System.out.println("5. Exit");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            switch (choice) {
//                case 1:
//                    bookRoom();
//                    break;
//                case 2:
//                    cancelBooking();
//                    break;
//                case 3:
//                    addOccupants();
//                    break;
//                case 4:
//                    checkRoomStatus();
//                    break;
//                case 5:
//                    exit = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private void bookRoom() {
//        System.out.print("Enter room number to book: ");
//        int roomNumber = scanner.nextInt();
//        System.out.print("Enter booking start time (HH:mm): ");
//        String startTime = scanner.next();
//        System.out.print("Enter booking duration in minutes: ");
//        int duration = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        Command bookCommand = new BookRoomCommand(office, roomNumber, startTime, duration);
//        bookCommand.execute();
//    }
//
//    private void cancelBooking() {
//        System.out.print("Enter room number to cancel booking: ");
//        int roomNumber = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        Command cancelCommand = new CancelBookingCommand(office, roomNumber);
//        cancelCommand.execute();
//    }
//
//    private void addOccupants() {
//        System.out.print("Enter room number to add occupants: ");
//        int roomNumber = scanner.nextInt();
//        System.out.print("Enter number of occupants: ");
//        int occupants = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        office.addOccupants(roomNumber, occupants);
//    }
//
//    private void checkRoomStatus() {
//        System.out.print("Enter room number to check status: ");
//        int roomNumber = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        office.checkRoomStatus(roomNumber);
//    }
//}



import main.com.project.smartofficefacility.commands.*;
import main.com.project.smartofficefacility.config.OfficeConfiguration;

import java.util.Scanner;

public class SmartOfficeMenu {
    private final OfficeConfiguration office;
    private final Scanner scanner;

    public SmartOfficeMenu(OfficeConfiguration office, Scanner scanner) {
        this.office = office;
        this.scanner = scanner;
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Smart Office Menu ---");
            System.out.println("1. Configure Room");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Add Occupants");
            System.out.println("5. Check Room Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    configureRoom();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    addOccupants();
                    break;
                case 5:
                    checkRoomStatus();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void configureRoom() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter maximum capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        office.configureRoom(roomNumber, capacity);
        System.out.println("Room " + roomNumber + " configured with maximum capacity of " + capacity + ".");
    }

    private void bookRoom() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Command bookRoomCommand = new BookRoomCommand(office, roomNumber, startTime, duration);
        bookRoomCommand.execute();
    }

    private void cancelBooking() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Command cancelBookingCommand = new CancelBookingCommand(office, roomNumber);
        cancelBookingCommand.execute();
    }

    private void addOccupants() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter number of occupants: ");
        int occupants = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Command addOccupantsCommand = new AddOccupantCommand(office, roomNumber, occupants);
        addOccupantsCommand.execute();
    }

    private void checkRoomStatus() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Command checkRoomStatusCommand = new CheckRoomStatusCommand(office, roomNumber);
        checkRoomStatusCommand.execute();
    }
}
