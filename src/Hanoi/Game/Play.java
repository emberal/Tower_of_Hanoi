package Hanoi.Game;

import Hanoi.Disks.Pole;
import Hanoi.Draw.Draw;
import Hanoi.Main;
import javax.swing.*;

public class Play extends Draw {

    /**
     *
     * @param game
     * @param autoplay
     */
    public Play(Game game, boolean autoplay) {
        super(game); //Draws the board
        Stats.start = System.currentTimeMillis(); //Starts the timer

        if (!autoplay) {
            startGame();
        }
        else {
            autoplay();
        }
    }

    /**
     * Starts the game
     */
    private void startGame() {

        boolean ok;

        do { //Choose Pole
            ok = true;
            try {
                move();
            }
            catch (NumberFormatException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, Main.numberFormatExc);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, Main.arrayOutOfBounds);
            }

        } while (!ok);
    }

    /**
     *
     */
    private void move() {

        int posFrom, posTo;
        Pole[] poles = game.getPoles();

        do {
            posFrom = Integer.parseInt(getText("Choose pole (1 - " + (Main.POLES) + ")") ) - 1;

            if (poles[posFrom].isEmpty() ) {
                JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
            }
            else {
                System.out.println(poles[posFrom].getPosition() + " selected");

                posTo = Integer.parseInt(getText("Choose pole (1 - " + (Main.POLES) + ")")) - 1;

                if (posFrom == posTo) {
                    JOptionPane.showMessageDialog(null, "You can't choose the same pole");
                }
                else if (!poles[posFrom].isLegal(poles[posTo]) ) {
                    JOptionPane.showMessageDialog(null, "Not a Legal move!");
                }
                else { //If move is successful
                    poles[posFrom].moveTo(poles[posTo]);

                    run();
                    game.printAllArrays();
                }
            }
        } while (!game.isFinished() );

        Stats.stats();
    }

    /**
     *
     */
    private void autoplay() { //TODO test

        Pole[] pole = game.getPoles();

        while (!game.isFinished() ) {

            solve(pole[0].getNr(), pole[0], pole[1], pole[2]);

            run();
            game.printAllArrays();

        }
        Stats.stats();
    }

    /**
     *
     * @param nr Number of disks in the left pole
     * @param left
     * @param center
     * @param right
     */
    private void solve(int nr, Pole left, Pole center, Pole right) {
        if (nr == 1) {
            left.moveTo(right);
        }
        else {
            solve(nr - 1, left, right, center);
            left.moveTo(right);
            solve(nr - 1, center, left, right);
        }
    }
}
