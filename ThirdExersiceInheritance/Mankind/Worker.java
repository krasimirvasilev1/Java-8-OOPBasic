package ThirdExersiceInheritance.Mankind;

public class Worker extends Human {
    double weekSalary;
    double workHoursPerDay;

    public Worker(String firstName, String lastName, double workSalary, double workHoursPerDay) {
        super(firstName, lastName);
        setWorkSalary(workSalary);
        setWorkHoursPerDay(workHoursPerDay);
    }


    private void setWorkSalary(double weekSalary) {
        if (weekSalary > 10) {
            this.weekSalary = weekSalary;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay >= 1 && workHoursPerDay <= 12) {
            this.workHoursPerDay = workHoursPerDay;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
    }

    private double salaryPerHour(double weekSalary, double workHoursPerDay) {
        return weekSalary / (workHoursPerDay * 7);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(String.format("%sWeek salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",super.toString(), this.getWeekSalary(), this.getWorkHoursPerDay(), salaryPerHour(this.weekSalary, this.workHoursPerDay))).toString();
    }
}
