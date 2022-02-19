package tower.of.hanoi.disks;

import tower.of.hanoi.draw.Colour;
import tower.of.hanoi.game.Position;

public class Disk {

    private int size, xPos, yPos; //TODO
    private Colour colour;
    private Position position;

    public Disk(Position position, int size) {
        this.size = size;
        this.position = position;
        this.colour = setColour();
    }

    @Override
    public String toString() {
        return  position + "{" +
                "size=" + size +
                /*", xPos=" + xPos +
                ", yPos=" + yPos +*/
                ", colour=" + colour +
                ", position=" + position +
                '}';
    }

    /**
     * Sets a different colour to each disk
     * @return The colour, or null if there is no match
     */
    private Colour setColour() {

        for (Colour c : Colour.values() ) {
            if (size - 1 == c.ordinal() ) {
                return c;
            }
        }
        return null;
    }

    public Colour getColour() {
        return colour;
    }

    public int getSize() {
        return size;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
