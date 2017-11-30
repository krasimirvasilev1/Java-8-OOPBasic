package ExamSystemSplitMine.SystemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        TheSystem system = new TheSystem();

        while (true){
            String input = console.readLine();
            String[] firstCommand = input.split("\\(");
            String[] otherCommands = {};
            if (firstCommand.length > 1) {
                otherCommands = firstCommand[1].replace(")", "").split(", ");
            }
            switch(firstCommand[0]){
                case "RegisterPowerHardware":
                    system.registerPowerHardware(otherCommands[0],Integer.parseInt(otherCommands[1]),Integer.parseInt(otherCommands[2]));
                    break;
                case "RegisterHeavyHardware":
                    system.registerHeavyHardware(otherCommands[0],Integer.parseInt(otherCommands[1]),Integer.parseInt(otherCommands[2]));
                    break;
                case "RegisterExpressSoftware":
                    system.registerExpressSoftware(otherCommands[0],otherCommands[1],Integer.parseInt(otherCommands[2]),Integer.parseInt(otherCommands[3]));
                    break;
                case "RegisterLightSoftware":
                    system.registerLightSoftware(otherCommands[0],otherCommands[1],Integer.parseInt(otherCommands[2]),Integer.parseInt(otherCommands[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    system.releaseSoftwareComponent(otherCommands[0],otherCommands[1]);
                    break;
                case "Analyze":
                    System.out.print(system.analyze());
                    break;
                case "System Split":
                    System.out.print(system.split());
            }
            if (firstCommand[0].equalsIgnoreCase("System Split")){
                break;
            }
        }
    }
}
