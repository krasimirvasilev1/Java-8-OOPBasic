package ItsInTheBlood.models.microbes;

import ItsInTheBlood.models.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol,int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public boolean attack(Cell cell) {
        while(true){
            cell.setHealth(cell.getHealth() - this.getEnergy());

            if (cell.getHealth() <= 0){
                this.setPositionRow(cell.getPositionRow());
                this.setPositionCol(cell.getPositionCol());
                return true;
            }

            this.setHealth(this.getHealth() - cell.getEnergy());

            if (this.getHealth() <= 0){
                cell.setPositionRow(this.getPositionRow());
                cell.setPositionCol(this.getPositionCol());
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("--------Health: %d | Virulence: %d | Energy: %d", super.getHealth(), this.virulence,getEnergy());
    }
}
