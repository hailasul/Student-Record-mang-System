package studentproject.newpackage;

import java.io.*;
import java.util.*;


public class StudentManager implements IStudentManager {  
    private final List<Student> students = new ArrayList<>();
    public List<Student> getAllStudents() {
    return students;
}

    private static final String FILE_NAME = "students.txt";

   
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        
        for (Student s : students) {
            bw.write(s.toString() + "\n");  
            bw.newLine();
        }
       
    }
}

    @Override
    public void loadFromFile() throws IOException {
        students.clear();  

        File file = new File(FILE_NAME);
        if (!file.exists()) return;  

        try(Scanner sc = new Scanner(file)) {

          while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");  
            
            String type = data[0]; 
            String id = data[1];
            String name = data[2];
            double gpa = Double.parseDouble(data[3]);  
            String dept = data[4] ;
            int year = Integer.parseInt(data[5]);

            if ("Honor".equalsIgnoreCase(type)) {
                String award = data.length > 6 ? data[6] : "";
                students.add(new HonorStudent(id, name, gpa, dept, year, award));
             } else {
                students.add(new RegularStudent(id, name, gpa, dept, year));
                }
        }
    
    }
}

    @Override
    public void printAll() {
        if (students.isEmpty()){
            System.out.println("No students available.");
            return;
        }
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

    @Override
    public void reportByGpa(double minGpa) {
    for (Student s : students) {
        if (s.getGpa() >= minGpa) {
            System.out.println(s);
        }
    }
}

     @Override
     public void reportByYear(int year) {
     for (Student s : students) {
         if (s.getYear() == year) {
            System.out.println(s);
        }
    }
}
     @Override
     public void reportTopStudent() {
         if (students.isEmpty()) {
           System.out.println("No students available.");
            return;
    }
    Student top = students.get(0);
    for (Student s : students) {
        if (s.getGpa() > top.getGpa()) {
            top = s;
        }
    }
    System.out.println("Top Student: " + top);
}

}


