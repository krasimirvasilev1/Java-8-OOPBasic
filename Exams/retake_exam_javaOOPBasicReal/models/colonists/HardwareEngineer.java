package retake_exam_javaOOPBasicReal.models.colonists;

public class HardwareEngineer extends Engineer{

    public HardwareEngineer(String id, String familyId, int talant, int age) {
        super(id, familyId, talant, age);
    }

    @Override
    public int getPotential() {
        int allEngineersBonus = 0;
        if (super.getAge() > 30){
            allEngineersBonus += 2;
        }
        else if (super.getAge() < 18){
            allEngineersBonus += 2;
        }
        return super.getTalant() + 3 + allEngineersBonus;
    }
}
