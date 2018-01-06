package ItsInTheBlood.models.blood_cells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return String.format("--------Health: %d | Velocity: %d | Energy: %d", super.getHealth(), this.velocity, getEnergy());
    }

    @Override
    public int getEnergy() {
        return getHealth() + this.velocity;
    }
}
