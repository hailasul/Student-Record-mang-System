package studentproject.newpackage;


public class Student {
    private String id;
    private String name;
    private double gpa;
    private String department;
    private int year;

    public Student(String id, String name, double gpa, String department, int year) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.department = department;
        this.year = year;
    }

   
    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getDepartment() { return department; }
    public int getYear() { return year; }

   
    public void setName(String name) { this.name = name; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setDepartment(String department) { this.department = department; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return id + "," + name + "," + gpa + "," + department + "," + year;
    }
}