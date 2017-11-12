package FirstExersiceDefiningClasses.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (true) {
            String input = console.readLine();
            if (input.equals("Tournament")) {
                break;
            }
            String[] info = input.split(" ");
            String trainerName = info[0];
            String pokemonName = info[1];
            String pokemonElement = info[2];
            int pokemonHealth = Integer.parseInt(info[3]);

            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).pokemons.add(pokemon);
            } else {
                List<Pokemon> newList = new ArrayList<>();
                trainer.setPokemons(newList);
                trainers.put(trainerName, trainer);
                trainers.get(trainerName).pokemons.add(pokemon);
            }
        }

        while (true) {
            String element = console.readLine();
            if (element.equals("End")){
                break;
            }
            for (String s : trainers.keySet()) {
                Trainer trainer = trainers.get(s);
                List<Pokemon> pokemonsPerTrainer = trainer.getPokemons();
                int counter = 0;
                for (Pokemon pokemon : pokemonsPerTrainer) {
                    if (pokemon.getElement().equals(element)){
                        counter++;
                    }
                }
                if (counter > 0){
                    trainer.setNumberOfBadges(1);
                }
                else{
                    for (Pokemon pokemon : pokemonsPerTrainer) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                    }
                }
                List<Pokemon> newListOfPokemons = pokemonsPerTrainer.stream().filter(x -> x.getHealth() > 0).collect(Collectors.toList());
                trainer.setPokemons(newListOfPokemons);
                trainers.put(s,trainer);
            }
        }

        Stream<Map.Entry<String,Trainer>> sortedMap = trainers.entrySet().stream().sorted((x,y) -> Double.compare(y.getValue().getNumberOfBadges(),x.getValue().getNumberOfBadges()));
                sortedMap.forEach(x -> System.out.println(x.getValue()));
    }
}
