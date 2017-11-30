package ExamSystemSplitMine.SystemSplit.Hardware;

import ExamSystemSplitMine.SystemSplit.Components.HardwareComponent;

public class PowerHardwareComponent extends HardwareComponent {

    public PowerHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Power");
        this.setCapacity(maximumCapacity);
        this.setMemory(maximumMemory);
    }

    @Override
    public void setCapacity(int maximumCapacity) {
        super.setCapacity(maximumCapacity - (int) (maximumCapacity * 0.75));
    }

    @Override
    public void setMemory(int maximumMemory) {
        super.setMemory(maximumMemory + (int) (maximumMemory * 0.75));
    }
}
