import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class Room {
    public static List<Room> allRooms = new ArrayList<>();

    private List<Reservation> reservations = new ArrayList<>();
    private String roomName;

    public Room(String name) {
       this.roomName = name;
       allRooms.add(this);
    }

    public static Room findRoomByName(String roomName)
    {
        for(Room room : allRooms) {
            if(room.roomName.equals(roomName)) return room;
        }
        return null;
    }

    public void reserveRoom(Reservation reservation) {

    }


}
