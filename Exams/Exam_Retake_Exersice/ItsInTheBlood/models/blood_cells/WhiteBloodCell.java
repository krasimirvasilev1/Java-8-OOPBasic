package ItsInTheBlood.models.blood_cells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("--------Health: %d | Size: %d | Energy: %d",super.getHealth(),this.size , getEnergy());
    }

    @Override
    public int getEnergy() {
        return (getHealth() + this.size) * 2;
    }
}
