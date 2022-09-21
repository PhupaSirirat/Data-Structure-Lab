import java.util.Objects;

public class Student {

    private String std_ID, fname, lname;

    public Student(String id, String fname, String lname) {
        this.std_ID = id;
        this.fname = fname;
        this.lname = lname;
    }

    public String getID() {
        return std_ID;
    }

    public String toString() {
        return fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(std_ID, student.std_ID) && Objects.equals(fname, student.fname) && Objects.equals(lname, student.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(std_ID, fname, lname);
    }
}
