package tower.of.hanoi.datastructure;

import tower.of.hanoi.adt.StackADT;
import tower.of.hanoi.iterator.StackIterator;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Arraystack<T> implements StackADT<T>, Iterable<T> {

    private static final int STD_LEN = 3;

    private T[] stack;
    private int numberOfEntries;

    public Arraystack() {
        this(STD_LEN);
    }

    public Arraystack(int len) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[len];
        stack = temp;
        numberOfEntries = 0;
    }

    @Override
    public void push(T el) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        stack[numberOfEntries] = el;
        numberOfEntries++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removed = seeLast();
        numberOfEntries--;
        stack[numberOfEntries] = null;
        return removed;
    }

    @Override
    public T seeLast() {
        return stack[numberOfEntries - 1];
    }

    @Override
    public String toString() {
        return  "Stack{" +
                Arrays.toString(stack) +
                ", numberOfEntries=" + numberOfEntries +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private boolean isFull() {
        return numberOfEntries == stack.length;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(this);
    }
}
