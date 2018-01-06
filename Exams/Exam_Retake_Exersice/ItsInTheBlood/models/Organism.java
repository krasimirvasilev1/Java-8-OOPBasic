package ItsInTheBlood.models;

import ItsInTheBlood.models.clusters.Cluster;

import java.util.*;

public class Organism {
    private String name;
    private Map<String,Cluster> clusters;
    private LinkedList<String> clusterIdInOrder;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
        this.clusterIdInOrder = new LinkedList<>();
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }

    public LinkedList<String> getClusterIdInOrder(){ return this.clusterIdInOrder;}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Organism - %s%n",this.name));
        builder.append(String.format("--Clusters: %d%n",this.clusters.size()));
        builder.append(String.format("--Cells: %d%n",this.clusters.entrySet().stream().mapToInt(x -> x.getValue().getNotNullCells().size()).sum()));
        for (String clusterName : this.clusterIdInOrder) {
            builder.append(String.format("----Cluster %s%n",clusterName));
            this.getClusters().get(clusterName).getNotNullCells().stream().sorted((x,y) -> SortCellBySpecificCriteria(x.getPositionRow(),y.getPositionRow(),x.getPositionCol(),y.getPositionCol()))
                    .forEach(x -> {
                        builder.append(String.format("------Cell %s [%d,%d]%n",x.getId(),x.getPositionRow(),x.getPositionCol()));
                        builder.append(String.format("%s%n",x.toString()));
                    });
        }

        return builder.toString().trim();
    }

    private int SortCellBySpecificCriteria(int positionRow, int positionRow1, int positionCol, int positionCol1) {
        int sortedByPositionCol = Integer.compare(positionRow,positionRow1);
        if (sortedByPositionCol != 0){
            return sortedByPositionCol;
        }

        return Integer.compare(positionCol,positionCol1);
    }
}
