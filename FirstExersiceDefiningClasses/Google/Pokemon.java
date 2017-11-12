package FirstExersiceDefiningClasses.Google;

public class Pokemon {
    String pokemonName;
    String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public Pokemon() {
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n",getPokemonName(),getPokemonType());
    }
}
