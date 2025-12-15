package studentproject.newpackage;


import java.io.IOException;

public interface IStudentManager {
    void addStudent(Student s);
    Student search(String id);
    boolean updateStudent(String id, String newName, double newGpa, String newDept, int newYear);
    boolean deleteStudent(String id);
    void printAll();
    void saveToFile() throws IOException;
    void loadFromFile() throws IOException;
    void reportByDepartment(String dept);
    void reportByGpa(double minGpa);
    void reportByYear(int year);
    void reportTopStudent();
}
