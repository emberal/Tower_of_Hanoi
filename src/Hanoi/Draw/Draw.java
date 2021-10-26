package Hanoi.Draw;

import Hanoi.Game.Game;
import Hanoi.Main;
import easygraphics.EasyGraphics;

public class Draw extends EasyGraphics {

    private final int X = 800, Y = 400, DISTANCE = 200;
    protected int[] disks = new int[Main.DISKS];

    protected Game game;

    public Draw(Game game) {;
        this.game = game;
        run();
    }

    public Draw() {

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

        makeWindow("Tower of Hanoi", X, Y);

        int xy = 5;

        //Resets the board after a move
        setColor(255,255,255); //White
        fillRectangle(xy, xy, X - xy * 3, Y - xy * 2);

        setColor(0,0,0); //Black

        //Border
        drawRectangle(xy, xy, X - xy * 2, Y - xy * 2);

        //Bottom line
        drawLine(xy, getBOTTOM(), this.X - xy, getBOTTOM() );
    }

    //Draws the poles
    private void drawPoles() {

        int[] poles = new int[Main.POLES];

        int i = 0;
        for (int x = DISTANCE; x <= DISTANCE * Main.POLES; x += DISTANCE) {
            poles[i] = drawLine(x, getBOTTOM(), x, getBOTTOM() / 2); //TODO Give each pole a name (1, 2, 3...)
            i++;
        } //TODO write contents of poles on the screen
    }

    //Draws the disks
    private void drawDisks() { //TODO change to move methods TODO TEST

        int poleX = DISTANCE;

        for (int p = 0; p < game.getPoles().length; p++) {

            int posY = getBOTTOM();
            if (game.getPoles()[p].getPole() != null) {

                for (int d = 0; d < game.getPoles()[p].getNr(); d++) {

                    disks[d] = fillEllipse(poleX, posY, game.getPoles()[p].getPole()[d].getSize() * 20 + 10, 10);
                    posY -= 20; //Moves the drawing upwards
                }
                poleX += DISTANCE;
            }
        }
    }
}
