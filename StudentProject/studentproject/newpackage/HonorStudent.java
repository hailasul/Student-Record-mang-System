package studentproject.newpackage;



public class HonorStudent extends Student {

    private String award; 

    public HonorStudent(String id, String name, double gpa, String department, int year, String award) {
        super(id, name, gpa, department, year); 
        this.award = award;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return super.toString() + ", Award: " + award;
    }
}