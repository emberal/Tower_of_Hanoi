package Hanoi;

import Hanoi.Game.Game;
import Hanoi.Game.Play;
import easygraphics.EasyGraphics;

import javax.swing.*;

public class Main extends EasyGraphics { //TODO get size from player input

    public static final int POLES = 3;
    public static int DISKS;
    public static int turns = 0;

    public static final String numberFormatExc = "Invalid input, must be an integer number";
    public static final String arrayOutOfBounds = "Invalid input, out of bounds";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {

        System.out.println("Starting game...");

        boolean ok;
        do {
            ok = true;
            try {
                DISKS = Integer.parseInt(JOptionPane.showInputDialog("How many disks do you want to play with? (2-10)"));
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, numberFormatExc);
                ok = false;
            }
            if (ok) {
                if (DISKS < 2) {
                    JOptionPane.showMessageDialog(null, "You need a minimum of 2 disks to play the game.");
                    ok = false;
                }
                else if (DISKS > 10) {
                    JOptionPane.showMessageDialog(null, "Too many disks.");
                    ok = false;
                }
            }
        } while (!ok);

        Game game = new Game(DISKS);
        game.printAllArrays();
        new Play(game);
    }
}