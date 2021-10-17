package Hanoi.Game;

import Hanoi.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest { //TODO tests

    @Test
    void constructor() {

        Game game = new Game(Main.DISKS);

        Assertions.assertEquals(3, game.getPoles()[0].getNr());
        Assertions.assertEquals(0, game.getPoles()[1].getNr());
        Assertions.assertEquals(0, game.getPoles()[2].getNr());

        Assertions.assertEquals(Position.LEFT, game.getPoles()[0].getPole()[0].getPosition());
        Assertions.assertNull(game.getPoles()[1].getPole()[0]);
        Assertions.assertNull(game.getPoles()[2].getPole()[0]);
    }

}