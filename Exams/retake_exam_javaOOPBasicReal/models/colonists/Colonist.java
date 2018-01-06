package retake_exam_javaOOPBasicReal.models.colonists;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talant;
    private int age;

    protected Colonist(String id, String familyId, int talant, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talant = talant;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    protected int getTalant() {
        return this.talant;
    }

    protected int getAge() {
        return this.age;
    }

    public abstract int getPotential();

    public void grow(int years){
        this.age += years;
    }
}
