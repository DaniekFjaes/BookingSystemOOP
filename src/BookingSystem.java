import java.util.*;

public class BookingSystem {


    public static void closeSystem() {
        System.exit(0);
    }

    /*
    public void generateExampleScenario(int numberOfCourses, int numberOfStudents) {
        // using a Set to guarantee unique numbers, because they don't allow duplicates.
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        // generate x example courses
        for (int i = 0; i < numberOfCourses; i++) {
            Course course = new Course("Course " + i);
            courseList.add(course);
        }

        // generate x students and assign them to 5 random courses
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student("Student " + i);
            student.assignRandomCourses(courseList);
        }
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;
        while (true) {
            System.out.println("Please enter a command");
            response = scanner.nextLine();
            InputHandler.runCommand(response);
        }


    }


}

