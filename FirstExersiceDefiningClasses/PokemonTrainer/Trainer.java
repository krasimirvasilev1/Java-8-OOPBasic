package FirstExersiceDefiningClasses.PokemonTrainer;

import java.util.List;

public class Trainer {
    String name;
    int numberOfBadges = 0;
    List<Pokemon> pokemons;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = this.numberOfBadges + numberOfBadges;
    }

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.name,getNumberOfBadges(),getPokemons().size());
    }
}
