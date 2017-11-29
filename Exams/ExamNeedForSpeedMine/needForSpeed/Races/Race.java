package ExamNeedForSpeedMine.needForSpeed.Races;


import needForSpeed.Cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    private int lenght;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int lenght, String route, int prizePool) {
        this.lenght = lenght;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public int getLenght() {
        return lenght;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public abstract void addParticipant(Car car);



}
