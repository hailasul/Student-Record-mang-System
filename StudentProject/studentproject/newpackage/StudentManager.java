package studentproject.newpackage;



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();


    public void addStudent(Student s) {
        for (Student existingStudent : students) {
            if (existingStudent.getId().equals(s.getId())) {
                System.out.println("Student already exists.");
                return;  
            }
        }
        
        students.add(s);
    }

    
    public Student search(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s; 
            }
        }
        return null; 
    }

   
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

   
    public boolean deleteStudent(String id) {
        Student s = search(id);
        if (s != null) {
            students.remove(s);  
            return true;  
        }
        return false;  
    }

    
    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter("students.txt");
        for (Student s : students) {
            fw.write(s.toString() + "\n");  
        }
        fw.close();  
    }

   
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

    
    public void printAll() {
        for (Student s : students) {
            System.out.println(s);  
        }
    }
}