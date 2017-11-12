package FirstExersiceDefiningClasses.Google;

import java.util.List;

public class Person {
    String name;
    Company company;
    List<Pokemon> pokemons;
    List<Parents> parents;
    List<Children> childrenList;
    Car car;

    public Person(List<Pokemon> pokemons, List<Parents> parents, List<Children> childrenList) {
        this.pokemons = pokemons;
        this.parents = parents;
        this.childrenList = childrenList;
    }

    public Person() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
       StringBuilder output = new StringBuilder();
       String name = String.format("%s%n",getName());
       output.append(name);
       String company = "";
        if (getCompany() == null){
            company = String.format("Company:%n");
        }
        else{
            company = String.format("Company:%n%s %s %.2f%n",getCompany().getCompanyName(),getCompany().getDepartment(),getCompany().getSalary());
        }
        output.append(company);
        String car = "";
        if (getCar() == null){
            car = String.format(("Car:%n"));
        }
        else{
            car = String.format("Car:%n%s %d%n",getCar().getCarModel(),getCar().getCarSpeed());
        }
        output.append(car);
        return output.toString();
    }
}
