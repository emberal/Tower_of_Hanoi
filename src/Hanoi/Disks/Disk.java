package Hanoi.Disks;

import Hanoi.Game.Position;
import Hanoi.Main;

public class Disk {

    private static int nr = Main.DISKS;

    private int size, xPos, yPos; //TODO
    private Position position;

    public Disk(Position position) {
        this.size = nr; nr--;
        this.position = position;
    }

    @Override
    public String toString() {
        return  position + "{" +
                "size=" + size +
                ", position=" + position +
                '}';
    }

    public static int getNr() {
        return nr;
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
