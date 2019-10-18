package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    Car car;
    List<Pokemon> pokemons;
    List<Parent> parents;
    List<Child> children;

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.car = new Car();
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setCompany(Company company) {
        this.company = company;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParents(Parent parent) {
        this.parents.add(parent);
    }

    public void addChildren(Child child) {
        this.children.add(child);
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName());
        builder.append(System.getProperty("line.separator"));

        builder.append("Company:");
        builder.append(System.getProperty("line.separator"));
        if (company.getName() != null) {
            builder.append(company.toString());
        }

        builder.append("Car:");
        builder.append(System.getProperty("line.separator"));
        if (car.getModel() != null) {
            builder.append(car.toString());
        }

        builder.append("Pokemon:");
        builder.append(System.getProperty("line.separator"));
        if (!pokemons.isEmpty()) {
            for (Pokemon pokemon : pokemons) {
                builder.append(pokemon.toString());
            }
        }

        builder.append("Parents:");
        builder.append(System.getProperty("line.separator"));
        if (!parents.isEmpty()) {
            for (Parent parent : parents) {
                builder.append(parent.toString());
            }
        }

        builder.append("Children:");
        builder.append(System.getProperty("line.separator"));
        if (!children.isEmpty()) {
            for (Child child : children) {
                builder.append(child.toString());
            }
        }
        return builder.toString();
    }
}
