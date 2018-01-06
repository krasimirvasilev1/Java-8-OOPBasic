package ItsInTheBlood.models.clusters;

import ItsInTheBlood.models.Cell;

import java.util.ArrayList;
import java.util.List;


public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public void addCell(Cell cell){
        this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public List<Cell> getNotNullCells (){
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                if (this.cells[i][j] != null){
                    cells.add(this.cells[i][j]);
                }
            }
        }
        return cells;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
