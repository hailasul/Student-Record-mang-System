package studentproject.newpackage;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager sm = new StudentManager();
        Scanner input = new Scanner(System.in);

        try {
            sm.loadFromFile();
        } catch (Exception e) {
            System.out.println("No previous file found.");
        }

        HonorStudent h = new HonorStudent("50", "Haila", 4.9, "CS", 4, "Top GPA");
        sm.addStudent(h);

        AutoSaveThread t = new AutoSaveThread(sm);
        t.start();

        try {
            sm.addStudent(new Student("10", "sara", 3.8, "IT", 3));
            sm.saveToFile();
        } catch (Exception e) {
            System.out.println("Error while saving.");
        }

        sm.printAll();

        
        while (true) {
            System.out.print("Enter department for report (or type exit): ");
            String dept = input.nextLine().trim();

            if (dept.equalsIgnoreCase("exit")) {
                System.out.println("Exiting report...");
                break;
            }

            sm.reportByDepartment(dept);
        }

        input.close();
    }
}