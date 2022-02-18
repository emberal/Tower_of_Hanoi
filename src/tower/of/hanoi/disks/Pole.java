package tower.of.hanoi.disks;

import tower.of.hanoi.adt.StackADT;
import tower.of.hanoi.datastructure.Arraystack;
import tower.of.hanoi.draw.Draw;
import tower.of.hanoi.game.Position;
import tower.of.hanoi.Main;

public class Pole extends Draw {

    private StackADT<Disk> poleStack; //TODO Use stack
    private Disk[] pole;
    private int nr = 0; //Number of Disks in the array
    private Position position; //TODO check if nessessary

    public Pole(int DISKS, Position position) {

        poleStack = new Arraystack<>(Main.disks);
        //pole = new Disk[Main.disks];
        this.position = position;

        for (int nr = getNrOfDisks(); nr < DISKS; nr++) {
            poleStack.push(new Disk(position, DISKS - nr));
            //pole[nr] = new Disk(position, DISKS-nr); //Size decreases by 1 for each iteration

        }
    }

    /**
     * Moves a disk to the given position
     * @param pole The pole the disk will be moved to
     * @return true if successfully moved, false otherwise
     */
    public boolean moveTo(Pole pole) {

        if (isLegal(pole)) {
            System.out.println("Moving " + poleStack.seeLast() + " to " + pole.getPosition() );

            //moveEllipse(super.disks[nr], 1,1); //TODO move method, change values!

            pole.poleStack.push(poleStack.pop());
            //pole.add(removeLast() );
            pole.poleStack.seeLast().setPosition(pole.position);
            //pole.seeLast().setPosition(pole.position); //Sets the position of the disk to be equal to the pole
            Main.turns++;

            return true;
        }
        return false;
    }

    /**
     * Checks if a move is legal, a move is legal if the toPole it's moved to is empty
     * or the disks on the toPole are bigger than the one we are moving
     * @param toPole The toPole the method checks against
     * @return true if a legal move, false otherwise
     */
    public boolean isLegal(Pole toPole) {

        if (!isEmpty()) {
            if (toPole.isEmpty() || poleStack.seeLast().getSize() < toPole.poleStack.seeLast().getSize() ) {
                return true;
            }
            System.out.println("Not a legal move!");
        }
        return false;
    }

    public void push(Disk disk) {
        poleStack.push(disk);
    }

    public Disk pop() {
        return poleStack.pop();
    }

    @Deprecated
    //Adds a disk to array
    public boolean add(Disk disk) {

        if (nr < Main.disks) {
            pole[nr] = disk;
            nr++;
            return true;
        }
        return false;
    }

    @Deprecated
    /**
     * Removes the last disk from an array
     */
    public Disk removeLast() {

        return removeDisk(nr-1);
    }

    @Deprecated
    //Removes any disk from an array
    public Disk removeDisk(int pos) {

        if (!isEmpty() ) {
            Disk disk = pole[pos];

            pole[pos] = null;
            nr--;
            return disk;
        }
        return null;
    }

    @Deprecated
    //Returns the disk with the highest nr on a pole
    public Disk seeLast() {
        if (!isEmpty() ) {
            return pole[nr-1];
        }
        return null;
    }

    /**
     * Checks if array is empty, return true if it is
     */
    public boolean isEmpty() {
        return poleStack.isEmpty();
    }

    //Prints array
    public void printArray() {

        System.out.println(position + ", " + poleStack);
        //System.out.println("Length: '" + pole.length + "' Number of spaces used: '" + nr + '\'');
    }

    @Override
    public String toString() {
        return poleStack.toString();
    }

    public int getNrOfDisks() {
        return poleStack.getNumberOfEntries();
    }

    public StackADT<Disk> getPoleStack() {
        return poleStack;
    }

    public Disk[] getPole() {
        return pole;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
