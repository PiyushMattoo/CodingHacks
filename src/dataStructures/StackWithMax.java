package dataStructures;

/**
 *
 * @author mattoop
 */
public interface StackWithMax {

    /**
     * pop the item from the top.
     */
    int pop();

    /**
     * push pItem onto the stack
     */
    void push(int pItem);

    /**
     * return the value at the top of the stack.
     */
    int peek();

    /**
     * return the maximum int in the stack, do NOT change the stack.
     */
    int getMaximum();
}
