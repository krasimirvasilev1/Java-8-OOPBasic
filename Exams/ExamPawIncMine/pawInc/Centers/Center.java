package ExamPawIncMine.pawInc.Centers;

import ExamPawIncMine.pawInc.Animals.Animal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Center {
    private String name;
    private Map<String,List<Animal>> animals;

    protected Center(String name) {
        this.name = name;
        this.animals = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<Animal>> getAnimals() {
        return animals;
    }

    public void setAnimals(LinkedHashMap<String, List<Animal>> animals) {
        this.animals = animals;
    }
}
