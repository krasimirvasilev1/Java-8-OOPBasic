package SecondExersiceEncapsulation.FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Team> allTeams = new HashMap<>();
        while (true) {
            String command = console.readLine();
            if ("end".equalsIgnoreCase(command)) {
                break;
            }
            String[] input = command.split(";");
            String word = input[0];
            String teamName = input[1];
            Team team = new Team();
            try {
                switch (word) {
                    case "Team":
                        team = new Team(teamName, new ArrayList<>());
                        allTeams.put(teamName, team);
                        break;
                    case "Rating":
                        if (allTeams.containsKey(teamName)) {
                            System.out.printf("%s - %.0f%n", teamName, allTeams.get(teamName).averageStatsOfAllPlayers(allTeams.get(teamName)));
                        } else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                        break;
                    case "Remove":
                        String playerName = input[2];
                        if (allTeams.containsKey(teamName)) {
                            Player player = new Player(playerName);
                            allTeams.get(teamName).removePlayer(player, teamName);
                        }
                        break;
                    case "Add":
                        if (allTeams.containsKey(teamName)) {
                            StatsOfPlayer statsOfPlayer = new StatsOfPlayer(Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]), Integer.parseInt(input[7]));
                            Player player = new Player(input[2], statsOfPlayer);
                            player.setAverageSkillOfPlayer(statsOfPlayer);
                            allTeams.get(teamName).addPlayer(player);
                        } else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}