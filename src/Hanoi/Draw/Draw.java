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
        drawDisks();
    }

    private int getBOTTOM() {
        return Y - Y / 3;
    }

    private void drawBoard() {

        final int X = this.X / 8;

        //Bottom line
        drawLine(X, getBOTTOM(), this.X - X, getBOTTOM()); //TODO change size depending on number of poles, and disks

        drawPoles();
    }

    private void drawPoles() {

        for (int x = DISTANCE; x <= DISTANCE * Main.POLES; x += DISTANCE) {
            drawLine(x, getBOTTOM(), x, getBOTTOM() / 2); //TODO Give each pole a name (1, 2, 3...)
        } //TODO write contents of poles on the screen
        //TODO Finish drawing
    }

    //Draws the disks
    protected void drawDisks() { //TODO complete
        //int diskSize = game.getPoles()[0].getPole()[0].getSize(); //Refers to the size of the disk in position 0, in pole 0

        int poleX = DISTANCE;

        for (int p = 0; p < game.getPoles().length; p++) {

            int posY = getBOTTOM();

            for (int size = game.getPoles()[p].getNr()-1; size >= 0; size--) { //TODO remove disk after moved

                fillEllipse(poleX, posY, size*20+10, 10); //FIXME use correct diskSize
                posY -= 20;
            }
            poleX += DISTANCE;
        }
    }


}
