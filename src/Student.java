import java.util.*;

public class Student {
    private String name;
    private int UID; // probably necessary in a real system to handle duplicate names
    private static int uidCounter = 0;

    private static List<Student> allStudents = new ArrayList<>();

    public Student(String name)
    {
        this.name = name;
        this.UID = uidCounter;
        uidCounter ++;
        allStudents.add(this);
    }

    public static List<Student> getAllStudents() {
        return allStudents;
    }

    public static Student findStudentByName(String name) {
        for(Student student : allStudents) {
            if(student.name.equals(name)) return student;
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public void assignRandomCourses(List<Course> courses) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();
        int numberOfCourses = courses.size();

        while(uniqueNumbers.size() < 5) {
            int randomCourseNumber = random.nextInt(numberOfCourses);
            uniqueNumbers.add(randomCourseNumber);
        }

        for(int number : uniqueNumbers) {
            Course course = courses.get(number);
            course.studentList.add(this);
        }
    }*/

    public int getUID() {
        return UID;
    }
    public void setUID(int UID) {
        this.UID = UID;
    }
}
