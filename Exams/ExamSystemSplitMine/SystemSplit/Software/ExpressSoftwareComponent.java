package ExamSystemSplitMine.SystemSplit.Software;

import ExamSystemSplitMine.SystemSplit.Components.SoftwareComponent;

public class ExpressSoftwareComponent extends SoftwareComponent {
    public ExpressSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name,"Express");
        this.setCapacity(capacityConsumption);
        this.setMemory(memoryConsumption);
    }

    @Override
    public void setMemory(int memoryConsumption){
        super.setMemory(memoryConsumption * 2);
    }
}
