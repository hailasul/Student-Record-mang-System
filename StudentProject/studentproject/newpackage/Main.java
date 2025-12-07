package studentproject.newpackage;



public class Main {
    public static void main(String[] args) throws Exception {

        StudentManager sm = new StudentManager();

        sm.loadFromFile();

        sm.addStudent(new Student("10", "sara", 3.8, "IT", 3));

        sm.saveToFile();

        System.out.println("Student added and saved successfully!");

        sm.printAll();
    }
}