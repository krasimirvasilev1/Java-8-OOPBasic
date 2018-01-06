package retake_exam_javaOOPBasicReal.models.colonists;

public class SoftwareEngineer extends Engineer{

    public SoftwareEngineer(String id, String familyId, int talant, int age) {
        super(id, familyId, talant, age);
    }

    @Override
    public int getPotential() {
        int allEngineersBonus = 2;
        if (super.getAge() > 30){
            allEngineersBonus += 2;
        }
        return super.getTalant() + 3 + allEngineersBonus;
    }
}
