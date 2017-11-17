package ThirdLectureInheritance.FragileBaseClass;

import java.util.ArrayList;


public class Animal {
    protected ArrayList<Food> foodEaten;

    public Animal(ArrayList<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food [] foods){
        for (Food food : foods) {
            this.eat(food);
        }
    }
}
