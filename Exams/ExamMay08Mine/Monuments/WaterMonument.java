package ExamMay08Mine.Monuments;

public class WaterMonument extends Monument {
    private int waterAffinity;


    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }


    @Override
    public String toString() {
        return String.format("###Water Monument: %s, Water Affinity: %d",this.name,this.waterAffinity);
    }

    @Override
    public double getAffinity() {
        return waterAffinity;
    }
}
