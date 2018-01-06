package retake_exam_javaOOPBasicReal.models.colonists;

public class Soldier extends Colonist{

    public Soldier(String id, String familyId, int talant, int age) {
        super(id, familyId, talant, age);
    }

    @Override
    public int getPotential() {
        return super.getTalant() + 3 + 3;
    }
}
