import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    public List<Student> studentList = new ArrayList<>();
    public List<Group> groupList = new ArrayList<>();
    public Course(String courseName){
        name = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
