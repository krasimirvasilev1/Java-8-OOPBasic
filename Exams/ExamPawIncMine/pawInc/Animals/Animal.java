package ExamPawIncMine.pawInc.Animals;

public abstract class Animal {
    private String name;
    private int age;
    private String cleansingStatus;

    protected Animal(String name, int age) {
        setName(name);
        setAge(age);
        setCleansingStatus("UNCLEANSED");
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

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }
}
