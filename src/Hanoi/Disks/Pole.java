package Hanoi.Disks;

import Hanoi.Game.Position;
import Hanoi.Main;

import java.util.Arrays;

public class Pole { //TODO get disksize from array

    //Constant
    private int GAME_SIZE;

    //Objectattribute
    private Disk[] pole;
    private int nr = 0; //Number of Disks in the array
    private Position position; //TODO check if nessessary

    //Constructor
    public Pole(int DISKS, Position position) {

        pole = new Disk[Main.DISKS];

        for (; nr < DISKS; nr++) {

            pole[nr] = new Disk(nr, position);

        }
    }

    public Pole() {

        this.pole = new Disk[GAME_SIZE];

    }

    //Moves a disk to the given position
    public void moveTo(Pole pole) {

        if (!isEmpty() && isLegal(pole) ) {
            pole.add(removeLast() );
        }
    }

    //Checks if a move is legal, a move is legal if the pole it's moved to is empty
    //  or the disks on the pole are bigger than the one we are moving
    public boolean isLegal(Pole pole) {

        return pole.isEmpty() || pole.seeLast().getSize() < this.getNr();
    }

    //Adds a disk to array
    public boolean add(Disk disk) {

        if (nr != 3) {
            pole[nr] = disk;
            nr++;
            return true;
        }
        return false;
    }

    //Removes the last disk from array
    public Disk removeLast() {

        if (!isEmpty() ) {
            nr--;
            return pole[nr];
        }
        return null;
    }

    public Disk seeLast() {
        if (!isEmpty() ) {
            return pole[nr];
        }
        return null;
    }

    //Checks if array is empty, return true if it is
    public boolean isEmpty() {
        return nr == 0;
    }

    //Prints array
    public void printArray() { //TODO Print when null

        if (!isEmpty()) {
            for (Disk d : pole) {
                System.out.println(d);
            }
        }else {
            System.out.println(Arrays.toString(pole));
        }
        System.out.println("Length: '" + pole.length + "' Number of spaces used: '" + nr + '\'');
    }

    @Override
    public String toString() {
        return "Disks{disks=" + Arrays.toString(pole) + '}';
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

    public Disk[] getPole() {
        return pole;
    }

    public void setPole(Disk[] pole) {
        this.pole = pole;
    }

    public int getGameSize() {
        return GAME_SIZE;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
