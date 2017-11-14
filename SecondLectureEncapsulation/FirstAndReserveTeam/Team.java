package SecondLectureEncapsulation.FirstAndReserveTeam;

import java.util.Collections;
import java.util.List;

public class Team {
    String name;
    List<Person> firstTeam;
    List<Person> secondTeam;

    public Team(String name, List<Person> firstTeam, List<Person> secondTeam) {
        this.name = name;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getSecondTeam() {
        return Collections.unmodifiableList(secondTeam);
    }

    public void addPlayers (Person person){
        if (person.getAge() < 40){
            firstTeam.add(person);
        }
        else{
            secondTeam.add(person);
        }
    }
}
