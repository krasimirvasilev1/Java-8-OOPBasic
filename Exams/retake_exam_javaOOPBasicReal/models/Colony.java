package retake_exam_javaOOPBasicReal.models;

import retake_exam_javaOOPBasicReal.models.colonists.Colonist;

import java.util.*;
import java.util.stream.Collectors;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Map<String, Colonist>> colonyMembers;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.colonyMembers = new LinkedHashMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public void addColonist(Colonist colonist) {
        if (this.colonyMembers.containsKey(colonist.getFamilyId())) {
            if (this.colonyMembers.get(colonist.getFamilyId()).size() == maxFamilyCapacity) {
                System.out.println("family is full");
                return;
            }
            this.colonyMembers.get(colonist.getFamilyId()).put(colonist.getId(), colonist);
        } else {
            if (this.colonyMembers.size() == this.maxFamilyCount) {
                System.out.println("colony is full");
                return;
            }
            this.colonyMembers.put(colonist.getFamilyId(), new LinkedHashMap<>());
            this.colonyMembers.get(colonist.getFamilyId()).put(colonist.getId(), colonist);
        }
    }

    public void removeColonist(String familyId, String memberId) {
        if (this.colonyMembers.containsKey(familyId)) {
            if (this.colonyMembers.get(familyId).containsKey(memberId)) {
                this.colonyMembers.get(familyId).remove(memberId);

                if (this.colonyMembers.get(familyId).isEmpty()) {
                    this.colonyMembers.remove(familyId);
                }
            }
        }
    }

    public void removeFamily(String id) {
        if (this.colonyMembers.containsKey(id)) {
            this.colonyMembers.remove(id);
        }
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (this.colonyMembers.containsKey(familyId)) {
            List<Colonist> colonistsPerFamily = new ArrayList<>();
            for (Map.Entry<String, Colonist> stringColonistEntry : this.colonyMembers.get(familyId).entrySet()) {
                colonistsPerFamily.add(stringColonistEntry.getValue());
            }

            List<Colonist> sortedColonistsPerFamily = colonistsPerFamily.stream().sorted(Comparator.comparing(Colonist::getId)).collect(Collectors.toList());

            return sortedColonistsPerFamily;
        } else {
            return null;
        }
    }

    public void grow(int years) {
        for (Map.Entry<String, Map<String, Colonist>> stringMapEntry : colonyMembers.entrySet()) {
            for (Map.Entry<String, Colonist> stringColonistEntry : stringMapEntry.getValue().entrySet()) {
                stringColonistEntry.getValue().grow(years);
            }
        }
    }

    public int getPotential() {
        int colonyPotential = 0;
        for (Map.Entry<String, Map<String, Colonist>> stringMapEntry : colonyMembers.entrySet()) {
            for (Map.Entry<String, Colonist> stringColonistEntry : stringMapEntry.getValue().entrySet()) {
                colonyPotential += stringColonistEntry.getValue().getPotential();
            }
        }

        return colonyPotential;
    }

    public String getCapacity() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("families: %d/%d%n", this.colonyMembers.size(), maxFamilyCount));
        this.colonyMembers.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x -> builder.append(String.format("-%s: %d/%d%n", x.getKey(), this.colonyMembers.get(x.getKey()).size(), this.maxFamilyCapacity)));

        return builder.toString().trim();
    }
}
