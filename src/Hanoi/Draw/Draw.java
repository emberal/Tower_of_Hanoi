package Hanoi.Draw;

import Hanoi.Game.Game;
import Hanoi.Main;
import easygraphics.EasyGraphics;

public class Draw extends EasyGraphics {

    private final int X, Y, DISTANCE = 200;

    protected Game game;

    public Draw(Game game, int X, int Y) {
        this.X = X; this.Y = Y;
        this.game = game;
        run();
    }

    @Override
    public void run() {
        drawBoard();
        drawPoles();
        drawDisks();
    }

    private int getBOTTOM() {
        return Y - Y / 3;
    }

    private void drawBoard() {

        //Resets the board after a move
        setColor(255,255,255); //White
        fillRectangle(10, 10, X-15, Y-15);

        final int X = this.X / 8;

        //Bottom line
        setColor(0,0,0); //Black
        drawLine(X, getBOTTOM(), this.X - X, getBOTTOM() ); //TODO change size depending on number of poles, and disks
    }

    //Draws the poles
    private void drawPoles() {

        for (int x = DISTANCE; x <= DISTANCE * Main.POLES; x += DISTANCE) {
            drawLine(x, getBOTTOM(), x, getBOTTOM() / 2); //TODO Give each pole a name (1, 2, 3...)
        } //TODO write contents of poles on the screen
        //TODO Finish drawing
    }

    //Draws the disks
    protected void drawDisks() { //TODO complete

        int poleX = DISTANCE;

        for (int p = 0; p < game.getPoles().length; p++) {

            int posY = getBOTTOM();
            if (game.getPoles()[p].getPole() != null) {

                for (int d = 0; d < game.getPoles()[p].getNr(); d++) {

                    fillEllipse(poleX, posY, game.getPoles()[p].getPole()[d].getSize() * 20 + 10, 10);
                    posY -= 20; //Moves the drawing upwards
                }
                poleX += DISTANCE;
            }
        }
    }
}
