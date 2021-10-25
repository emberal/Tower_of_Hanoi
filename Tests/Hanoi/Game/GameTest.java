package Hanoi.Game;

import Hanoi.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest { //TODO tests

    Game game = new Game(Main.DISKS);

    @Test
    void constructor() {

        Assertions.assertEquals(3, game.getPoles()[0].getNr());

        for (int i = 1; i < Main.POLES; i++) {
            Assertions.assertEquals(0, game.getPoles()[i].getNr());
        }

        game.getPoles()[0].moveTo(game.getPoles()[1]);
        game.getPoles()[0].moveTo(game.getPoles()[2]);

        Assertions.assertEquals(Position.LEFT, game.getPoles()[0].getPole()[0].getPosition());
        Assertions.assertEquals(Position.CENTER, game.getPoles()[1].getPole()[0].getPosition());
        Assertions.assertEquals(Position.RIGHT, game.getPoles()[2].getPole()[0].getPosition());
    }

    @Test
    void isFinished() { //TODO TEST

    }

}