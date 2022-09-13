package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, Trainer> trainerByName = new LinkedHashMap<>();
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        getPockemonTrainer(input);
        getPokemonElement(input);
        print();
    }

    private static void getPokemonElement(Scanner in) {
        String element = in.nextLine();
        while (!"End".equals(element)) {
            checkPokemonsElement(element);
            element = in.nextLine();
        }
    }

    private static void print() {
        trainerByName.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .forEach(t -> System.out.println(t));
    }

    private static void checkPokemonsElement(String element) {
        for (Trainer trainer : trainerByName.values()) {
            List<Pokemon> pokemons = trainer.getPokemons();

            boolean hasFound = false;
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getElement().equals(element)) {
                    hasFound = true;
                    break;
                }
            }

            if (hasFound) {
                trainer.increaseBadges();
            } else {
                trainer.attackPokemons();
            }
        }
    }

    private static void getPockemonTrainer(Scanner input) {
        String command = input.nextLine();
        while (!"Tournament".equals(command)) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainerByName.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);

                trainerByName.put(trainerName, trainer);
            } else {
                Trainer trainer = trainerByName.get(trainerName);
                trainer.addPokemon(pokemon);

                trainerByName.put(trainerName, trainer);
            }

            command = input.nextLine();
        }
    }
}
