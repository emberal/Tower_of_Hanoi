package Hanoi.Game;

import Hanoi.Draw.Draw;
import Hanoi.Main;
import javax.swing.*;

public class Play extends Draw { //TODO Autoplay

    public Play(Game game, int X, int Y) {
        super(game, X, Y);
        startGame();
    }

    //Starts the game
    private void startGame() {

        boolean ok;
        String numberFormatExc = "Invalid input, must be an integer number";
        String arrayOutOfBounds = "Invalid input, out of bounds";

        do { //Choose Pole
            ok = true;
            try {
                move();
            }
            catch (NumberFormatException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, numberFormatExc);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, arrayOutOfBounds);
            }

        } while (!ok);
    }

    private void move() {

        int posFrom, posTo;

        do {
            posFrom = Integer.parseInt(getText("Choose pole (0 - " + (Main.POLES - 1) + ")") );

            if (game.getPoles()[posFrom].isEmpty() ) {
                JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
            }
            else {
                System.out.println(game.getPoles()[posFrom].getPosition() + " selected");

                posTo = Integer.parseInt(getText("Choose pole (0 - " + (Main.POLES - 1) + ")") );
                if (posFrom == posTo) {
                    JOptionPane.showMessageDialog(null, "You can't choose the same pole");
                }
                else {
                    game.getPoles()[posFrom].moveTo(game.getPoles()[posTo]);

                    game.printAllArrays();
                }
            }

        } while (!game.isFinished() );

        JOptionPane.showMessageDialog(null, "Congratulations, you won!\nIt took you " + Main.turns + " turns");
    }
}
