package main.com.project.smartofficefacility.config;




import main.com.project.smartofficefacility.models.Room;
import java.util.HashMap;
import java.util.Map;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private Map<Integer, Room> rooms;

    private OfficeConfiguration() {
        rooms = new HashMap<>();
    }

    public static synchronized OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRoom(int roomNumber, int capacity) {
        rooms.put(roomNumber, new Room(roomNumber, capacity));
    }

    public void bookRoom(int roomNumber, String startTime, int duration) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            room.book(startTime, duration);
        }
    }

    public boolean cancelBooking(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            room.cancelBooking();
        }
        return false;
    }

    public boolean addOccupants(int roomNumber, int occupants) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            boolean occupant =room.addOccupants(occupants);
            if (occupant) {
                return true;
            }
        }
        return false;
    }

    public String checkRoomStatus(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            room.checkStatus();
        }

        return null;
    }
}
