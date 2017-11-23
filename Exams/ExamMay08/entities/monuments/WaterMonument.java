package ExamMay08.entities.monuments;

import static ExamMay08.utilities.Constants.WATER;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class WaterMonument extends Monument {
    private long waterAffinity;

    public WaterMonument(String name, long waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public long getAffinity() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), WATER, super.getName(), WATER, this.waterAffinity);
    }
}
