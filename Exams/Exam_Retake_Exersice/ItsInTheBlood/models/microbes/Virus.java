package ItsInTheBlood.models.microbes;

import ItsInTheBlood.models.Cell;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return getHealth() + getVirulence();
    }
}
