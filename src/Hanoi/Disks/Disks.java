package Hanoi.Disks;

import Hanoi.Main;

import java.util.Arrays;

public class Disks { //TODO get disksize from array

    //Constant
    private int GAME_SIZE;

    //Objectattribute
    private Disk[] disks;
    private int nr = 0;

    //Constructor
    public Disks(int GAME_SIZE) {

        disks = new Disk[GAME_SIZE]; //Number of poles * number of disks

        for (; nr < Main.DISKS; nr++) {

            disks[nr] = new Disk(nr);

        }
    }

    public Disks() {

        disks = new Disk[GAME_SIZE];

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
    public void printArray() { //TODO Print when null

        if (!isEmpty() ) {
            for (Disk d : this.disks) {
                System.out.println(d);
            }
        }else {
            System.out.println("null");
        }
    }
    @Override
    public String toString() {
        return "Disks{disks=" + Arrays.toString(disks) + '}';
    }

    //Getters & setters
    public void setGameSize(int gameSize) {
        this.GAME_SIZE = gameSize;
    }
    public int getNr() {
        return this.nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Disk[] getDisks() {
        return disks;
    }

    public void setDisks(Disk[] disks) {
        this.disks = disks;
    }

    public int getGameSize() {
        return GAME_SIZE;
    }
}
