package ItsInTheBlood.models;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public abstract boolean attack (Cell cell);

    public abstract int getEnergy();

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public void setPositionRow(int newPositionRow){
        this.positionRow = newPositionRow;
    }

    public void setPositionCol(int newPositionCol){
        this.positionCol = newPositionCol;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
