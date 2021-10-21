package Hanoi;

import Hanoi.Disks.Pole;
import Hanoi.Game.Game;
import easygraphics.EasyGraphics;

import javax.swing.*;

public class Main extends EasyGraphics {

    public static final int POLES = 3;
    public static final int DISKS = 3;

    static Game game = new Game(DISKS);

    public static void main (String[] args) {

        game.printAllArrays();
        launch(args);
    }

    private final int X = 800;
    private final int Y = 400;

    @Override
    public void run () {
        makeWindow("Tower of Hanoi", X, Y);

        //Border
        drawRectangle(5, 5, X - 10, Y - 10);

        drawBoard();

        play();

    }

    private void drawBoard () {

        final int y = Y - Y / 3;
        final int x = X / 8;
        final int distance = 200;

        //Bottom line
        drawLine(x, y, X - x, y); //TODO change size depending on number of poles, and disks

        //Pillars
        for (int posX = distance; posX <= distance * POLES; posX += distance) {
            drawLine(posX, y, posX, y / 2); //TODO Give each pole a name (1, 2, 3...)
        } //TODO write contents of poles on the screen
        //TODO Finish drawing
    }

    //Starts the game
    private void play () {

        int posFrom = 0, posTo = 0;
        boolean ok;
        String numberFormatExc = "Invalid input, must be an integer number";
        String arrayOutOfBounds = "Invalid input, out of bounds";

        do { //Choose Pole
            ok = true;
            try {
                posFrom = Integer.parseInt(getText("Choose pole (0 - " + (POLES - 1) + ")"));

                if (game.getPoles()[posFrom].isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
                    ok = false;
                }
                else {
                    System.out.println(game.getPoles()[posFrom].getPosition() + " selected");

                    posTo = Integer.parseInt(getText("Choose pole (0 - " + (POLES - 1) + ")"));
                    game.getPoles()[posFrom].moveTo(game.getPoles()[posTo]);
                }
            }
            catch (NumberFormatException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, numberFormatExc);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, arrayOutOfBounds);
            }
            if (posFrom == posTo) {
                ok = false;
                JOptionPane.showMessageDialog(null, "You can't choose the same pole");
            }
        } while (! ok);
    }
}