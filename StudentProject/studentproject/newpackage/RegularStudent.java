package studentproject.newpackage;


public class RegularStudent extends Student {

    public RegularStudent(String id, String name, double gpa, String department, int year) {
        super(id, name, gpa, department, year);
    }

    @Override
    public String getStudentType() {
        return "Regular";
    }

}
