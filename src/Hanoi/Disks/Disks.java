package Hanoi.Disks;

import Hanoi.Game.Position;
import Hanoi.Main;

import java.util.Arrays;

public class Disks { //TODO get disksize from array

    //Constant
    private int GAME_SIZE;

    //Objectattribute
    private Disk[] disks;
    private int nr = 0;
    private Position position; //TODO check if nessessary

    //Constructor
    public Disks(int DISKS, Position position) {

        disks = new Disk[Main.DISKS]; //Number of poles * number of disks

        for (; nr < DISKS; nr++) {

            disks[nr] = new Disk(nr, position);

        }
    }

    public Disks() {

        disks = new Disk[GAME_SIZE];

    }

    //Adds a disk to array
    public void add(Disk disk) { //TODO test pretty sure it's wrong
        disk.setSize(nr);
        disks[nr] = disk;
        nr++;
    }

    //Removes the last disk from array
    public void removeLast() {
        disks[disks.length-1] = null;
        nr--;
    }

    //Checks if array is empty, return true if it is
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
            System.out.println(Arrays.toString(this.disks));
        }
        System.out.println("Length: '" + this.disks.length + "' Number of spaces used: '" + this.nr + '\'');
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
