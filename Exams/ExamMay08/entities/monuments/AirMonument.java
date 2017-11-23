package ExamMay08.entities.monuments;

import static ExamMay08.utilities.Constants.AIR;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class AirMonument extends Monument {
    private long airAffinity;

    public AirMonument(String name, long airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public long getAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), AIR, super.getName(), AIR, this.airAffinity);
    }
}
