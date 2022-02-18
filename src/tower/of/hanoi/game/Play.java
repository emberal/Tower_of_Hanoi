package tower.of.hanoi.game;

import tower.of.hanoi.disks.Pole;
import tower.of.hanoi.draw.Draw;
import tower.of.hanoi.Main;
import javax.swing.*;

public class Play extends Draw { //TODO Autoplay

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

    //Starts the game
    private void startGame() {

        boolean ok;
        Stats.start = System.currentTimeMillis(); //Starts the timer

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

    private void move() {

        int posFrom, posTo;

        do {
            posFrom = Integer.parseInt(getText("Choose pole (1 - " + (Main.POLES) + ")") ) - 1;

            if (game.getPoles()[posFrom].isEmpty() ) {
                JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
            }
            else {
                System.out.println(game.getPoles()[posFrom].getPosition() + " selected");

                posTo = Integer.parseInt(getText("Choose pole (1 - " + (Main.POLES) + ")")) - 1;

                if (posFrom == posTo) {
                    JOptionPane.showMessageDialog(null, "You can't choose the same pole");
                }
                else if (!game.getPoles()[posFrom].isLegal(game.getPoles()[posTo]) ) {
                    JOptionPane.showMessageDialog(null, "Not a Legal move!");
                }
                else { //If move is successful
                    game.getPoles()[posFrom].moveTo(game.getPoles()[posTo]);

                    run();
                    game.printAllArrays();
                }
            }

        } while (!game.isFinished());

        Stats.stats();
    }

    /**
     *
     */
    private void autoplay() { //TODO test

        Pole[] pole = game.getPoles();

        while (!game.isFinished()) {

            solve(pole[0].getNrOfDisks(), pole[0], pole[1], pole[2]);

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
