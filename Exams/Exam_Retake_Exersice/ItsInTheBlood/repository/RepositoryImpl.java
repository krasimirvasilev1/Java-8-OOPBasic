package ItsInTheBlood.repository;

import ItsInTheBlood.models.Organism;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {
    private Map<String,Organism> repo;

    public RepositoryImpl() {
        this.repo = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Organism> getRepository() {
        return this.repo;
    }
}
