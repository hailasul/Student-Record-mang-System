package studentproject.newpackage;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager sm = new StudentManager();
        Scanner input = new Scanner(System.in);

        try {
            sm.loadFromFile();
            if (sm.getAllStudents().isEmpty()) {
                sm.addStudent(new HonorStudent("50", "Haila", 4.9, "CS", 4, "Top GPA"));
                sm.addStudent(new HonorStudent("51", "Mona", 4.5, "IT", 3, "Best Project"));
                sm.addStudent(new RegularStudent("10", "Sara", 3.8, "IT", 3));

                try {
                sm.saveToFile();
            } catch (Exception ex) {
                System.out.println("Error saving initial students.");
            }
        }
        } catch (Exception e) {
            System.out.println("No previous file found.");
            sm.addStudent(new HonorStudent("50", "Haila", 4.9, "CS", 4, "Top GPA"));
            sm.addStudent(new HonorStudent("51", "Mona", 4.5, "IT", 3, "Best Project"));
            sm.addStudent(new RegularStudent("10", "Sara", 3.8, "IT", 3));
             try {
                sm.saveToFile();
            } catch (Exception ex) {
                System.out.println("Error saving initial students.");
            }
        }


        new ReportThread(sm).start();
        AutoSaveThread t = new AutoSaveThread(sm);
        t.start();

        sm.printAll();

        
        
            while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Print All Students");
            System.out.println("6. Reports");
            System.out.println("7. Save to File");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Type (regular/honor): ");
                    String type = input.nextLine().trim();
                    System.out.print("Enter ID: ");
                    String id = input.nextLine().trim();
                    System.out.print("Enter Name: ");
                    String name = input.nextLine().trim();
                    if (sm.search(id) != null) {
                        System.out.println("Student with this ID already exists.");
                        break;
                    }
                    System.out.print("Enter GPA: ");
                    double gpa = Double.parseDouble(input.nextLine().trim());
                    System.out.print("Enter Department: ");
                    String dept = input.nextLine().trim();
                    System.out.print("Enter Year: ");
                    int year = Integer.parseInt(input.nextLine().trim());

                    if (type.equalsIgnoreCase("honor")) {
                        System.out.print("Enter Award: ");
                        String award = input.nextLine().trim();
                        sm.addStudent(new HonorStudent(id, name, gpa, dept, year, award));
                    } else {
                        sm.addStudent(new RegularStudent(id, name, gpa, dept, year));


                     }

             sm.reportByDepartment(dept);
                        break;
                case 2:
                   System.out.print("Enter ID of student to update: ");
                   String updateId = input.nextLine().trim();
                   Student s = sm.search(updateId);
                     if (s == null) {
                       System.out.println("Student not found.");
                   } else {
                      System.out.print("Enter new Name: ");
                      String newName = input.nextLine().trim();
                      System.out.print("Enter new GPA: ");
                      double newGpa = Double.parseDouble(input.nextLine().trim());
                      System.out.print("Enter new Department: ");
                      String newDept = input.nextLine().trim();
                      System.out.print("Enter new Year: ");
                      int newYear = Integer.parseInt(input.nextLine().trim());

                      s.setName(newName);
                      s.setGpa(newGpa);
                      s.setDepartment(newDept);
                      s.setYear(newYear);
            
                   if (s instanceof HonorStudent) {
                     System.out.print("Enter new Award: ");
                     String newAward = input.nextLine().trim();
                    ((HonorStudent) s).setAward(newAward);
                      }
                      System.out.println("Student updated successfully.");
                   }
                    break;

                case 3:
                 System.out.print("Enter ID of student to delete: ");
                 String deleteId = input.nextLine().trim();
                  if (sm.deleteStudent(deleteId)) {
                   System.out.println("Student deleted successfully.");
               } else {
                 System.out.println("Student not found.");
              }
                  break;
                case 4: 
                 System.out.print("Enter ID of student to search: ");
                 String searchId = input.nextLine().trim();
                 Student found = sm.search(searchId);
                 if (found != null) {
                 System.out.println("Student found: " + found);
                } else {
             System.out.println("Student not found.");
             }
                 break;

                case 5: 
               sm.printAll();
                break;

               case 6: 
               System.out.println("Reports Menu:");
               System.out.println("1. Report by Department");
               System.out.println("2. Top Student");
               System.out.print("Choose report type: ");
               int reportChoice = Integer.parseInt(input.nextLine().trim());
              if (reportChoice == 1) {
              System.out.print("Enter Department: ");
              String deptReport = input.nextLine().trim();
              sm.reportByDepartment(deptReport);
              } else if (reportChoice == 2) {
              sm.reportTopStudent();
             } else {
            System.out.println("Invalid report choice.");
            }
              break;
                
              case 7: 
             try {
             sm.saveToFile();
             System.out.println("Data saved successfully.");
         } catch (Exception ex) {
            System.out.println("Error while saving.");
           }
            break;

             case 8: 
             System.out.println("Exiting...");
             input.close();
             return;

             default:
             System.out.println("Invalid choice.");
   }

         }
    }
}

    


            

 