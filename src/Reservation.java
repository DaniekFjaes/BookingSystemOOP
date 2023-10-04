import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {

    private Group group;
    private LocalDateTime dateTime;
    private int reservationLengthMinutes;
    private static final LocalTime minReservationTime = LocalTime.of(8,0);
    private static final LocalTime maxReservationTime = LocalTime.of(17,0);
    public Reservation(Group group, LocalTime time, LocalDate date, int reservationLengthMinutes) {

        this.group = group;
        this.dateTime = LocalDateTime.of(date, time);
        this.reservationLengthMinutes = reservationLengthMinutes;

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

    // Requirement: Rooms can be booked instantaneously or in advance (but only for the current week)
    public static boolean isValidDate(LocalDate date) {
        int daysUntilNextWeek = 7 - LocalDate.now().getDayOfWeek().getValue();
        return !date.isAfter(LocalDate.now().plusDays(daysUntilNextWeek));
    }

    public boolean isOverlapping(Reservation reservation) {
        // needs better variable names.
        LocalDateTime localStartTime = this.dateTime;
        LocalDateTime localEndTime = this.dateTime.plusMinutes(this.reservationLengthMinutes);

        LocalDateTime otherStartTime = reservation.dateTime;
        LocalDateTime otherEndTime = reservation.dateTime.plusMinutes(this.reservationLengthMinutes);

        if(otherStartTime.isAfter(localStartTime) && otherStartTime.isBefore(localEndTime)) return true;
        if(localStartTime.isAfter(otherStartTime) && localStartTime.isBefore(otherEndTime)) return true;
        return false;

    }

}
