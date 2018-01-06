package ItsInTheBlood.models.blood_cells;

import ItsInTheBlood.models.Cell;

public abstract class BloodCell extends Cell {
    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public boolean attack(Cell cell) {
        this.assimilatedHealth(cell.getHealth());
        super.setPositionRow(cell.getPositionRow());
        super.setPositionCol(cell.getPositionCol());
        return true;
    }

    private void assimilatedHealth(int additionalHealth){
        super.setHealth(super.getHealth() + additionalHealth);
    }
}
