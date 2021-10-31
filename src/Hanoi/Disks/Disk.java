package Hanoi.Disks;

import Hanoi.Game.Position;
import Hanoi.Main;

public class Disk {

    private int size, xPos, yPos; //TODO
    private Position position;

    public Disk(Position position, int size) {
        this.size = size;
        this.position = position;
    }

    @Override
    public String toString() {
        return  position + "{" +
                "size=" + size +
                ", position=" + position +
                '}';
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
