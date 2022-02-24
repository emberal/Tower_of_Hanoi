package tower.of.hanoi.draw;

import tower.of.hanoi.game.Game;
import tower.of.hanoi.game.Position;
import tower.of.hanoi.Main;
import easygraphics.EasyGraphics;

public class Draw extends EasyGraphics { //TODO switch to JavaFX or similar

    private static final int X = 800, Y = 400;

    private final int[] DISKS; //TODO
    protected Game game;

    public Draw(Game game) {
        DISKS = new int[Main.disks];
        this.game = game;
        run();
    }

    public Draw() {
        DISKS = new int[Main.disks];
    }

    @Override
    public void run() {
        drawBoard();
        drawPoles();
        drawDisks();
    }

    /**
     * The bottom line for the poles
     * @return Y-Position of the line
     */
    private int getBOTTOM() {
        return Y - Y / 3;
    }

    /**
     * Draws the board
     */
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
        drawLine(xy, getBOTTOM(), X - xy, getBOTTOM() );
    }

    /**
     * Draws the poles
     */
    private void drawPoles() {

        int i = 0;
        for (Position pos : Position.values() ) {
            drawLine(pos.getX_POS(), getBOTTOM(), pos.getX_POS(), getBOTTOM() / 2);
            i++;
            drawString(Integer.toString(i), pos.getX_POS() - 3, getBOTTOM() + 30 );
        }
    }

    /**
     * Draws the disks
     */
    private void drawDisks() { //TODO change to move methods TODO TEST

        int p = 0;
        for (Position pos : Position.values() ) {

            int posY = getBOTTOM();
            if (game.getPoles()[p].getPole() != null) {

                for (int d = 0; d < game.getPoles()[p].getNrOfDisks(); d++) {

                    //Gets the colour from the disk
                    final int[] RGB =  game.getPoles()[p].getPole().getElementAt(d).getColour().getRGB();
                    setColor(RGB[0],RGB[1],RGB[2]);

                    DISKS[d] = fillEllipse(pos.getX_POS(), posY,
                            game.getPoles()[p].getPole().getElementAt(d).getSize() * 11 + 10, 5);
                    posY -= 8; //Moves the drawing upwards
                }
            }
            p++;
        }
    }
}
