package main.com.project.smartofficefacility.commands;



import main.com.project.smartofficefacility.config.OfficeConfiguration;

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

