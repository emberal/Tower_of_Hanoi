package Hanoi.Disks;

import Hanoi.Game.Position;

public class Disk {

    private int size;
    private Position position;

    private final Position polePos;

    public Disk(int size, Position position) {
        this.size = size;
        this.position = position;
        polePos = position;
    }

    @Override
    public String toString() {
        return  polePos + "{" +
                "size=" + size +
                ", position=" + position +
                '}';
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
