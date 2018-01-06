package retake_exam_javaOOPBasicReal.models.colonists;

public class Surgeon extends Medic{

    public Surgeon(String id, String familyId, int talant, int age, String sign) {
        super(id, familyId, talant, age, sign);
    }

    @Override
    public int getPotential() {
        int allMedicsBonus = 2;
        if(super.getAge() > 25 && super.getAge() < 35){
            allMedicsBonus += 2;
        }

        if (super.getSign().equals("precise")){
            allMedicsBonus += 3;
        }
        else if (super.getSign().equals("butcher")){
            allMedicsBonus -= 3;
        }

        return super.getTalant() + allMedicsBonus;
    }
}
