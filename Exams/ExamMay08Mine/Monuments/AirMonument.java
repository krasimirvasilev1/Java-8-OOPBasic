package ExamMay08Mine.Monuments;

public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Air Monument: %s, Air Affinity: %d",this.name,this.airAffinity);
    }

    @Override
    public double getAffinity() {
        return airAffinity;
    }
}
