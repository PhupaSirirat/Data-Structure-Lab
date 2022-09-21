public class CourseGrade {

    private String c_ID, c_name, semis, year, unit, gpa;

    public CourseGrade(String c_ID, String c_name, String semis, String year, String unit, String gpa) {
        this.c_ID = c_ID;
        this.c_name = c_name;
        this.semis = semis;
        this.year = year;
        this.unit = unit;
        this.gpa = gpa;
    }

    public String toString() {
        return String.format("%s %s %s/%s %s %s", c_ID,c_name,year,semis,unit,gpa);
    }
}
