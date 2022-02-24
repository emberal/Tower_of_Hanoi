package tower.of.hanoi.game;

import tower.of.hanoi.disks.Pole;
import tower.of.hanoi.draw.Draw;
import tower.of.hanoi.Main;
import javax.swing.*;

public class Play extends Draw {

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

        Stats.start = System.currentTimeMillis(); //Starts the timer

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
        do {
            Pole[] poles = game.getPoles();

            posFrom = Integer.parseInt(getText("Choose pole (1 - " + (Main.POLES) + ")") ) - 1;

            if (poles[posFrom].isEmpty() ) {
                JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
            }
            else {
                System.out.println(poles[posFrom].getPOSITION() + " selected");

                posTo = Integer.parseInt(getText("Choose pole (1 - " + (Main.POLES) + ")")) - 1;

                if (posFrom == posTo) {
                    JOptionPane.showMessageDialog(null, "You can't choose the same pole");
                }
                else if (!poles[posFrom].isLegal(poles[posTo]) ) {
                    JOptionPane.showMessageDialog(null, "Not a Legal move!");
                }
                else { //If move is successful
                    poles[posFrom].moveTo(poles[posTo]);

                    run(); //Draws the new window
                    game.printAllArrays();
                }
            }
        } while (!game.isFinished());

        Stats.stats();
    }

    /**
     * Autocompletes the game, and then shows the stats page
     */
    private void autoplay() {

        Pole[] pole = game.getPoles();

        solve(pole[0].getNrOfDisks(), pole[0], pole[1], pole[2]);

        run(); //Draws the new window
        game.printAllArrays();
        Stats.stats();
    }

    /**
     * Uses recursive calls to solve the problem
     * @param nr Number of disks in the left pole
     * @param left First pole
     * @param center Second polr
     * @param right Third pole
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
