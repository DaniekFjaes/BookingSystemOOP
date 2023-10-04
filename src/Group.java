import java.util.ArrayList;
import java.util.List;

public class Group {

    private static int groupCount = 0;
    private int groupNumber;
    private  List<Student> studentList = new ArrayList<>();
    private static List<Group> allGroups = new ArrayList<>();

    private int totalBookedMinutes = 0;

    public Group() {
        groupNumber = groupCount;
        groupCount += 1;
        allGroups.add(this);
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
    public static Group findGroupByNumber(int number) {
        for(Group group : allGroups) {
            if (group.groupNumber == number) return group;
        }
        return null;
    }

    // checks if this group has priority over another group
    public boolean hasPriority(Group otherGroup) {
        //Each group can book rooms for a total of four hours per week with the highest priority.
        if(this.totalBookedMinutes > 240 && otherGroup.totalBookedMinutes <= 240) return false;
        if(this.totalBookedMinutes <= 240 && otherGroup.totalBookedMinutes > 240) return true;

        //Afterwards, the priority is inversely proportional to the number of hours that the group has already booked that week.
        if(this.totalBookedMinutes > otherGroup.totalBookedMinutes) return false;
        if(this.totalBookedMinutes < otherGroup.totalBookedMinutes) return true;

        //Additionally, if there are two groups with the same priority that want to book the
        //same room at the same time, priority is given to the group with a larger number of students.
        if(this.studentList.size() > otherGroup.getStudentList().size()) return true;
        if(this.studentList.size() < otherGroup.getStudentList().size()) return false;

        //If none of the priority conditions are met, it's first come, first served. (Not specified in the assignment)
        return false;
    }

}
