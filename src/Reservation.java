import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {

    private Group group;
    private LocalDateTime dateTime;
    private static final LocalTime minReservationTime = LocalTime.of(8,0);
    private static final LocalTime maxReservationTime = LocalTime.of(17,0);
    public Reservation(Group group, LocalTime time, LocalDate date) {

        this.group = group;
        this.dateTime = LocalDateTime.of(date, time);

    }
    public static boolean isValidTime(LocalTime reservationStartTime, int reservationLength) {
        if(reservationStartTime.isBefore(minReservationTime)){
            return false;
        }
        if(reservationStartTime.plusMinutes(reservationLength).isAfter(maxReservationTime)) {
            return false;
        }
        return true;
    }

    public static boolean isValidDate(LocalDate date) {
        return !date.isAfter(LocalDate.now().plusDays(7));
    }


}
