package ExamSystemSplitMine.SystemSplit.Hardware;

import ExamSystemSplitMine.SystemSplit.Components.HardwareComponent;

public class HeavyHardwareComponent extends HardwareComponent {
    public HeavyHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name,"Heavy");
        this.setCapacity(maximumCapacity);
        this.setMemory(maximumMemory);
    }

    @Override
    public void setCapacity(int maximumCapacity) {
        super.setCapacity(maximumCapacity * 2);
    }

    @Override
    public void setMemory(int maximumMemory) {
        super.setMemory(maximumMemory - (int) (maximumMemory * 0.25));
    }
}
