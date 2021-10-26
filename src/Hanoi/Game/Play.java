package Hanoi.Game;

import Hanoi.Draw.Draw;
import Hanoi.Main;
import javax.swing.*;

public class Play extends Draw { //TODO Autoplay

    public Play(Game game) {
        super(game);
        startGame();
    }

    //Starts the game
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
                else { //If move is successful
                    game.getPoles()[posFrom].moveTo(game.getPoles()[posTo]);

                    run();
                    game.printAllArrays();
                }
            }

        } while (!game.isFinished() );

        stats();
    }

    private void stats() {

        boolean ok; char answer = ' ';
        do {
            ok = true;
            try {
                answer = Character.toLowerCase(JOptionPane.showInputDialog("Board size: " + Main.POLES + '\n' +
                        "Number of disks: " + Main.DISKS + '\n' +
                        "Congratulations, you won!\nIt took you " + Main.turns + " turns" + '\n' +
                        "The previous record was: " + null + '\n' +
                        "Would you like to play again? (Y/N)").charAt(0) );
            }
            catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null,"Input can't be empty");
                ok = false;
            }
            catch (NullPointerException ignored) {}

            if (ok) {
                if (answer != 'y' && answer != 'n') {
                    JOptionPane.showMessageDialog(null,
                            "Wrong input, please type 'Y' for yes or 'N' for no");
                    ok = false;
                }
            }
        } while (!ok);

        if (answer == 'y') {
            game.resetBoard();
            new Play(game);
        }
    }
}
