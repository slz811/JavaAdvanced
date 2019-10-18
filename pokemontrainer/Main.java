package pokemontrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();


        String line = scanner.nextLine();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            //<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
            Trainer trainer = new Trainer(tokens[0]);
            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3]));

            trainers.putIfAbsent(tokens[0], trainer);
            trainers.get(tokens[0]).addPokemon(pokemon);

            line = scanner.nextLine();
        }


        line = scanner.nextLine();
        while (!line.equals("End")) {

            playElement(trainers, line);

            line = scanner.nextLine();
        }


        trainers.values().stream()
                .sorted((f, s) -> Integer.compare(s.getBadges(), f.getBadges()))
                .forEach(trainer -> System.out.println(trainer.toString()));
    }

    private static void playElement(Map<String, Trainer> trainers, String element) {
        for (Trainer trainer : trainers.values()) {
            if (trainer.hasPokemonType(element)) {
                trainer.addBadges(1);
            } else {
                trainer.damagePokemons(10);
            }
        }
    }
}

