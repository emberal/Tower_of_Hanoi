package tower.of.hanoi.disks;

import tower.of.hanoi.game.Position;
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

        Assertions.assertEquals(3, pole1.getNrOfDisks());
        Assertions.assertEquals(0, pole2.getNrOfDisks());
        Assertions.assertEquals(0, pole3.getNrOfDisks());

        Assertions.assertTrue(pole1.moveTo(pole2));

        Assertions.assertEquals(2, pole1.getNrOfDisks());
        Assertions.assertEquals(1, pole2.getNrOfDisks());

        Assertions.assertFalse(pole3.moveTo(pole2));

        Assertions.assertEquals(0, pole3.getNrOfDisks());
        Assertions.assertEquals(1, pole2.getNrOfDisks());
    }

    @Test
    void add() {

        setUp();

        pole1.getPole().push(new Disk(Position.RIGHT, 2));
        pole2.getPole().push(new Disk(Position.RIGHT, 1));
        pole3.getPole().push(new Disk(Position.RIGHT, 0));

        Assertions.assertEquals(3, pole1.getNrOfDisks());
        Assertions.assertEquals(1, pole2.getNrOfDisks());
        Assertions.assertEquals(1, pole3.getNrOfDisks());

    }

    @Test
    void removeLast() {

        setUp();

        pole1.getPole().pop();
        pole2.getPole().pop();
        pole3.getPole().pop();

        Assertions.assertEquals(2, pole1.getNrOfDisks());
        Assertions.assertEquals(0, pole2.getNrOfDisks());
        Assertions.assertEquals(0, pole3.getNrOfDisks());

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

        System.out.println(pole1);
        System.out.println(pole2);
        System.out.println(pole3);

    }

}