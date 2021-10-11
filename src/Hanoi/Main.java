package Hanoi;

import Hanoi.Disks.Disk;
import Hanoi.Disks.Disks;
import easygraphics.EasyGraphics;

public class Main extends EasyGraphics {
    public static void main(String[] args) {

        //TODO move to array
        Disk disk1 = new Disk();
        Disk disk2 = new Disk();
        Disk disk3 = new Disk();

        Disks disks = new Disks();

        disks.printArray();
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
