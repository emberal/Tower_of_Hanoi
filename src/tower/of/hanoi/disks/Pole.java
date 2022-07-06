package tower.of.hanoi.disks;

import tower.of.hanoi.datastructure.Arraystack;
import tower.of.hanoi.draw.Draw;
import tower.of.hanoi.game.Position;
import tower.of.hanoi.Main;

public class Pole extends Draw {

    private final Arraystack<Disk> pole;
    private final Position POSITION; //TODO check if nessessary

    public Pole(int DISKS, Position POSITION) {

        pole = new Arraystack<>(Main.disks);
        this.POSITION = POSITION;

        for (int nr = getNrOfDisks(); nr < DISKS; nr++) {
            pole.push(new Disk(POSITION, DISKS - nr));
        }
    }

    /**
     * Moves a disk to the given position
     * @param newPole The newPole the disk will be moved to
     * @return true if successfully moved, false otherwise
     */
    public boolean moveTo(Pole newPole) {

        if (isLegal(pole)) {
            System.out.println("Moving " + this.pole.seeLast() + " to " + pole.getPOSITION());

            //moveEllipse(super.disks[nr], 1,1); //TODO move method, change values!

            newPole.pole.push(this.pole.pop());
            newPole.pole.seeLast().setPosition(newPole.POSITION);
            Main.turns++;

            return true;
        }
        return false;
    }

    /**
     * Checks if a move is legal, a move is legal if the toPole it's moved to is empty
     * or the disks on the toPole are bigger than the one we are moving
     *
     * @param toPole The toPole the method checks against
     * @return true if a legal move, false otherwise
     */
    public boolean isLegal(Pole toPole) {

        if (!isEmpty()) {
            if (toPole.isEmpty() || pole.seeLast().getSize() < toPole.pole.seeLast().getSize()) {
                return true;
            }
            System.out.println("Not a legal move!");
        }
        return false;
    }

    /**
     * Checks if array is empty, return true if it is
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return pole.isEmpty();
    }

    @Override
    public String toString() {
        return POSITION + ", " + pole;
    }

    public int getNrOfDisks() {
        return pole.getNumberOfEntries();
    }

    public Arraystack<Disk> getPole() {
        return pole;
    }

    public Position getPOSITION() {
        return POSITION;
    }
}
