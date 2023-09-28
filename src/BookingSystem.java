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
            case "Add course":
                System.out.println("Please enter the name of the new course");
                answerStr = scanner.nextLine();
                Course newCourse = new Course(answerStr);
                addCourse(newCourse);
                System.out.println("Success!");
                break;

            case "New student":
                System.out.println("Please enter the students name");
                answerStr = scanner.nextLine();
                Student newStudent = new Student(answerStr);
                System.out.println("Please enter the courses, which this student should be added to (press enter after each course name)");
                System.out.println("If you are finished entering courses, enter 0");
                for (int i = 0; i < 5; i++)
                {
                    answerStr= scanner.nextLine();
                    if(answerStr.equals("0")) break;
                    Course course = getCourse(answerStr);
                    if(course == null) {
                        System.out.println("This course does not exist, try again.");
                        i--;
                        continue;
                    }
                    if(course.studentList.contains(newStudent)){
                        System.out.println("Student is already added to this group!");
                        i--;
                        continue;
                    }
                    course.studentList.add(newStudent);
                }
                System.out.println("Success");
                break;

            case "Generate groups" :


                break;

            case "Example":
                // Generate students and give them

                break;

            default:
                System.out.println("That's not a real command bro, do the command 'Help' to see all commands");
                break;

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

