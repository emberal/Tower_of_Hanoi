package Hanoi.Game;

import Hanoi.Disks.Pole;
import Hanoi.Main;

public class Game {

    protected Pole[] poles = new Pole[Main.POLES];

    public Game(int DISKS) {

        poles[0] = new Pole(DISKS, Position.LEFT); //Starting disks

        for (int i = 1; i < Main.POLES; i++) { //Rest of the disks
            for (Position p : Position.values() ) { //TODO check values DEBUG!

                if (p != Position.LEFT) {
                    poles[i] = new Pole(0, p); //FIXME fix loops, showing wrong position
                }
            }
        }
    }

    //Checks if the game is finished
    public boolean isFinished() { //TODO TEST

        for (Pole pole : poles) {

            if (!pole.isEmpty() ) {

                int d = Main.POLES;
                for (int p = 0; p < pole.getNr(); p++) {

                    //Size of the disks should be in decending order starting at index 0 (3,2,1)
                    if (!poles[0].isEmpty() || pole.getPole()[p].getSize() != d) {
                        return false;
                    }
                    try {
                        d--;
                    }
                    catch (ArrayIndexOutOfBoundsException ignored) {}
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
