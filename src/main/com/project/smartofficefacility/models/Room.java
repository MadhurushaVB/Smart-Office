package main.com.project.smartofficefacility.models;


public class Room {
    private int roomNumber;
    private int capacity;
    private int occupants;
    private boolean booked;
    private String startTime;
    private int duration;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.occupants = 0;
        this.booked = false;
    }

    public void book(String startTime, int duration) {
        if (!booked) {
            this.booked = true;
            this.startTime = startTime;
            this.duration = duration;
            System.out.println("Room " + roomNumber + " booked from " + startTime + " for " + duration + " minutes.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void cancelBooking() {
        if (booked) {
            booked = false;
            System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    public boolean addOccupants(int occupants) {
        if (occupants >= 0 && occupants <= capacity) {
            this.occupants = occupants;
            if (occupants >= 2) {
                System.out.println("Room " + roomNumber + " is now occupied by " + occupants + " persons. AC and lights turned on.");
                return true;
            } else {
                System.out.println("Room " + roomNumber + " occupancy insufficient to mark as occupied.");
                return false;
            }
        } else {
            System.out.println("Invalid number of occupants. Please enter a valid number.");
            return false;
        }

    }

    public void checkStatus() {
        if (occupants >= 2) {
            System.out.println("Room " + roomNumber + " is currently occupied.");
        } else {
            System.out.println("Room " + roomNumber + " is currently unoccupied.");
        }
    }
}
