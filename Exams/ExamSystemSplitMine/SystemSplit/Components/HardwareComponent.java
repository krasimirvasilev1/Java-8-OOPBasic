package ExamSystemSplitMine.SystemSplit.Components;

import java.util.ArrayList;
import java.util.List;

public  abstract class HardwareComponent extends Component{
    private List<SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type) {
        super(name,type);
        this.softwareComponents = new ArrayList<>();
    }
    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        return super.getMemory();
    }

    public List<SoftwareComponent> getSoftwareComponents() {
        return softwareComponents;
    }

    public void registerSoftwareComponent (SoftwareComponent softwareComponent){
        int currCapacityConsumption = 0;
        int currMemoryConsumption = 0;
        for (SoftwareComponent component : getSoftwareComponents()) {
            currCapacityConsumption += component.getCapacity();
            currMemoryConsumption += component.getMemory();
        }
        if (currCapacityConsumption + softwareComponent.getCapacity() <= getCapacity() && currMemoryConsumption + softwareComponent.getMemory() <= getMemory()){
            this.getSoftwareComponents().add(softwareComponent);
        }
    }
}
