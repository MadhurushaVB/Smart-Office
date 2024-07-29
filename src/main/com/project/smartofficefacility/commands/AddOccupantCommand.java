package main.com.project.smartofficefacility.commands;



import main.com.project.smartofficefacility.config.OfficeConfiguration;

public class AddOccupantCommand implements Command {
    private final OfficeConfiguration office;
    private final int roomNumber;
    private final int occupants;

    public AddOccupantCommand(OfficeConfiguration office, int roomNumber, int occupants) {
        this.office = office;
        this.roomNumber = roomNumber;
        this.occupants = occupants;
    }

    @Override
    public void execute() {
        boolean success = office.addOccupants(roomNumber, occupants);
        if (success) {
            if (occupants > 0) {
//                System.out.println("Room " + roomNumber + " is now occupied by " + occupants + " persons. AC and lights turned on.");
            }
            else {
                System.out.println("Room " + roomNumber + " is now unoccupied. AC and lights turned off.");
            }
        } else {
            //System.out.println("Room " + roomNumber + " does not exist or invalid number of occupants.");
        }
    }
}

