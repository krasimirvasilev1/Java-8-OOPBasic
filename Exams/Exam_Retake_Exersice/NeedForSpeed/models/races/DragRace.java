package NeedForSpeed.models.races;

import NeedForSpeed.models.cars.Car;

public class DragRace extends Race {
    private int counter;

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
        this.counter = 1;
    }


    @Override
    public String determineRaceWinners() {
        StringBuilder builder = new StringBuilder();
        if (getCars().size() == 0) {
            builder.append("Cannot start the race with zero participants.");
        } else {
            builder.append(super.getRoute() + " - " + super.getLength());
            builder.append(System.lineSeparator());
            this.getCars().entrySet().stream().sorted((x, y) -> SortByPerformancePoints(x.getValue(), y.getValue())).limit(3)
                    .forEach(x -> {
                        int prizeForParticipant = 0;
                        if (this.counter == 1) {
                            prizeForParticipant = (int) (super.getPrizePool() * 0.50);
                        } else if (this.counter == 2) {
                            prizeForParticipant = (int) (super.getPrizePool() * 0.30);
                        } else if (this.counter == 3) {
                            prizeForParticipant = (int) (super.getPrizePool() * 0.20);
                        }
                        builder.append(String.format("%d. %s %s %dPP - $%d%n", this.counter, x.getValue().getBrand(), x.getValue().getModel()
                                , (x.getValue().getHorsePower() / x.getValue().getAcceleration())
                                , prizeForParticipant));

                        this.increaseCounter();

                    });
        }
        return builder.toString().trim();
    }

    private int SortByPerformancePoints(Car value, Car value1) {
        int sortByPerformancePoints = Integer.compare(value1.getHorsePower() / value1.getAcceleration(),value.getHorsePower() / value.getAcceleration());

        return sortByPerformancePoints;
    }

    private void increaseCounter(){
        this.counter++;
    }
}
