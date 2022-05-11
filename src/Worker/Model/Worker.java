package Worker.Model;

public class Worker {

    private String id;
    private String name;
    private int age;
    private String address;
    private boolean status;
    private long salaryPerHour;
    private String gmail;

    public Worker() {
    }

    public Worker(String id, String name, int age, String address, boolean status, long salaryPerHour, String gmail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.status = status;
        this.salaryPerHour = salaryPerHour;
        this.gmail = gmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(long salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

}