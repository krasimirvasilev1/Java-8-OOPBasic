package ExamMay08Mine.Monuments;

public class FireMonument extends Monument {
    private int fireAffinity;


    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }


    @Override
    public String toString() {
        return String.format("###Fire Monument: %s, Fire Affinity: %d",this.name,this.fireAffinity);
    }

    @Override
    public double getAffinity() {
        return fireAffinity;
    }
}
