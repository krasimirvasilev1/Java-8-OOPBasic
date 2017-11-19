package ThirdExersiceInheritance.Mankind;

public abstract class Human {
    String firstName;
    String lastName;

    protected Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (firstName.charAt(0) == firstName.toUpperCase().charAt(0) && firstName.length() >= 4) {
            this.firstName = firstName;
        } else if (firstName.charAt(0) != firstName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
    }

    private void setLastName(String lastName) {
        if (lastName.charAt(0) == lastName.toUpperCase().charAt(0) && lastName.length() >= 3) {
            this.lastName = lastName;
        }
        else if (lastName.charAt(0) != lastName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(String.format("First Name: %s%nLast Name: %s%n",this.firstName,this.lastName)).toString();
    }
}
