package ExamMay08;

import ExamMay08.core.GameManager;
import ExamMay08.engines.Engine;
import ExamMay08.io.ConsoleInputReader;
import ExamMay08.io.ConsoleOutputWriter;
import ExamMay08.utilities.InputParser;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        GameManager gameManager = new GameManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, gameManager);

        engine.run();
    }
}
