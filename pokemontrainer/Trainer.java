package pokemontrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    // Trainer has a name, number of badges and a collection of pokemon.
    private String trainerName;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public int getBadges() {
        return this.badges;
    }

    public void addBadges(int badges) {
        this.badges += badges;
    }

    public void damagePokemons(int damage) {
        this.pokemons.stream().forEach(pokemon -> pokemon.looseHealth(damage));
        killPokemon();
    }

    private void killPokemon() {
        this.pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public boolean hasPokemonType(String element) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.trainerName, this.badges, this.pokemons.size());
    }
}
