package Hanoi;

import Hanoi.Game.Game;
import easygraphics.EasyGraphics;

import javax.swing.*;

public class Main extends EasyGraphics {

    public static final int POLES = 3;
    public static final int DISKS = 3;
    public static int turns = 0;

    private static final Game game = new Game(DISKS);

    public static void main(String[] args) {
        launch(args);
    }

    private final int X = 800;
    private final int Y = 400;

    @Override
    public void run() {
        makeWindow("Tower of Hanoi", X, Y);

        //Border
        drawRectangle(5, 5, X - 10, Y - 10);

        drawBoard();

        startGame();

    }

    private void drawBoard() {

        final int Y = this.Y - this.Y / 3;
        final int X = this.X / 8;
        final int DISTANCE = 200;

        //Bottom line
        drawLine(X, Y, this.X - X, Y); //TODO change size depending on number of poles, and disks

        //Pillars
        for (int x = DISTANCE; x <= DISTANCE * POLES; x += DISTANCE) {
            drawLine(x, Y, x, Y / 2); //TODO Give each pole a name (1, 2, 3...)
        } //TODO write contents of poles on the screen
        //TODO Finish drawing
    }

    //Draws the disks
    private void drawDisk() { //TODO complete
        int size = game.getPoles()[0].getPole()[0].getSize(); //Refers to the size of the disk in position 0, in pole 0
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
            posFrom = Integer.parseInt(getText("Choose pole (0 - " + (POLES - 1) + ")") );

            if (game.getPoles()[posFrom].isEmpty() ) {
                JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
            }
            else {
                System.out.println(game.getPoles()[posFrom].getPosition() + " selected");

                posTo = Integer.parseInt(getText("Choose pole (0 - " + (POLES - 1) + ")") );
                if (posFrom == posTo) {
                    JOptionPane.showMessageDialog(null, "You can't choose the same pole");
                }
                else {
                    game.getPoles()[posFrom].moveTo(game.getPoles()[posTo]);

                    game.printAllArrays();
                }
            }

        } while (!game.isFinished() );

        JOptionPane.showMessageDialog(null, "Congratulations, you won!\nIt took you " + turns + " turns");
    }

    //For testing
    protected void privates() {
        drawBoard();
        drawDisk();
        startGame();
        move();
    }

}