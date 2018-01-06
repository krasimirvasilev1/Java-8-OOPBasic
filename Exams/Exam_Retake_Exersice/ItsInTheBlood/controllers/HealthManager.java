package ItsInTheBlood.controllers;

import ItsInTheBlood.models.Cell;
import ItsInTheBlood.models.Organism;
import ItsInTheBlood.models.blood_cells.RedBloodCell;
import ItsInTheBlood.models.blood_cells.WhiteBloodCell;
import ItsInTheBlood.models.clusters.Cluster;
import ItsInTheBlood.models.microbes.Bacteria;
import ItsInTheBlood.models.microbes.Fungi;
import ItsInTheBlood.models.microbes.Virus;
import ItsInTheBlood.repository.Repository;
import ItsInTheBlood.repository.RepositoryImpl;

public class HealthManager {
    private Repository repository;

    public HealthManager() {
        this.repository = new RepositoryImpl();
    }

    public String checkCondition(String organismName) {
        if (this.repository.getRepository().containsKey(organismName)) {
            return this.repository.getRepository().get(organismName).toString();
        }

        return null;
    }

    public String createOrganism(String name) {
        if (this.repository.getRepository().containsKey(name)) {
            return "Organism " + name + " already exists";
        } else {
            this.repository.getRepository().put(name, new Organism(name));
            return String.format("Created organism %s", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.repository.getRepository().containsKey(organismName)) {
            if (!this.repository.getRepository().get(organismName).getClusters().containsKey(id)) {
                Cluster cluster = new Cluster(id, rows, cols);
                this.repository.getRepository().get(organismName).getClusters().put(id, cluster);
                this.repository.getRepository().get(organismName).getClusterIdInOrder().addLast(id);

                return String.format("Organism %s: Created cluster %s", organismName, id);
            }
        }

        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        Cell cell;
        switch (cellType) {
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            default:
                return null;
        }

        if (this.repository.getRepository().containsKey(organismName)) {
            if (this.repository.getRepository().get(organismName).getClusters().containsKey(clusterId)) {
                if (this.repository.getRepository().get(organismName).getClusters().get(clusterId).getRows() >= cell.getPositionRow() && cell.getPositionRow() >= 0 &&
                        this.repository.getRepository().get(organismName).getClusters().get(clusterId).getCols() >= cell.getPositionCol() && cell.getPositionCol() >= 0) {
                    this.repository.getRepository().get(organismName).getClusters().get(clusterId).addCell(cell);
                    return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
                }
            }
        }

        return null;
    }

    public String activateCluster(String organismName) {
        if (this.repository.getRepository().containsKey(organismName)) {
            Organism organism = this.repository.getRepository().get(organismName);

            String clusterToActivateId = organism.getClusterIdInOrder().removeFirst();
            Cluster clusterToActivate = this.repository.getRepository().get(organismName).getClusters().get(clusterToActivateId);

            Cell currCell = null;
            for (int i = 0; i < clusterToActivate.getCells().length; i++) {
                for (int j = 0; j < clusterToActivate.getCells()[i].length; j++) {
                    if (clusterToActivate.getCells()[i][j] != null && currCell == null) {
                        currCell = clusterToActivate.getCells()[i][j];
                    } else if (currCell != null && clusterToActivate.getCells()[i][j] != null) {
                        boolean result = currCell.attack(clusterToActivate.getCells()[i][j]);

                        if (!result) {
                            clusterToActivate.getCells()[currCell.getPositionRow()][currCell.getPositionCol()] = null;
                            currCell = clusterToActivate.getCells()[i][j];
                        } else {
                            clusterToActivate.getCells()[i][j] = null;
                        }
                    }
                }
            }

            organism.getClusterIdInOrder().addLast(clusterToActivateId);

            return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, clusterToActivateId, clusterToActivate.getNotNullCells().size());

        }

        return null;
    }
}
