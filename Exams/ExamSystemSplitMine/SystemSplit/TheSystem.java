package ExamSystemSplitMine.SystemSplit;

import ExamSystemSplitMine.SystemSplit.Components.HardwareComponent;
import ExamSystemSplitMine.SystemSplit.Components.SoftwareComponent;
import ExamSystemSplitMine.SystemSplit.Hardware.HeavyHardwareComponent;
import ExamSystemSplitMine.SystemSplit.Hardware.PowerHardwareComponent;
import ExamSystemSplitMine.SystemSplit.Software.ExpressSoftwareComponent;
import ExamSystemSplitMine.SystemSplit.Software.LightSoftwareComponent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheSystem {
    private Map<String, HardwareComponent> allComponents;
    private int operationalMemoryInUse;
    private int maximumMemory;
    private int operationalCapacityInUse;
    private int maximumCapacity;

    public TheSystem() {
        this.allComponents = new LinkedHashMap<>();
        this.operationalMemoryInUse = 0;
        this.maximumMemory = 0;
        this.operationalCapacityInUse = 0;
        this.maximumCapacity = 0;
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        this.allComponents.put(name, new PowerHardwareComponent(name, capacity, memory));
        maximumMemory += this.allComponents.get(name).getMemory();
        maximumCapacity += this.allComponents.get(name).getCapacity();
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        this.allComponents.put(name, new HeavyHardwareComponent(name, capacity, memory));
        maximumMemory += this.allComponents.get(name).getMemory();
        maximumCapacity += this.allComponents.get(name).getCapacity();
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.allComponents.containsKey(hardwareComponentName)) {
            ExpressSoftwareComponent expressSoftwareComponent = new ExpressSoftwareComponent(name, capacity, memory);
            int isRegisterSucc = this.allComponents.get(hardwareComponentName).getSoftwareComponents().size();
            this.allComponents.get(hardwareComponentName).registerSoftwareComponent(expressSoftwareComponent);
            if (isRegisterSucc < this.allComponents.get(hardwareComponentName).getSoftwareComponents().size()) {
                operationalMemoryInUse += expressSoftwareComponent.getMemory();
                operationalCapacityInUse += expressSoftwareComponent.getCapacity();
            }
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.allComponents.containsKey(hardwareComponentName)) {
            LightSoftwareComponent lightSoftwareComponent = new LightSoftwareComponent(name, capacity, memory);
            int isRegisterSucc = this.allComponents.get(hardwareComponentName).getSoftwareComponents().size();
            this.allComponents.get(hardwareComponentName).registerSoftwareComponent(lightSoftwareComponent);
            if (isRegisterSucc <  this.allComponents.get(hardwareComponentName).getSoftwareComponents().size()) {
                operationalMemoryInUse += lightSoftwareComponent.getMemory();
                operationalCapacityInUse += lightSoftwareComponent.getCapacity();
            }
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        SoftwareComponent componentToRemove = null;
        if (this.allComponents.containsKey(hardwareComponentName)) {
            for (SoftwareComponent softwareComponent : this.allComponents.get(hardwareComponentName).getSoftwareComponents()) {
                if (softwareComponent.getName().equalsIgnoreCase(softwareComponentName)) {
                    componentToRemove = softwareComponent;
                }
            }
        }
        if (componentToRemove != null) {
            operationalMemoryInUse -= componentToRemove.getMemory();
            operationalCapacityInUse -= componentToRemove.getCapacity();
            this.allComponents.get(hardwareComponentName).getSoftwareComponents().remove(componentToRemove);
        }
    }

    public String analyze() {
        StringBuilder builder = new StringBuilder();
        int numberOfSoftComponents = 0;
        builder.append(String.format("System Analysis%n"));
        builder.append(String.format("Hardware Components: %d%n", this.allComponents.size()));
        for (String s : this.allComponents.keySet()) {
            numberOfSoftComponents += this.allComponents.get(s).getSoftwareComponents().size();
        }
        builder.append(String.format("Software Components: %d%n", numberOfSoftComponents));
        builder.append(String.format("Total Operational Memory: %d / %d%n", this.operationalMemoryInUse, this.maximumMemory));
        builder.append(String.format("Total Capacity Taken: %d / %d%n", this.operationalCapacityInUse, this.maximumCapacity));

        return builder.toString();
    }

    public String split() {
        StringBuilder builder = new StringBuilder();
        for (String s : this.allComponents.keySet()) {
            builder.append(String.format("Hardware Component - %s%n", s));
            builder.append(String.format("Express Software Components - %d%n", this.allComponents.get(s).getSoftwareComponents().stream().filter(x -> x.getClass().getSimpleName().equalsIgnoreCase("ExpressSoftwareComponent")).count()));
            builder.append(String.format("Light Software Components - %d%n", this.allComponents.get(s).getSoftwareComponents().stream().filter(x -> x.getClass().getSimpleName().equalsIgnoreCase("LightSoftwareComponent")).count()));
            builder.append(String.format("Memory Usage: %d / %d%n", this.allComponents.get(s).getSoftwareComponents().stream().mapToInt(x -> x.getMemory()).sum(), this.allComponents.get(s).getMemory()));
            builder.append(String.format("Capacity Usage: %d / %d%n", this.allComponents.get(s).getSoftwareComponents().stream().mapToInt(x -> x.getCapacity()).sum(), this.allComponents.get(s).getCapacity()));
            if (this.allComponents.get(s).getClass().getSimpleName().equalsIgnoreCase("HeavyHardwareComponent")) {
                builder.append(String.format("Type: Heavy%n"));
            } else {
                builder.append(String.format("Type: Power%n"));
            }
            if (this.allComponents.get(s).getSoftwareComponents().isEmpty()) {
                builder.append(String.format("Software Components: None%n"));
            }
            List<String> allComponentsNames = new ArrayList<>();
            for (SoftwareComponent softwareComponent : this.allComponents.get(s).getSoftwareComponents().stream().sorted((x,y) -> y.getClass().getSimpleName().compareTo(x.getClass().getSimpleName())).collect(Collectors.toList())) {
                allComponentsNames.add(softwareComponent.getName());
            }
            builder.append(String.format("Software Components: %s%n", String.join(", ", allComponentsNames)));
        }

        return builder.toString();
    }
}
