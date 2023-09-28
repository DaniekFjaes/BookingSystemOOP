import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
public class Course {

    private String name;
    public List<Student> studentList = new ArrayList<>();
    public List<Group> groupList = new ArrayList<>();

    private final int MAX_STUDENTS_PER_GROUP = 6;
    public Course(String courseName){
        name = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createRandomStudentGroups(int minStudentsPerGroup){
        for(Student student : studentList) {

        }
    }


}
