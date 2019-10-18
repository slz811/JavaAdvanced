package pokemontrainer;

public class Pokemon {
    //  Pokemon has a name, an element and health, all values are mandatory.
    private String pokemonName;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String element, int health) {
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }

    public void looseHealth(int health) {
        this.health -= health;
    }

    public int getHealth() {
        return health;
    }

    public String getElement() {
        return this.element;
    }
}
