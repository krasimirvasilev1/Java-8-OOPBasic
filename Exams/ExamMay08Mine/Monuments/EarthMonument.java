package ExamMay08Mine.Monuments;

public class EarthMonument extends Monument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }



    @Override
    public String toString() {
        return String.format("###Earth Monument: %s, Earth Affinity: %d",this.name,this.earthAffinity);
    }

    @Override
    public double getAffinity() {
        return earthAffinity;
    }
}
