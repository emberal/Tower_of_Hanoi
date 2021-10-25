package Hanoi.Disks;

import Hanoi.Game.Position;
import Hanoi.Main;

public class Disk {

    private static int nr = Main.DISKS;

    private int size;
    private Position position;

    private final Position polePos;

    public Disk(Position position) {
        this.size = nr; nr--;
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
