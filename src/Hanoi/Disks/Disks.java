package Hanoi.Disks;

import java.util.Arrays;

public class Disks { //TODO get disksize from array

    //Classattribute
    private static int nr = 0;

    //Constant
    private int gameSize;

    //Objectattribute
    private Disk[] disks;
    private Disk size;

    //Constructor
    public Disks(int gameSize) {

        disks = new Disk[gameSize];

        for (; nr < gameSize; nr++) {

            disks[nr] = new Disk(nr);

        }
    }

    public Disks() {

    }

    //Adds disk to array
    public void add(Disk disk) {
        disk.setSize(nr);
        this.disks[nr] = disk;
        nr++;
    }

    public boolean isEmpty() {
        return this.disks == null;
    }
    //Prints array
    public void printArray() {

        if (!isEmpty() ) {
            for (Disk d : this.disks) {
                System.out.println(d);
            }
        }
        System.out.println("null");
    }
    @Override
    public String toString() {
        return "Disks{disks=" + Arrays.toString(disks) + '}';
    }

    //Getters & setters
    public void setGameSize(int gameSize) {
        this.gameSize = gameSize;
    }
    public static int getNr() {
        return nr;
    }

    public static void setNr(int nr) {
        Disks.nr = nr;
    }

    public Disk[] getDisks() {
        return disks;
    }

    public void setDisks(Disk[] disks) {
        this.disks = disks;
    }

    public int getGameSize() {
        return gameSize;
    }
}
