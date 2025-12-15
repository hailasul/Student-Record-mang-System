package studentproject.newpackage;


public class AutoSaveThread extends Thread {

    private final StudentManager manager;

    public AutoSaveThread(StudentManager manager) {
        this.manager = manager;
    }

   @Override
    public void run() {
    try {
        System.out.println("AutoSave thread started...");
        while (true) {
            Thread.sleep(10000);
            manager.saveToFile();
        }
    } catch (Exception e) {
        System.out.println("Auto Save Error: " + e.getMessage());
    }
}
}