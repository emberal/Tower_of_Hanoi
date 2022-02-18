package tower.of.hanoi.adt;

public interface StackADT<T> {

    /**
     * Push an object to the back of the stack
     * @param el An object
     * @return true if successfully pushed, false otherwise
     * @throws IndexOutOfBoundsException
     */
    void push(T el);

    /**
     * Pops the object at the back of the stack
     * @return The object at the back of the stack
     * @throws java.util.EmptyStackException
     */
    T pop();

    /**
     * Returns the object at the back of the stack, without removing it
     * @return The object at the back of the stack
     * @throws java.util.EmptyStackException
     */
    T seeLast();

    /**
     * Returns the number of entries int the stack
     * @return Number of entries in the stack
     */
    int getNumberOfEntries();

    /**
     * Checks if the stack is empty
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

}
