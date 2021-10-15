package Hanoi;

import Hanoi.Game.Game;
import easygraphics.EasyGraphics;

public class Main extends EasyGraphics {

    public static final int POLES = 3;
    public static final int DISKS = 3;
    public static final int GAME_SIZE = POLES * DISKS;

    public static void main(String[] args) {

        Game game = new Game(GAME_SIZE);

        game.printAllArrays();
        launch(args);
    }

    private final int X = 800;
    private final int Y = 400;

    @Override
    public void run() {
        makeWindow("Tower of Hanoi", X, Y);

        //Border
        drawRectangle(5, 5, X-10, Y-10);

        drawBoard();

    }

    private void drawBoard() {

        final int y = Y - Y / 3;
        final int x = X / 8;

        //Bottom line
        drawLine(x, y, X - x, y);

        //Pillars
        for (int posX = 200; posX <= 600; posX += 200) {
            drawLine(posX,y,posX,y/2);
        }

    }
}
