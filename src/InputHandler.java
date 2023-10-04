import java.sql.Time;
import java.time.*;
import java.util.*;
import java.util.function.IntToLongFunction;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);
    private static String ans;

    //Probably a better way to do/use this, but I'm just using it because don't want to flood runCommand with prints.
    private static String[] commandStrings = {"help", "exit", "create student", "create group", "create course", "create room", "reserve room", "remove student", "remove group", "remove course", "remove room", "free room", "add student to group", "add student to course", "remove student from group", "remove student from course"};

    // Code could be run directly in the cases, but I think this looks a bit cleaner.
    public static void runCommand(String commandString) {
        switch (commandString) {
            case "help":
                helpCommand();
                break;
            case "exit":
                exitCommand();
                break;
            case "create student":
                createStudentCommand();
                break;
            case "create group":
                createGroupCommand();
                break;
            case "create course":
                createCourseCommand();
                break;
            case "create room":
                createRoomCommand();
                break;
            case "reserve room":
                reserveRoomCommand();
                break;
            case "remove student":
                break;
            case "remove group":
                break;
            case "remove course":
                break;
            case "remove room":
                break;
            case "free room":
                break;
            case "add student to group":
                addStudentToGroupCommand();
                break;
            case "add student to course":
                addStudentToCourseCommand();
                break;
            case "remove student from group":
                break;
            case "remove student from course":
                break;

        }
    }

    // commands
    private static void helpCommand() {
        for (String string : commandStrings) System.out.println(string);
    }

    private static void exitCommand() {
        System.out.println("You killed the program. Murderer >:(");
        BookingSystem.closeSystem();
    }

    private static void createStudentCommand() {
        System.out.println("Enter the name of the student.");
        new Student(scanner.nextLine()); // Evil scan as parameter, probably bad practice but idc.
    }

    private static void createGroupCommand() {
        System.out.println("Enter the name of the course (case sensitive)");
        ans = scanner.next();
        Course course = Course.findCourseByName(ans);
        if (course == null) {
            System.out.println("Could not find course.");
            return;
        }
        Group group = new Group();
        course.addGroup(group);
        System.out.println("Group added. ID is: " + group.getGroupNumber());
    }

    private static void createCourseCommand() {
        System.out.println("Enter the name of the course");
        new Course(scanner.nextLine());
    }

    private static void createRoomCommand() {
        System.out.println("Enter the name of the room");
        ans = scanner.nextLine();
        if (Room.findRoomByName(ans) != null) {
            System.out.println("Room already exists.");
            return;
        }
        new Room(ans);
    }

    private static void addStudentToGroupCommand() {
        System.out.println("Enter the name of the course, which the group belongs to");
        ans = scanner.nextLine();
        Course course = Course.findCourseByName(ans);
        if (course == null) {
            System.out.println("Could not find course");
            return;
        }

        System.out.println("Please enter a student name");
        ans = scanner.nextLine();
        Student student = Student.findStudentByName(ans);
        if (!course.getStudentList().contains(student)) {
            System.out.println("Student does not exist in this course!");
            return;
        }
        if (course.isStudentInGroup(student)) {
            System.out.println("Student is already in a group!");
            return;
        }

        System.out.println("The following groups exist in this course.");
        course.printGroups();
        System.out.println("Please enter the group number of the group you want the student assigned to.");
        Scanner intScan = new Scanner(System.in);
        Group group = course.findGroupByNumber(intScan.nextInt());
        if (group == null) {
            System.out.println("This group does not exist in this course!");
            return;
        }
        if (group.isFull()) {
            System.out.println("Group is full!");
            return;
        }

        group.addStudent(student);
        System.out.println("Student added!");

    }

    private static void addStudentToCourseCommand() {
        System.out.println("Please enter the name of the student");
        ans = scanner.nextLine();
        Student student = Student.findStudentByName(ans);
        if (student == null) {
            System.out.println("Student does not exist!");
            return;
        }

        System.out.println("Please enter the name of the course, to add the student to");
        ans = scanner.nextLine();
        Course course = Course.findCourseByName(ans);
        if (course == null) {
            System.out.println("Course does not exist");
            return;
        }
        course.addStudent(student);

    }

    private static void reserveRoomCommand() {
        System.out.println("Enter the group number of the group that needs a room reserved");
        Group group = Group.findGroupByNumber(scanner.nextInt());// evil parameter scan (I'm not sorry)
        if (group == null) {
            System.out.println("Invalid group");
            return;
        }

        System.out.println("Which room is the group trying to book?");
        ans = scanner.nextLine();
        Room room = Room.findRoomByName(ans);
        if (room == null) {
            System.out.println("This room doesn't exist.");
            return;
        }

        System.out.println("How many minutes does the group want the room?");
        System.out.println("Options: 30, 60, 90, 120");

        int reservationLength = scanner.nextInt();
        switch (reservationLength) {
            case 30:
            case 60:
            case 90:
            case 120:
                break;
            default:
                System.out.println("This is not one of the options.");
                return;
        }

        System.out.println("Please enter the hour of the reservation, press enter, then enter the minutes (24 hour clock)");
        try{
            LocalTime reservationTime = LocalTime.of(scanner.nextInt(), scanner.nextInt()); // Very evil double parameter scan, but I'm still not sorry!
            if(!Reservation.isValidTime(reservationTime, reservationLength)) {
                System.out.println("You can only make reservations between 8 and 17");
                return;
            }
        } catch (DateTimeException e) {
            System.out.println("Invalid time!");
            return;
        }

        System.out.println("Please enter the year, then enter the month, and finally enter the day.");
        try{
            LocalDate reservationDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt() ); // Very evil double parameter scan, but I'm still not sorry!
            if(!Reservation.isValidDate(reservationDate)) {
                System.out.println("Reservations cannot be made ");
            }
        } catch (DateTimeException e) {
            System.out.println("Invalid date!");
            return;
        }


    }
}
