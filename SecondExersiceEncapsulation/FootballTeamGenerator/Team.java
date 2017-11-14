package SecondExersiceEncapsulation.FootballTeamGenerator;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Team {
    String name;
    List<Player> allPlayers;

    public Team(String name, List<Player> allPlayers) {
        setName(name);
        this.allPlayers = allPlayers;
    }

    public Team() {
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public void addPlayer(Player player) {
        this.allPlayers.add(player);
    }

    public void removePlayer(Player player,String teamName) {
        Player newPlayer = new Player();
        for (Player currPlayer : this.allPlayers) {
            if (currPlayer.getName().equals(player.getName())) {
                newPlayer = currPlayer;
                break;
            }
        }
        if (this.allPlayers.contains(newPlayer)) {
            this.allPlayers.remove(newPlayer);
        } else {
            throw new IllegalArgumentException("Player " + player.getName() + " is not in "+teamName+" team.");
        }
    }

    public double averageStatsOfAllPlayers(Team team) {
        OptionalDouble averageRating = team.getAllPlayers().stream().mapToDouble(x -> x.getAverageSkillOfPlayer()).average();
        if (averageRating.isPresent()) {
           return averageRating.getAsDouble();
        } else {
            return 0;
        }
    }
}
