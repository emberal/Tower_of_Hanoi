package Hanoi.Disks;

import Hanoi.Game.Position;
import Hanoi.Main;

import java.util.Arrays;

public class Disks { //TODO get disksize from array

    //Constant
    private int GAME_SIZE;

    //Objectattribute
    private Disk[] disks;
    private int nr = 0; //Number of Disks in the array
    private Position position; //TODO check if nessessary

    //Constructor
    public Disks(int DISKS, Position position) {

        disks = new Disk[Main.DISKS]; //Number of poles * number of disks

        for (; nr < DISKS; nr++) {

            disks[nr] = new Disk(nr, position);

        }
    }

    public Disks() {

        this.disks = new Disk[GAME_SIZE];

    }

    //Moves a disk to the given position
    public void moveTo(Disks disks) {

        if (!this.isEmpty() ) {
            disks.add(this.removeLast() );
        }

    }

    //Adds a disk to array
    public void add(Disk disk) {

        this.disks[nr] = disk;
        nr++;
    }

    //Removes the last disk from array
    public Disk removeLast() {
        nr--;
        return this.disks[this.nr];
    }

    //Checks if array is empty, return true if it is
    public boolean isEmpty() {
        return this.nr == 0;
    }

    //Prints array
    public void printArray() { //TODO Print when null

        if (isEmpty()) {
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
