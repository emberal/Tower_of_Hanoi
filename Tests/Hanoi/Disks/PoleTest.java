package Hanoi.Disks;

import Hanoi.Game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PoleTest {

    private Pole pole1;
    private Pole pole2;
    private Pole pole3;

    void setUp() {
        pole1 = new Pole(3, Position.CENTER);
        pole2 = new Pole(0, Position.RIGHT);
        pole3 = new Pole(0, Position.LEFT);
    }

    @Test
    void moveTo() {

        setUp();

        Assertions.assertEquals(3, pole1.getNr());
        Assertions.assertEquals(0, pole2.getNr());
        Assertions.assertEquals(0, pole3.getNr());

        Assertions.assertTrue(pole1.moveTo(pole2));

        Assertions.assertEquals(2, pole1.getNr());
        Assertions.assertEquals(1, pole2.getNr());

        Assertions.assertFalse(pole3.moveTo(pole2));

        Assertions.assertEquals(0, pole3.getNr());
        Assertions.assertEquals(1, pole2.getNr());
    }

    @Test
    void add() {

        setUp();

        Assertions.assertFalse(pole1.add(new Disk(Position.RIGHT)));
        Assertions.assertTrue(pole2.add(new Disk(Position.RIGHT)));
        Assertions.assertTrue(pole3.add(new Disk(Position.RIGHT)));

        Assertions.assertEquals(3, pole1.getNr());
        Assertions.assertEquals(1, pole2.getNr());
        Assertions.assertEquals(1, pole3.getNr());

    }

    @Test
    void removeLast() {

        setUp();

        pole1.removeLast();
        pole2.removeLast();
        pole3.removeLast();

        Assertions.assertEquals(2, pole1.getNr());
        Assertions.assertEquals(0, pole2.getNr());
        Assertions.assertEquals(0, pole3.getNr());

    }

    @Test
    void removeDisk () {

        setUp();

        pole1.removeDisk(1);

        Assertions.assertEquals(2, pole1.getNr());

    }

    @Test
    void isLegal() {

        setUp();

        Assertions.assertTrue(pole1.isLegal(pole2));
        Assertions.assertTrue(pole1.moveTo(pole2));

        Assertions.assertFalse(pole1.isLegal(pole2));
        Assertions.assertFalse(pole1.moveTo(pole2));

        Assertions.assertFalse(pole3.isLegal(pole2));
        Assertions.assertFalse(pole3.moveTo(pole2));

        Assertions.assertTrue(pole2.isLegal(pole3));
        Assertions.assertTrue(pole2.moveTo(pole3));
    }

    @Test
    void seeLast() {
    }

    @Test
    void isEmpty() {

        setUp();

        Assertions.assertFalse(pole1.isEmpty());
        Assertions.assertTrue(pole2.isEmpty());

        Assertions.assertTrue(pole3.isEmpty());
    }

    @Test
    void printArray() { //TODO TEST

        setUp();

        pole1.printArray();
        pole2.printArray();
        pole3.printArray();

        //new Pole().printArray();

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