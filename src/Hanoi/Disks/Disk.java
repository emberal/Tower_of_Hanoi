package Hanoi.Disks;

import Hanoi.Game.Position;

public class Disk {

    private int size;
    private Position position;

    public Disk(int size) {

        this.size = size;
        position = Position.LEFT;
    }

    @Override
    public String toString() {
        return  "Disk{" +
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
