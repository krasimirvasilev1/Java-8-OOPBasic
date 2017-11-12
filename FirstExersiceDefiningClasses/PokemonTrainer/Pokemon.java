package FirstExersiceDefiningClasses.PokemonTrainer;

public class Pokemon {
    String name;
    String element;
    int health;

    public String getElement() {
        return element;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Pokemon(String name) {
        this.name = name;
    }
    public Pokemon(String name, String element, int health) {
        this(name);
        this.element = element;
        this.health = health;
    }
}
