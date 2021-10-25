package Hanoi;

import Hanoi.Game.Game;
import Hanoi.Game.Play;
import easygraphics.EasyGraphics;

public class Main extends EasyGraphics { //TODO get size from player input

    public static final int POLES = 3;
    public static final int DISKS = 3;
    public static int turns = 0;

    private static final Game game = new Game(DISKS);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {

        System.out.println("Starting game...");
        game.printAllArrays();

        new Play(game);
    }
}