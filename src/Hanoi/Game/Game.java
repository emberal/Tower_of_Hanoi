package Hanoi.Game;

import Hanoi.Disks.Pole;
import Hanoi.Main;

public class Game {

    private Pole[] poles = new Pole[Main.POLES];

    public Game(int DISKS) {

        int i = 0;
        while (i < Main.POLES) {
            for (Position p : Position.values() ) {

                poles[i] = new Pole(DISKS, p); //Starting disks
                DISKS = 0; i++; //Resets for the remaining disks
            }
        }
    }

    //Resets the disks back to starting position
    public void resetBoard() {

        for (int p = 1; p < Main.POLES; p++) {

            if (!poles[p].isEmpty() ) {

                for (int i = 0; i < Main.DISKS; i++) {
                    poles[0].add(poles[p].removeDisk(i) );
                }
            }
        }
    }

    //Checks if the game is finished
    public boolean isFinished() {

        for (Pole pole : poles) {

            if (!pole.isEmpty() ) {

                int d = Main.DISKS;
                for (int p = 0; p < pole.getNr(); p++) {

                    //Size of the disks should be in decending order starting at index 0 (3,2,1)
                    if (!poles[0].isEmpty() || pole.getPole()[p].getSize() != d) {
                        return false;
                    }
                    d--;
                }
            }
        }
        return true;
    }

    public void printAllArrays() {

        for (Pole d : poles) {
            d.printArray();
        }
    }

    public Pole[] getPoles() {
        return poles;
    }

    public void setPoles(Pole[] poles) {
        this.poles = poles;
    }

}
