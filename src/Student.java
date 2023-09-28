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

    public int getUID() {
        return UID;
    }
    public void setUID(int UID) {
        this.UID = UID;
    }
}
