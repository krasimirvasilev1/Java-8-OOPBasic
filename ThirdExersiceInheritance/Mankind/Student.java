package ThirdExersiceInheritance.Mankind;

public class Student extends Human{
    String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() >= 5 && facultyNumber.length() <= 10){
            this.facultyNumber = facultyNumber;
        }
        else{
            throw new IllegalArgumentException("Invalid faculty number!");
        }
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(String.format("%sFaculty number: %s%n",super.toString(),this.getFacultyNumber())).toString();
    }
}
