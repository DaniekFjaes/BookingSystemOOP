import java.util.ArrayList;
import java.util.List;

public class Group {

    private static int groupCount = 0;
    private int groupNumber;
    private  List<Student> studentList = new ArrayList<>();

    public Group() {
        groupNumber = groupCount;
        groupCount += 1;
    }

    public boolean isFull() {
        return this.studentList.size() >= 6;
    }

    public void addStudent(Student student) {
        if(!studentList.contains(student)) studentList.add(student);
        else System.out.println("Error: Student already exists in this group!");
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
}
