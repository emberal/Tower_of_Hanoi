package Hanoi.Game;

import Hanoi.Disks.Disks;

public class Game {

    Disks left;
    Disks center;
    Disks right;


    public Game(int DISKS) {
        left = new Disks(DISKS, Position.LEFT);
        center = new Disks(0, Position.CENTER);
        right = new Disks(0, Position.RIGHT);
    }

    public void printAllArrays() {
        left.printArray();
        center.printArray();
        right.printArray();
    }


    public Disks getLeft() {
        return left;
    }

    public void setLeft(Disks left) {
        this.left = left;
    }

    public Disks getCenter() {
        return center;
    }

    public void setCenter(Disks center) {
        this.center = center;
    }

    public Disks getRight() {
        return right;
    }

    public void setRight(Disks right) {
        this.right = right;
    }
}
