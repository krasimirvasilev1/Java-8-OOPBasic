package FirstExersiceDefiningClasses.Google;

public class Parents {
    String parentName;
    String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public Parents() {
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n",getParentName(),getParentBirthday());
    }
}
