package retake_exam_javaOOPBasicReal.models.colonists;

public class GeneralPractitioner extends Medic{
    public GeneralPractitioner(String id, String familyId, int talant, int age, String sign) {
        super(id, familyId, talant, age, sign);
    }

    @Override
    public int getPotential() {
        int allMedicsBonus = 2;
        if (super.getAge() > 15){
            allMedicsBonus += 1;
        }

        if (super.getSign().equals("caring")){
            allMedicsBonus += 1;
        }
        else if (super.getSign().equals("careless")){
            allMedicsBonus -= 2;
        }

        return super.getTalant() + allMedicsBonus;
    }
}
