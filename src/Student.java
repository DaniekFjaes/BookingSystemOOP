import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Student {
    private String name;
    private int UID; // probably won't be used, but would be necessary in a real system to handle duplicate names

    public Student(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    }

    public int getUID() {
        return UID;
    }
    public void setUID(int UID) {
        this.UID = UID;
    }
}
