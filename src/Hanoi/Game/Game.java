package Hanoi.Game;

import Hanoi.Disks.Pole;
import Hanoi.Main;

public class Game {

    private Pole[] poles = new Pole[Main.POLES];

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

                for (int i = 0; i < pole.getNr(); i++) {

                    //Size of the pole should be equal to the position it's in
                    if (!poles[0].isEmpty() || pole.getPole()[i].getSize() != i) {
                        return false;
                    }
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
