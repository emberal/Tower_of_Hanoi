package tower.of.hanoi.iterator;

import tower.of.hanoi.adt.StackADT;
import tower.of.hanoi.datastructure.Arraystack;

import java.util.Iterator;

public class StackIterator<T> implements Iterator<T> {

    private StackADT<T> stack;
    private int currentIndex;

    public StackIterator(StackADT<T> stack) {
        this.stack = stack;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex == stack.getNumberOfEntries();
    }

    @Override
    public T next() {
        currentIndex++;
        return stack.pop();
    }
}
