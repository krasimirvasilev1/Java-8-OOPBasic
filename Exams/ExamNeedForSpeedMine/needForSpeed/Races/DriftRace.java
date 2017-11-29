package ExamNeedForSpeedMine.needForSpeed.Races;

import needForSpeed.Cars.Car;
import needForSpeed.Races.Race;

public class DriftRace extends Race {
    public DriftRace(int lenght, String route, int prizePool) {
        super(lenght, route, prizePool);
    }

    @Override
    public void addParticipant(Car car) {
        this.getParticipants().add(car);
    }


}
