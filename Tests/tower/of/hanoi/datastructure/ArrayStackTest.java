package tower.of.hanoi.datastructure;

import tower.of.hanoi.adt.StackADT;
import tower.of.hanoi.adt.StackADTTest;
import tower.of.hanoi.disks.Disk;

public class ArrayStackTest extends StackADTTest {

    @Override
    protected StackADT<Disk> reset() {
        return new Arraystack<>();
    }

}
