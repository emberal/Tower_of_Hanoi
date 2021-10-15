package Hanoi.Disks;

import Hanoi.Game.Position;

public class Disk {

    private int size;
    private Position position;

    public Disk() {

        position = Position.LEFT;
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
