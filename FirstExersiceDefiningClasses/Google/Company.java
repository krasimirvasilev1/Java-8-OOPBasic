package FirstExersiceDefiningClasses.Google;

public class Company {
    String companyName;
    String department;
    double salary;

    public Company() {
    }

    public Company(String companyName,String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
