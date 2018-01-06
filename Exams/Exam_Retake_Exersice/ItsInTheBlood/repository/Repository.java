package ItsInTheBlood.repository;

import ItsInTheBlood.models.Organism;

import java.util.Map;

public interface Repository {
    Map<String,Organism> getRepository();
}
