package Hanoi.Disks;

import java.util.Arrays;

public class Disks { //TODO get disksize from array

    //Constant
    private static final int SIZE = 3; //TODO setnr variable

    //Attributes
    private static int nr = 0;
    private Disk[] disks = new Disk[SIZE];

    //Constructor
    public Disks() {

    }

    //Adds disk to array
    public void add(Disk disk) {
        disk.setSize(nr);
        disks[nr] = disk;
        nr++;
    }

    //Prints array
    public void printArray() {

        for (Disk d: disks) {
            System.out.println(d);
        }

    }

    @Override
    public String toString() {
        return "Disks{disks=" + Arrays.toString(disks) + '}';
    }

    //Getters & setters
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

    public static int getSize() {
        return SIZE;
    }
}
