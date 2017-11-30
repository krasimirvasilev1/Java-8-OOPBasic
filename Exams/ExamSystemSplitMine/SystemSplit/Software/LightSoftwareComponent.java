package ExamSystemSplitMine.SystemSplit.Software;

import ExamSystemSplitMine.SystemSplit.Components.SoftwareComponent;

public class LightSoftwareComponent extends SoftwareComponent {


    public LightSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "Light");
        this.setCapacity(capacityConsumption);
        this.setMemory(memoryConsumption);
    }

    @Override
    public void setMemory(int memoryConsumption){
        super.setMemory(memoryConsumption - (int)(memoryConsumption * 0.50));
    }
    @Override
    public void setCapacity(int capacityConsumption){
        super.setCapacity(capacityConsumption + (int)(capacityConsumption * 0.50));
    }
}
