package ExamPawIncMine.pawInc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        AnimalCenterManager manager = new AnimalCenterManager();
        while (true) {
            String input = console.readLine();
            String[] commands = input.split(" \\| ");
            switch (commands[0]) {
                case "RegisterCleansingCenter":
                    manager.registerCleansingCenter(commands[1]);
                    break;
                case "RegisterAdoptionCenter":
                    manager.registerAdoptionCenter(commands[1]);
                    break;
                case "RegisterCastrationCenter":
                    manager.registerCastrationCenter(commands[1]);
                    break;
                case "RegisterDog":
                    manager.registerDog(commands[1],Integer.parseInt(commands[2]),Integer.parseInt(commands[3]),commands[4]);
                    break;
                case "RegisterCat":
                    manager.registerCat(commands[1],Integer.parseInt(commands[2]),Integer.parseInt(commands[3]),commands[4]);
                    break;
                case "SendForCleansing":
                    manager.sendForCleansing(commands[1],commands[2]);
                    break;
                case "SendForCastration":
                    manager.sendForCastration(commands[1],commands[2]);
                    break;
                case "Cleanse":
                    manager.cleanse(commands[1]);
                    break;
                case "Castrate":
                    manager.castrate(commands[1]);
                    break;
                case "Adopt":
                    manager.adopt(commands[1]);
                    break;
                case "CastrationStatistics":
                    manager.castrationStatistics();
                    break;
                case "Paw Paw Pawah":
                    manager.printStatistics();
                    break;
            }
            if(input.equalsIgnoreCase("Paw Paw Pawah")){
                break;
            }
        }
    }
}
