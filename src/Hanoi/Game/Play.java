package Hanoi.Game;

import Hanoi.Disks.Pole;
import Hanoi.Draw.Draw;
import Hanoi.Main;
import javax.swing.*;

public class Play extends Draw {

    public Play(Game game, boolean autoplay) {
        super(game); //Draws the board
        if (!autoplay) { //TODO Autoplay
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

        } while (!game.isFinished() );

        Stats.stats();
    }

    /*
    If the number of disks with a consecutive size on a pole are an odd number,
     set the top disk on the disk that's not on the starting pole
    If the number of disks with a consecutive size on a pole are an even number,
     set the top disk on the disk that's on the starting pole
        Then every other after that until the pole is empty, then do the next pole
     */
    private void autoplay() { //TODO

        Pole[] pole = game.getPoles();

        //First move
        pole[0].moveTo(pole[1]);
        pause(10);
        pole[0].moveTo(pole[2]);
        pause(10);
        pole[1].moveTo(pole[2]);

        while (!game.isFinished() ) {

            pole[0].moveTo(pole[1]);

            //TODO Not the start of the game, missing some code before and after this!
            Pole least = null, most = null;
            int counter = 0;

            for (Pole p : pole) {
                if (p.getNr() == 0) { //Locates the empty pole
                    least = p; //FIXME, never TRUE
                }
                //Locates the pole that's not empty, and does not contain the largest disk
                else if (p.getNr() > 0 && p.getPole()[0].getSize() != Main.disks) {
                    most = p;
                }
            }
            int r = 0; //TODO find correct pole
            //Checks each disk if the size difference of two disks is more than one, counts how many disks before the gap
            //For example, a pole might containt the following sizes: 1, 2, 3, 4, 6, 7, 8;
            // In this case it should count 4, and only move the top 4 first, then 6 to the empty pole
            do { //FIXME shouldn't count all poles, only the one with disks to be moved
                for (int k = 0; k < pole[r].getNr()-1; k++) {
                    if (pole[r].getPole()[k].getSize() - pole[r].getPole()[k + 1].getSize() > 1) { //TODO Check

                        if (counter % 2 == 0) { //If even number place first disk on the pole that is empty
                            pole[r].moveTo(least);
                            pole[r].moveTo(most);
                            least.moveTo(most); //FIXME Try-catch or something
                        }
                        else { //If odd number place first disk on the pole that's not empty
                            pole[r].moveTo(most);
                            pole[r].moveTo(least);
                            most.moveTo(least);
                        }
                    }
                    else {
                        counter++;
                    }
                }
                if (!pole[r].isLegal(least) || !pole[r].isLegal(most) ) { //TODO Do not move disks back to previous position
                    r++;
                }
            } while (pole[r].isLegal(most) ); //FIXME Wrong!


            run();
            game.printAllArrays();

        }
        Stats.stats();
    }
}
