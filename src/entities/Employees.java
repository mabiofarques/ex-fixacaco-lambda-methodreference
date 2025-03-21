package entities;

public class Employees {
    private String name;
    private String email;
    private double salary;

    public Employees(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " + String.format("%.2f", salary);
    }
}
