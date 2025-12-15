package studentproject.newpackage;


public class ReportThread extends Thread {
    private final StudentManager manager;

    public ReportThread(StudentManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
         
            manager.reportTopStudent();
        } catch (Exception e) {
            System.out.println("Report Error: " + e.getMessage());
        }
    }
         
}
