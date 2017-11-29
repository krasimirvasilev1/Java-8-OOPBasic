package ExamNeedForSpeedMine.needForSpeed;


import needForSpeed.CarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManagement = new CarManager();
        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("Cops Are Here")) {
                break;
            }
            String[] commands = input.split("\\s+");
            try {
                switch (commands[0]) {
                    case "register":
                        carManagement.register(Integer.parseInt(commands[1]), commands[2], commands[3], commands[4], Integer.parseInt(commands[5]), Integer.parseInt(commands[6]), Integer.parseInt(commands[7]), Integer.parseInt(commands[8]), Integer.parseInt(commands[9]));
                        break;
                    case "check":
                        String checkOutput = carManagement.check(Integer.parseInt(commands[1]));
                        if (checkOutput.equalsIgnoreCase("")){
                            return;
                        }
                        else{
                            System.out.print(checkOutput);
                        }
                        break;
                    case "open":
                        carManagement.open(Integer.parseInt(commands[1]), commands[2], Integer.parseInt(commands[3]), commands[4], Integer.parseInt(commands[5]));
                        break;
                    case "participate":
                        carManagement.participate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                        break;
                    case "start":
                        String resultOfTheRace = carManagement.start(Integer.parseInt(commands[1]));
                        if(resultOfTheRace.equalsIgnoreCase("")){
                            return;
                        }else{
                            System.out.print(resultOfTheRace);
                        }
                        break;
                    case "park":
                        carManagement.park(Integer.parseInt(commands[1]));
                        break;
                    case "unpark":
                        carManagement.unpark(Integer.parseInt(commands[1]));
                        break;
                    case "tune":
                        carManagement.tune(Integer.parseInt(commands[1]), commands[2]);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
