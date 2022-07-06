package tower.of.hanoi.game;

import tower.of.hanoi.disks.Pole;
import tower.of.hanoi.Main;

public class Game {

    private final Pole[] poles = new Pole[Main.POLES]; //TODO check against stack

    public Game(int DISKS) {

        int i = 0;
        while (i < Main.POLES) {
            for (Position p : Position.values()) {
                poles[i] = new Pole(DISKS, p); //Starting disks
                DISKS = 0; //Resets for the remaining disks
                i++;
            }
        }
    }

    /**
     * Checks if the game is finished
     * The game is finished if the first pole is empty, and one of the others is full
     *
     * @return true if finished, false if not
     */
    public boolean isFinished() {
        boolean finished = false;
        Pole first = poles[0];

        for (int i = 1; i < poles.length && !finished; i++) {
            //Size of the disks should be in decending order starting at index 0 (3,2,1)
            if (first.isEmpty() && poles[i].getNrOfDisks() == Main.disks) {
                finished = true;
            }

        }
        return finished;
    }

    public void printAllArrays() {

        for (Pole d : poles) {
            System.out.println(d);
        }
    }

    public Pole[] getPoles() {
        return poles;
    }
}
