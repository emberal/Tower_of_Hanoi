package tower.of.hanoi;

import tower.of.hanoi.game.Game;
import tower.of.hanoi.game.Play;
import tower.of.hanoi.game.Stats;
import easygraphics.EasyGraphics;

import javax.swing.*;

public class Main extends EasyGraphics { //TODO get size from player input

    public static final int POLES = 3;
    public static final int DISKS_MAX = 10;
    public static int disks;
    public static int turns = 0;

    public static final String numberFormatExc = "Invalid input, must be an integer number";
    public static final String arrayOutOfBounds = "Invalid input, out of bounds";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {

        System.out.println("Starting game...");

        setUp();
    }

    public static void setUp() {

        boolean ok;

        do {
            ok = true;
            try {
                disks = Integer.parseInt(JOptionPane.showInputDialog("How many disks do you want to play with? (2-10)"));
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, numberFormatExc);
                ok = false;

            }
            if (ok) {
                if (disks < 2) {
                    JOptionPane.showMessageDialog(null, "You need a minimum of 2 disks to play the game.");
                    ok = false;
                }
                else if (disks == 420) { //Reset file
                    Stats.writeToFile(new int[DISKS_MAX+1], new long[DISKS_MAX+1]);
                    ok = false;
                }
                else if (disks > DISKS_MAX) {
                    JOptionPane.showMessageDialog(null, "Too many disks.");
                    ok = false;
                }
            }
        } while (!ok);

        Game game = new Game(disks); //Creates everything
        game.printAllArrays();
        new Play(game); //Starts the game
    }
}