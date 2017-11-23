package ExamMay08.factories;

import ExamMay08.entities.monuments.*;

import static ExamMay08.utilities.Constants.*;

public final class MonumentFactory {

    private MonumentFactory() {}

    public static Monument makeMonument(String type, String name, long affinity) {
        switch (type) {
            case AIR:
                return new AirMonument(name, affinity);
            case WATER:
                return new WaterMonument(name, affinity);
            case FIRE:
                return new FireMonument(name, affinity);
            case EARTH:
                return new EarthMonument(name, affinity);
            default:
                return null;
        }
    }
}
