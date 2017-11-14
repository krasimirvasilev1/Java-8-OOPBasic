package SecondExersiceEncapsulation.FootballTeamGenerator;

public class StatsOfPlayer {
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public StatsOfPlayer(double endurance, double sprint, double dribble, double passing, double shooting) {
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double getEndurance() {
        return endurance;
    }

    public double getSprint() {
        return sprint;
    }

    public double getDribble() {
        return dribble;
    }

    public double getPassing() {
        return passing;
    }

    public double getShooting() {
        return shooting;
    }

    private void setEndurance(double endurance) {
        if (endurance >= 0 && endurance <= 100) {
            this.endurance = endurance;
        } else {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(double sprint) {
        if (sprint >= 0 && sprint <= 100) {
            this.sprint = sprint;
        } else {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
    }

    private void setDribble(double dribble) {
        if (dribble >= 0 && dribble <= 100) {
            this.dribble = dribble;
        } else {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
    }

    private void setPassing(double passing) {
        if (passing >= 0 && passing <= 100) {
            this.passing = passing;
        } else {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
    }

    private void setShooting(double shooting) {
        if (shooting >= 0 && shooting <= 100) {
            this.shooting = shooting;
        } else {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
    }

    public double averageOfAllStats(StatsOfPlayer statsOfPlayer) {
        return (statsOfPlayer.getDribble() + statsOfPlayer.getEndurance()
                + statsOfPlayer.getPassing() + statsOfPlayer.getShooting()
                + statsOfPlayer.getSprint()) / 5;
    }
}
