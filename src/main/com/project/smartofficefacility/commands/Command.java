package main.com.project.smartofficefacility.commands;


public interface Command {
    void execute();
}

public class BookRoomCommand implements Command {
    private OfficeConfiguration office;
    private int roomNumber;
    private String startTime;
    private int duration;

    public BookRoomCommand(OfficeConfiguration office, int roomNumber, String startTime, int duration) {
        this.office = office;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        office.bookRoom(roomNumber, startTime, duration);
    }
}

public class CancelBookingCommand implements Command {
    private OfficeConfiguration office;
    private int roomNumber;

    public CancelBookingCommand(OfficeConfiguration office, int roomNumber) {
        this.office = office;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        office.cancelBooking(roomNumber);
    }
}

// Additional commands like AddOccupantsCommand and CheckRoomStatusCommand can be created similarly.

