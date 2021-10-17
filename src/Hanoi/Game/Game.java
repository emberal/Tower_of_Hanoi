package Hanoi.Game;

import Hanoi.Disks.Pole;
import Hanoi.Main;

public class Game {

    Pole[] poles = new Pole[Main.POLES];

    public Game(int DISKS) {

        poles[0] = new Pole(DISKS, Position.LEFT); //Starting disks

        for (int i = 1; i < Main.POLES; i++) { //Rest of the disks
            for (Position p : Position.values() ) { //TODO check values DEBUG!
                poles[i] = new Pole(0, p); //TODO fix loops, 
            }
        }
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
