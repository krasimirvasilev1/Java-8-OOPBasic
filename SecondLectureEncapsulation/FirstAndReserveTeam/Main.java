package SecondLectureEncapsulation.FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPlayers = Integer.parseInt(console.readLine());
        Team team = new Team("Geo Milev FC",new ArrayList<>(),new ArrayList<>());
        for (int i = 0; i < numberOfPlayers; i++) {
            String [] info = console.readLine().split("\\s+");
            Person person = new Person(info[0],info[1],Integer.parseInt(info[2]),Double.parseDouble(info[3]));
            team.addPlayers(person);
        }

        System.out.println("First team have "+team.getFirstTeam().size()+" players");
        System.out.println("Reserve team have "+team.getSecondTeam().size()+" players");
    }
}
