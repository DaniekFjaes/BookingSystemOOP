import java.util.ArrayList;
import java.util.List;

public class Course {

    public static List<Course> allCourses = new ArrayList<>();
    private String name;
    private List<Student> studentList = new ArrayList<>();
    private List<Group> groupList = new ArrayList<>();
    private final int MAX_STUDENTS_PER_GROUP = 6;
    public Course(String courseName){
        this.name = courseName;
        allCourses.add(this);
    }

    public static Course findCourseByName(String name) {
        for(Course course : allCourses) {
            if(course.name.equals(name)) return course;
        }
        return null;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }
    public boolean isStudentInGroup(Student student) {
        for(Group group : groupList) {
            for(Student groupStudent : group.getStudentList()){
                if(groupStudent.equals(student)) return true;
            }
        }
        return false;
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public void printGroups() {
        for(Group group : groupList) {
            System.out.println(group.getGroupNumber());
        }
    }

    public Group findGroupByNumber(int number) {
        for (Group group : groupList) {
            if(group.getGroupNumber() == number) return group;
        }
        return null;
    }

    public void addToGroup(Student student) {
        if(this.studentList.size() < MAX_STUDENTS_PER_GROUP) studentList.add(student);
        else System.out.println("Failed, group is full!");
    }

    public String getName() {
        return name;
    }
}
