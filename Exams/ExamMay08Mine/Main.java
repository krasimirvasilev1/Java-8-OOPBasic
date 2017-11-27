package ExamMay08Mine;

import ExamMay08Mine.Engine.CommandControler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CommandControler nations = new CommandControler();
        while(true){
            String[] input = console.readLine().split("\\s+");
            nations.commands(input);
            if (input[0].equalsIgnoreCase("Quit")){
                break;
            }
        }
    }
}
