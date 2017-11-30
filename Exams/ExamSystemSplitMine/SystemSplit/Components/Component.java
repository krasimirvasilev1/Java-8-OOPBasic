package ExamSystemSplitMine.SystemSplit.Components;

public abstract class Component {
    private String name;
    private String type;
    private int memory;
    private int capacity;

    protected Component(String name, String type) {
        setName(name);
        setType(type);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected void setMemory(int memory){
        this.memory = memory;
    }

    public int getMemory() {
        return memory;
    }

    protected void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }
}
