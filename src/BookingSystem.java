import java.util.*;

public class BookingSystem {

    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public Course getCourse(String name) {

        for (Course course : courseList) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }
    private void handleInput(String inputString) {
        Scanner scanner = new Scanner(System.in);
        String answerStr;

        switch (inputString) {
            case "Example":
                // Generate students and give them

                break;

            default:
                System.out.println("That's not a real command bro, do the command 'Help' to see all commands");
                break;
        }
    }

    public void generateExampleScenario(int numberOfCourses, int numberOfStudents)
    {
        // using a set to guarantee unique numbers, because they don't allow duplicates.
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        // generate x example courses
        for(int i = 0; i < numberOfCourses; i++)
        {
            Course course = new Course("Course " + i);
            courseList.add(course);
        }

        // generate x students and assign them to 5 random courses
        for(int i = 0; i < numberOfStudents; i++)
        {
            Student student = new Student("Student " + i);
            student.assignRandomCourses(courseList);
        }
    }

    public void assignRandomGroups(int minStudents) {

    }


    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.generateExampleScenario(10, 200);
        for(Course course : bookingSystem.courseList) {
            System.out.println("Course has students: ");

            for (Student student : course.studentList) {
                System.out.println(student.getName());
            }

        }

    }

    public void runSystem() {
        Scanner scanner = new Scanner(System.in);
        String response;
        while (true)
        {
            System.out.println("Please enter a command");
            response = scanner.nextLine();
            if(response.equals("Exit")) break;
            handleInput(response);
        }
        System.out.println("Exiting system.");

    }
}

