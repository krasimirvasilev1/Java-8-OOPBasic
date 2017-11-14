package SecondExersiceEncapsulation.PizzaCalories;

public class Dough {
    String doughType;
    String doughBakingTechnique;
    double doughWeight;

    public Dough(String doughType, String doughBakingTechnique,double doughWeight) {
        setDoughType(doughType);
        setDoughBakingTechnique(doughBakingTechnique);
        setDoughWeight(doughWeight);
    }

    public Dough() {
    }

    public void setDoughType(String doughType) {
        if (doughType.equalsIgnoreCase("white") || doughType.equalsIgnoreCase("wholegrain")){
            this.doughType = doughType;
        }
        else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setDoughBakingTechnique(String doughBakingTechnique) {
        if (doughBakingTechnique.equalsIgnoreCase("crispy") || doughBakingTechnique.equalsIgnoreCase("chewy")
            || doughBakingTechnique.equalsIgnoreCase("homemade")){
            this.doughBakingTechnique = doughBakingTechnique;
        }
        else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setDoughWeight(double doughWeight) {
        if (doughWeight >= 1 && doughWeight <= 200){
            this.doughWeight = doughWeight;
        }
        else{
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private double caloriesOfTheDough(String doughType,String doughBakingTechnique,double doughWeight){
        double modifierType = 0;
        double bakingModifier = 0;
        switch(doughType.toLowerCase()){
            case "white":
                modifierType = 1.5;
                break;
            case "wholegrain":
                modifierType = 1.0;
                break;
        }
        switch(doughBakingTechnique.toLowerCase()){
            case "crispy":
                bakingModifier = 0.9;
                break;
            case "chewy":
                bakingModifier = 1.1;
                break;
            case "homemade":
                bakingModifier = 1.0;
                break;
        }

        return (2 * doughWeight) * modifierType * bakingModifier;
    }

    public double getCaloriesOfDough (Dough dough){
        return caloriesOfTheDough(this.doughType,this.doughBakingTechnique,this.doughWeight);
    }
}
