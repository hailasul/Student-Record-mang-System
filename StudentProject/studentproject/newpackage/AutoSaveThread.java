package studentproject.newpackage;

public class AutoSaveThread extends Thread {

    private StudentManager manager;

    public AutoSaveThread(StudentManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10000);
                manager.saveToFile();
                System.out.println("Auto Saved...");
            }
        } catch (Exception e) {
            System.out.println("Auto Save Error");
        }
    }
}