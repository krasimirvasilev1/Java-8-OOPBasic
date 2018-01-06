package retake_exam_javaOOPBasicReal.models.colonists;

public abstract class Medic extends Colonist{
    private String sign;

    protected Medic(String id, String familyId, int talant, int age, String sign) {
        super(id, familyId, talant, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
