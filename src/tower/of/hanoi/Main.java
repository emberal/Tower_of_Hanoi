package tower.of.hanoi;

import tower.of.hanoi.game.Game;
import tower.of.hanoi.game.Play;
import tower.of.hanoi.game.Stats;
import easygraphics.EasyGraphics;

import javax.swing.*;
import java.awt.*;

public class Main extends EasyGraphics { //TODO get size from player input

    public static final int POLES = 3;
    public static final int DISKS_MIN = 2, DISKS_MAX = 10;
    public static boolean autoplay = false; // Yes = 0, No = 1, Cancel = 2
    public static int disks;
    public static int turns = 0;

    public static final String numberFormatExc = "Invalid input, must be an integer number";
    public static final String arrayOutOfBounds = "Invalid input, out of bounds";
    public static final String stringOutOfBounds = "Input can't be empty";

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
                disks = Integer.parseInt(JOptionPane.showInputDialog("How many disks do you want to play with? (2-10)") );
                autoplay = JOptionPane.showConfirmDialog(null, "Would you like autocomplete?") == 0;
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, numberFormatExc);
                ok = false;
            }
            if (ok) {
                if (disks < 2) {
                    JOptionPane.showMessageDialog(null, "You need a minimum of " + DISKS_MIN + " disks to play the game.");
                    ok = false;
                }
                else if (disks == 420) { //Reset file
                    Stats.writeToFile(new int[DISKS_MAX+1], new long[DISKS_MAX+1]);
                    ok = false;
                }
                else if (disks > DISKS_MAX) {
                    JOptionPane.showMessageDialog(null, "Too many disks, you can have no more than " + DISKS_MAX + ".");
                    ok = false;
                }
            }
        } while (!ok);

        Game game = new Game(disks); //Creates everything
        game.printAllArrays();
        new Play(game, autoplay); //Starts the game
    }
}