package Hanoi.Disks;

import Hanoi.Draw.Draw;
import Hanoi.Game.Position;
import Hanoi.Main;

import java.util.Arrays;

public class Pole extends Draw {

    //Objectattribute
    private Disk[] pole;
    private int nr = 0; //Number of Disks in the array
    private Position position; //TODO check if nessessary

    //Constructor
    public Pole(int DISKS, Position position) {

        pole = new Disk[Main.disks];
        this.position = position;

        for (; nr < DISKS; nr++) {

            pole[nr] = new Disk(position, DISKS-nr); //Size decreases by 1 for each iteration

        }
    }

    //Moves a disk to the given position
    public boolean moveTo(Pole pole) {

        if (!isEmpty() && isLegal(pole) ) {
            System.out.println("Moving " + this.seeLast() + " to " + pole.getPosition() );

            //moveEllipse(super.disks[nr], 1,1); //TODO move method, change values!

            pole.add(removeLast() );
            pole.seeLast().setPosition(pole.position); //Sets the position of the disk to be equal to the pole
            Main.turns++;

            return true;
        }
        return false;
    }

    //Checks if a move is legal, a move is legal if the pole it's moved to is empty
    //  or the disks on the pole are bigger than the one we are moving
    public boolean isLegal(Pole pole) {

        if (!isEmpty() ) {
            if (pole.isEmpty() || this.seeLast().getSize() < pole.seeLast().getSize() ) {
                return true;
            }
        }
        System.out.println("Not a legal move!");
        return false;
    }

    //Adds a disk to array
    public boolean add(Disk disk) {

        if (nr < Main.disks) {
            pole[nr] = disk;
            nr++;
            return true;
        }
        return false;
    }

    //Removes the last disk from an array
    public Disk removeLast() {

        return removeDisk(nr-1);
    }

    //Removes any disk from an array
    public Disk removeDisk(int pos) {

        if (!isEmpty() ) { //TODO if necessarry. If a disk is taken from the middle of the pole, move the others down, to avoid nullpointer
            Disk disk = pole[pos];

            pole[pos] = null;
            nr--;
            return disk;
        }
        return null;
    }

    //Returns the disk with the highest nr on a pole
    public Disk seeLast() {
        if (!isEmpty() ) {
            return pole[nr-1];
        }
        return null;
    }

    //Checks if array is empty, return true if it is
    public boolean isEmpty() {
        return nr == 0;
    }

    //Prints array
    public void printArray() {

        if (!isEmpty() ) {
            for (Disk d : pole) {
                System.out.print(d + "\t");
            }
            System.out.println();
        }
        else {
            System.out.println(position + "{" + Arrays.toString(pole) + "}" );
        }
        //System.out.println("Length: '" + pole.length + "' Number of spaces used: '" + nr + '\'');
    }

    @Override
    public String toString() {
        return "Disks{disks=" + Arrays.toString(pole) + '}';
    }

    //Getters & setters
    public int getNr() {
        return this.nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Disk[] getPole() {
        return pole;
    }

    public void setPole(Disk[] pole) {
        this.pole = pole;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
