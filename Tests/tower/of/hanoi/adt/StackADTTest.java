package tower.of.hanoi.adt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tower.of.hanoi.disks.Disk;
import tower.of.hanoi.game.Position;

import java.util.EmptyStackException;

public abstract class StackADTTest {

    private StackADT<Disk> disks;
    private Disk d0, d1, d2;

    protected abstract StackADT<Disk> reset();

    @BeforeEach
    void setup() {
        disks = reset();
        d0 = new Disk(Position.LEFT, 0);
        d1 = new Disk(Position.LEFT, 1);
        d2 = new Disk(Position.LEFT, 2);
    }

    @Test
    void pushAndPop() {
        try {
            disks.push(d0);
            disks.push(d1);
            disks.push(d2);
        }
        catch (Exception e) {
            Assertions.fail();
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> disks.push(d0));
        try {
            Assertions.assertEquals(d2, disks.pop());
            Assertions.assertEquals(d1, disks.pop());
            Assertions.assertEquals(d0, disks.pop());
        }
        catch (Exception e) {
            Assertions.fail();
        }
        Assertions.assertThrows(EmptyStackException.class, () -> disks.pop());

    }

}
