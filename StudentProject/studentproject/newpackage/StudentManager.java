package studentproject.newpackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements IStudentManager {  

    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student s) {
        for (Student existingStudent : students) {
            if (existingStudent.getId().equals(s.getId())) {
                System.out.println("Student already exists.");
                return;  
            }
        }
        students.add(s);
    }

    @Override
    public Student search(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s; 
            }
        }
        return null; 
    }

    @Override
    public boolean updateStudent(String id, String newName, double newGpa, String newDept, int newYear) {
        Student s = search(id);
        if (s != null) {
            s.setName(newName);
            s.setGpa(newGpa);
            s.setDepartment(newDept);
            s.setYear(newYear);
            return true;  
        }
        return false;  
    }

    @Override
    public boolean deleteStudent(String id) {
        Student s = search(id);
        if (s != null) {
            students.remove(s);  
            return true;  
        }
        return false;  
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter("students.txt");
        for (Student s : students) {
            fw.write(s.toString() + "\n");  
        }
        fw.close();  
    }

    @Override
    public void loadFromFile() throws IOException {
        students.clear();  

        File file = new File("students.txt");
        if (!file.exists()) return;  

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");  
            Student s = new Student(
                    data[0],  
                    data[1],  
                    Double.parseDouble(data[2]),  
                    data[3], 
                    Integer.parseInt(data[4])  
            );
            students.add(s);  
        }
        sc.close();  
    }

    @Override
    public void printAll() {
        for (Student s : students) {
            System.out.println(s);  
        }
    }

    @Override
    public void reportByDepartment(String dept) {
        dept = dept.trim();
        for (Student s : students) {
            if (s.getDepartment().equalsIgnoreCase(dept)) {
                System.out.println(s);
            }
        }
    }
}
}
