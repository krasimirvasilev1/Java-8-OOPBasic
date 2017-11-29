package ExamNeedForSpeedMine.needForSpeed.Races;

import needForSpeed.Cars.Car;
import needForSpeed.Races.Race;

public class CasualRace extends Race {
    public CasualRace(int lenght, String route, int prizePool) {
        super(lenght, route, prizePool);
    }

    @Override
    public void addParticipant(Car car) {
        this.getParticipants().add(car);
    }



}
