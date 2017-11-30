package ExamPawIncMine.pawInc;

import ExamPawIncMine.pawInc.Animals.Animal;
import ExamPawIncMine.pawInc.Animals.Cat;
import ExamPawIncMine.pawInc.Animals.Dog;
import ExamPawIncMine.pawInc.Centers.AdoptionCenter;
import ExamPawIncMine.pawInc.Centers.CastrationCenter;
import ExamPawIncMine.pawInc.Centers.Center;
import ExamPawIncMine.pawInc.Centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private Map<String, Map<String, List<Animal>>> cleansingCenters;
    private Map<String, List<Animal>> adoptionCenters;
    private Map<String, Map<String, List<Animal>>> castrationCenters;
    private List<String> adoptedAnimals;
    private List<String> cleansedAnimals;
    private List<String> castratedAnimals;

    public AnimalCenterManager() {
        this.cleansingCenters = new LinkedHashMap<>();
        this.adoptionCenters = new LinkedHashMap<>();
        this.castrationCenters = new LinkedHashMap<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        Center newCleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.put(newCleansingCenter.getName(), newCleansingCenter.getAnimals());
    }

    public void registerAdoptionCenter(String name) {
        Center newAdoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.put(name, new ArrayList<>());
    }

    public void registerCastrationCenter(String name) {
        Center newCastrationCenter = new CastrationCenter(name);
        this.castrationCenters.put(newCastrationCenter.getName(), newCastrationCenter.getAnimals());
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal newDog = new Dog(name, age, learnedCommands);
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            this.adoptionCenters.get(adoptionCenterName).add(newDog);
        }
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Animal newCat = new Cat(name, age, intelligenceCoefficient);
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            this.adoptionCenters.get(adoptionCenterName).add(newCat);
        }
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            if (this.cleansingCenters.containsKey(cleansingCenterName)) {
                List<Animal> allUnCleansedAnimals = this.adoptionCenters.get(adoptionCenterName).stream().filter(x -> x.getCleansingStatus().equalsIgnoreCase("UNCLEANSED")).collect(Collectors.toList());
                List<Animal> allCleanedAnimals = this.adoptionCenters.get(adoptionCenterName).stream().filter(x -> x.getCleansingStatus().equalsIgnoreCase("CLEANSED")).collect(Collectors.toList());
                this.adoptionCenters.get(adoptionCenterName).clear();
                this.adoptionCenters.get(adoptionCenterName).addAll(allCleanedAnimals);

                if (this.cleansingCenters.get(cleansingCenterName).containsKey(adoptionCenterName)) {
                    this.cleansingCenters.get(cleansingCenterName).get(adoptionCenterName).addAll(allUnCleansedAnimals);
                } else {
                    this.cleansingCenters.get(cleansingCenterName).put(adoptionCenterName, new ArrayList<>());
                    this.cleansingCenters.get(cleansingCenterName).get(adoptionCenterName).addAll(allUnCleansedAnimals);
                }
            }
        }
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            if (this.castrationCenters.containsKey(castrationCenterName)) {
                List<Animal> allUnCleanedAnimals = this.adoptionCenters.get(adoptionCenterName).stream().filter(x -> x.getCleansingStatus().equalsIgnoreCase("UNCLEANSED")).collect(Collectors.toList());
                List<Animal> allCleanedAnimals = this.adoptionCenters.get(adoptionCenterName).stream().filter(x -> x.getCleansingStatus().equalsIgnoreCase("CLEANSED")).collect(Collectors.toList());
                this.adoptionCenters.get(adoptionCenterName).clear();
                this.adoptionCenters.get(adoptionCenterName).addAll(allCleanedAnimals);

                if (this.castrationCenters.get(castrationCenterName).containsKey(adoptionCenterName)) {
                    this.castrationCenters.get(castrationCenterName).get(adoptionCenterName).addAll(allUnCleanedAnimals);
                } else {
                    this.castrationCenters.get(castrationCenterName).put(adoptionCenterName, new ArrayList<>());
                    this.castrationCenters.get(castrationCenterName).get(adoptionCenterName).addAll(allUnCleanedAnimals);
                }
            }
        }
    }

    public void cleanse(String cleansingCenterName) {
        if (this.cleansingCenters.containsKey(cleansingCenterName)) {
            for (String adoptionCenter : this.cleansingCenters.get(cleansingCenterName).keySet()) {
                for (Animal animal : this.cleansingCenters.get(cleansingCenterName).get(adoptionCenter)) {
                    animal.setCleansingStatus("CLEANSED");
                    this.cleansedAnimals.add(animal.getName());
                }
                this.adoptionCenters.get(adoptionCenter).addAll(this.cleansingCenters.get(cleansingCenterName).get(adoptionCenter));
                this.cleansingCenters.get(cleansingCenterName).get(adoptionCenter).clear();
            }
        }
    }

    public void castrate(String castrationCenterName) {
        if (this.castrationCenters.containsKey(castrationCenterName)) {
            for (String adoptionCenter : this.castrationCenters.get(castrationCenterName).keySet()) {
                for (Animal animal : this.castrationCenters.get(castrationCenterName).get(adoptionCenter)) {
                    this.castratedAnimals.add(animal.getName());
                }
                this.adoptionCenters.get(adoptionCenter).addAll(this.castrationCenters.get(castrationCenterName).get(adoptionCenter));
                this.castrationCenters.get(castrationCenterName).get(adoptionCenter).clear();
            }
        }
    }

    public void adopt(String adoptionCenterName) {
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            for (Animal animal : adoptionCenters.get(adoptionCenterName)) {
                if (animal.getCleansingStatus().equalsIgnoreCase("CLEANSED")) {
                    this.adoptedAnimals.add(animal.getName());
                }
            }
            this.adoptionCenters.put(adoptionCenterName, this.adoptionCenters.get(adoptionCenterName).stream().filter(x -> x.getCleansingStatus().equalsIgnoreCase("UNCLEANSED")).collect(Collectors.toList()));
        }
    }

    public void printStatistics() {
        int animalsAwaitingAdoption = 0;
        int animalsAwaitingCleansing = 0;
        for (String cleaningCenterName : this.cleansingCenters.keySet()) {
            for (String adoptionCenterName : this.cleansingCenters.get(cleaningCenterName).keySet()) {
                for (Animal animal : this.cleansingCenters.get(cleaningCenterName).get(adoptionCenterName)) {
                    if (animal.getCleansingStatus().equalsIgnoreCase("UNCLEANSED")) {
                        animalsAwaitingCleansing++;
                    }
                }
            }
        }
        for (String adoptionCenterName : this.adoptionCenters.keySet()) {
            for (Animal animal : this.adoptionCenters.get(adoptionCenterName)) {
                if (animal.getCleansingStatus().equalsIgnoreCase("CLEANSED")) {
                    animalsAwaitingAdoption++;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Paw Incorporative Regular Statistics%n"));
        builder.append(String.format("Adoption Centers: %d%n", this.adoptionCenters.size()));
        builder.append(String.format("Cleansing Centers: %d%n", this.cleansingCenters.size()));
        if (this.adoptedAnimals.isEmpty()) {
            builder.append(String.format("Adopted Animals: None%n"));
        } else {
            builder.append(String.format("Adopted Animals: %s%n", String.join(", ", this.adoptedAnimals.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()))));

        }
        if (this.cleansedAnimals.isEmpty()) {
            builder.append(String.format("Cleansed Animals: None%n"));
        } else {
            builder.append(String.format("Cleansed Animals: %s%n", String.join(", ", this.cleansedAnimals.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()))));

        }
        builder.append(String.format("Animals Awaiting Adoption: %d%n", animalsAwaitingAdoption));
        builder.append(String.format("Animals Awaiting Cleansing: %d%n", animalsAwaitingCleansing));

        System.out.print(builder.toString());
    }

    public void castrationStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Paw Inc. Regular Castration Statistics%n"));
        builder.append(String.format("Castration Centers: %s%n", this.castrationCenters.size()));
        if (this.castratedAnimals.isEmpty()) {
            builder.append(String.format("Castrated Animals: None%n"));
        } else {
            builder.append(String.format("Castrated Animals: %s%n", String.join(", ", this.castratedAnimals.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()))));
        }
        System.out.print(builder.toString());
    }
}
