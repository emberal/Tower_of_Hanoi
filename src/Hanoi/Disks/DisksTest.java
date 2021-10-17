package Hanoi.Disks;

import Hanoi.Game.Position;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DisksTest { //TODO tests

    @Rule
    private void setUp() {

    }

    @Test
    void moveTo() {

        Disks disks1 = new Disks(3, Position.CENTER);
        Disks disks2 = new Disks(1, Position.RIGHT);
        Disks disks3 = new Disks(0, Position.LEFT);
        Disks disks4 = new Disks(-1, Position.LEFT);

        Assertions.assertEquals(3, disks1.getNr());
        Assertions.assertEquals(1, disks2.getNr());
        Assertions.assertEquals(0, disks3.getNr());

        disks1.moveTo(disks2);

        Assertions.assertEquals(2, disks1.getNr());
        Assertions.assertEquals(2, disks2.getNr());

        disks3.moveTo(disks2);

        Assertions.assertEquals(0, disks3.getNr());
        Assertions.assertEquals(2, disks2.getNr());

        disks4.moveTo(disks3);

        Assertions.assertEquals(0, disks4.getNr());
        Assertions.assertEquals(0, disks3.getNr());
    }

    @Test
    void add() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void isEmpty() {
        Disks disks1 = new Disks(3, Position.CENTER);
        Disks disks2 = new Disks(1, Position.RIGHT);
        Disks disks3 = new Disks(0, Position.LEFT);
        Disks disks4 = new Disks(-1, Position.LEFT);

        Assertions.assertFalse(disks1.isEmpty());
        Assertions.assertFalse(disks2.isEmpty());
        Assertions.assertTrue(disks3.isEmpty());
        Assertions.assertTrue(disks4.isEmpty());
    }

    @Test
    void printArray() {
    }

    @Test
    void testToString() {
    }

    @Test
    void setGameSize() {
    }

    @Test
    void getNr() {
    }

    @Test
    void setNr() {
    }

    @Test
    void getDisks() {
    }

    @Test
    void setDisks() {
    }

    @Test
    void getGameSize() {
    }
}