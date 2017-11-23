package ExamMay08.factories;

import ExamMay08.entities.benders.*;

import static ExamMay08.utilities.Constants.*;

public final class BenderFactory {

    private BenderFactory() {}

    public static Bender makeBender(String type, String name, long power, double secondaryParameter) {
        switch (type) {
            case AIR:
                return new AirBender(name, power, secondaryParameter);
            case WATER:
                return new WaterBender(name, power, secondaryParameter);
            case FIRE:
                return new FireBender(name, power, secondaryParameter);
            case EARTH:
                return new EarthBender(name, power, secondaryParameter);
            default:
                return null;
        }
    }
}
