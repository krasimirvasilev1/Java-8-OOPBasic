package retake_exam_javaOOPBasicReal;

import retake_exam_javaOOPBasicReal.models.Colony;
import retake_exam_javaOOPBasicReal.models.colonists.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] input = console.readLine().split("\\s+");
        Colony colony = new Colony(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

        while (true) {
            String string = console.readLine();
            String debug = "";
            if ("end".equals(string)) {
                break;
            }

            String[] commands = string.split("\\s+");
            switch (commands[0]) {
                case "insert":
                    Colonist colonist = null;
                    switch (commands[1]) {
                        case "SoftwareEngineer":
                            colonist = new SoftwareEngineer(commands[2], commands[3], Integer.parseInt(commands[4]), Integer.parseInt(commands[5]));
                            break;
                        case "HardwareEngineer":
                            colonist = new HardwareEngineer(commands[2], commands[3], Integer.parseInt(commands[4]), Integer.parseInt(commands[5]));
                            break;
                        case "Soldier":
                            colonist = new Soldier(commands[2], commands[3], Integer.parseInt(commands[4]), Integer.parseInt(commands[5]));
                            break;
                        case "GeneralPractitioner":
                            colonist = new GeneralPractitioner(commands[2], commands[3], Integer.parseInt(commands[4]), Integer.parseInt(commands[5]), commands[6]);
                            break;
                        case "Surgeon":
                            colonist = new Surgeon(commands[2], commands[3], Integer.parseInt(commands[4]), Integer.parseInt(commands[5]), commands[6]);
                            break;
                    }
                    if (colonist != null) {
                        colony.addColonist(colonist);
                    }
                    break;
                case "remove":
                    switch (commands[1]) {
                        case "family":
                            colony.removeFamily(commands[2]);
                            break;
                        case "colonist":
                            colony.removeColonist(commands[2], commands[3]);
                            break;
                    }
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(commands[1]));
                    break;
                case "potential":
                    int potential = colony.getPotential();
                    System.out.println(String.format("potential: %d", potential));
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    List<Colonist> colonists = colony.getColonistsByFamilyId(commands[1]);
                    if (colonists == null) {
                        System.out.println("family does not exist");
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append(String.format("%s:%n", commands[1]));
                        for (Colonist colonist1 : colonists) {
                            builder.append(String.format("-%s: %d%n", colonist1.getId(), colonist1.getPotential()));
                        }

                        System.out.println(builder.toString().trim());
                    }
                    break;
            }
        }
    }
}
