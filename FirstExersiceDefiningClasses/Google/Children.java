package FirstExersiceDefiningClasses.Google;

public class Children {
    String childName;
    String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public Children() {
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n",getChildName(),getChildBirthday());
    }
}
