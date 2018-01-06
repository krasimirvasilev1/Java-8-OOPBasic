package ItsInTheBlood;

import ItsInTheBlood.controllers.HealthManager;
import ItsInTheBlood.interfaces.InputReader;
import ItsInTheBlood.interfaces.OutputWriter;
import ItsInTheBlood.io.InputReaderImpl;
import ItsInTheBlood.io.OutputWriterImpl;

import java.io.IOException;

public class Engine {
    private HealthManager healthManager;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public Engine() {
        this.healthManager = new HealthManager();
        this.inputReader = new InputReaderImpl();
        this.outputWriter = new OutputWriterImpl();
    }

    public void run() throws IOException {
        while (true) {
            String input = inputReader.readLine();
            if ("BEER IS COMING".equals(input)) {
                break;
            }

            String[] commands = input.split("\\s+");

            String result;
            switch (commands[0]) {
                case "checkCondition":
                    result = this.healthManager.checkCondition(commands[1]);
                    break;
                case "createOrganism":
                    result = this.healthManager.createOrganism(commands[1]);
                    break;
                case "addCluster":
                    result = this.healthManager.addCluster(commands[1], commands[2], Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));
                    break;
                case "addCell":
                    result = this.healthManager.addCell(commands[1], commands[2], commands[3], commands[4], Integer.parseInt(commands[5]), Integer.parseInt(commands[6]), Integer.parseInt(commands[7]), Integer.parseInt(commands[8]));
                    break;
                case "activateCluster":
                    result = this.healthManager.activateCluster(commands[1]);
                    break;
                default:
                    result = null;
                    break;
            }

            if (result != null) {
                this.outputWriter.printLine(result);
            }
        }
    }
}
