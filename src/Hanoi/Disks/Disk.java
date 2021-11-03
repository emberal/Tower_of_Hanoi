package Hanoi.Disks;

import Hanoi.Draw.Colour;
import Hanoi.Game.Position;

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

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
