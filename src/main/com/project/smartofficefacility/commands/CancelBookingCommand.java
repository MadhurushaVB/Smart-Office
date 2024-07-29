package main.com.project.smartofficefacility.commands;



import main.com.project.smartofficefacility.config.OfficeConfiguration;

public class CancelBookingCommand implements Command {
    private final OfficeConfiguration office;
    private final int roomNumber;

    public CancelBookingCommand(OfficeConfiguration office, int roomNumber) {
        this.office = office;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        boolean success = office.cancelBooking(roomNumber);
        if (success) {
            System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked. Cannot cancel booking.");
        }
    }
}
