package main.com.project.smartofficefacility.commands;



import main.com.project.smartofficefacility.config.OfficeConfiguration;

public class CheckRoomStatusCommand implements Command {
    private final OfficeConfiguration office;
    private final int roomNumber;

    public CheckRoomStatusCommand(OfficeConfiguration office, int roomNumber) {
        this.office = office;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        String status = office.checkRoomStatus(roomNumber);
        System.out.println(status);
    }
}
