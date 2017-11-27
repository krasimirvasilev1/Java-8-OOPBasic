package ExamMay08Mine.Monuments;

abstract public class Monument {
    protected String name;

    public Monument(String name) {
        this.name = name;
    }

    public abstract double getAffinity();
}
