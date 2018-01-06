package NeedForSpeed;

import NeedForSpeed.io.InputReader;
import NeedForSpeed.io.OutputWriter;

import java.io.IOException;

public class Engine {
    private CarManager carManager;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public Engine() {
        this.carManager = new CarManager();
        this.inputReader = new InputReader();
        this.outputWriter = new OutputWriter();
    }

    public void run() throws IOException {
        while (true) {
            String input = this.inputReader.readLine();

            String debug = "";
            if ("Cops Are Here".equals(input)) {
                break;
            }

            String[] commands = input.split("\\s+");
            String output = null;
            switch(commands[0]){
                case "register":
                    this.carManager.register(Integer.parseInt(commands[1]),commands[2],commands[3],commands[4],Integer.parseInt(commands[5]),Integer.parseInt(commands[6]),Integer.parseInt(commands[7]),Integer.parseInt(commands[8]),Integer.parseInt(commands[9]));
                    break;
                case "check":
                    output = this.carManager.check(Integer.parseInt(commands[1]));
                    break;
                case "open":
                    this.carManager.open(Integer.parseInt(commands[1]),commands[2],Integer.parseInt(commands[3]),commands[4],Integer.parseInt(commands[5]));
                    break;
                case "participate":
                    this.carManager.participate(Integer.parseInt(commands[1]),Integer.parseInt(commands[2]));
                    break;
                case "start":
                    output = this.carManager.start(Integer.parseInt(commands[1]));
                    break;
                case "park":
                    this.carManager.park(Integer.parseInt(commands[1]));
                    break;
                case "unpark":
                    this.carManager.unpark(Integer.parseInt(commands[1]));
                    break;
                case "tune":
                    this.carManager.tune(Integer.parseInt(commands[1]),commands[2]);
                    break;
            }

            if (output != null){
                this.outputWriter.writeLine(output);
            }
        }
    }
}
