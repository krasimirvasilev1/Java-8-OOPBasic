package ThirdExersiceInheritance.MordorsCrueltyPlan;

public class GandalfTheGray extends CalcGandalfMood{
    int happinessPoints;
    String currMood;

    public GandalfTheGray(String[] foods) {
        this.happinessPoints = super.CalcGandalfHappiness(foods);
        this.currMood = super.calcGandalfMood(this.happinessPoints);
    }

    @Override
    public String toString() {
        return String.format("%d%n%s",this.happinessPoints,this.currMood);
    }
}
