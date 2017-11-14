package SecondExersiceEncapsulation.FootballTeamGenerator;

public class Player {
    String name;
    StatsOfPlayer stats;
    double averageSkillOfPlayer;

    public String getName() {
        return name;
    }

    public Player(String name, StatsOfPlayer stats) {
        setName(name);
        this.stats = stats;
    }

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public void setAverageSkillOfPlayer(StatsOfPlayer statsOfPlayer) {
        this.averageSkillOfPlayer = statsOfPlayer.averageOfAllStats(statsOfPlayer);
    }

    public double getAverageSkillOfPlayer() {
        return averageSkillOfPlayer;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        else{
            this.name = name;
        }
    }
}
