package dataStructures;

import java.util.Arrays;

/**
 *
 * @author mattoop
 */
public class StackWithMaxImpl implements StackWithMax {
    int numOfElements;
    int numOfElementsInMaxStack;
    Integer[] stackElements;
    Integer[] maxStackElements;
    public static final int DEFAULT_SIZE=5;
    
    public StackWithMaxImpl() {
        this.stackElements = new Integer[DEFAULT_SIZE];
        this.maxStackElements = new Integer[DEFAULT_SIZE];
    }
    
    public int getMaximum() {
        if (numOfElementsInMaxStack == 0) {
            return Integer.MIN_VALUE;
        } else {
            return maxStackElements[numOfElementsInMaxStack-1];
        }
    }
    
     /**
     * pop the item from the top.
     */
    public int pop() {
        if (numOfElements == 0) {
            return Integer.MIN_VALUE;
        }
        Integer element = stackElements[--numOfElements];
        stackElements[numOfElements] = null;
        //numOfElements--;
        
        if(element == getMaximum()) {
            Integer maxElement = maxStackElements[numOfElementsInMaxStack-1];
            maxStackElements[numOfElementsInMaxStack-1] = null;
            //numOfElementsInMaxStack--;
        }
        return element;
    }

    /**
     * push pItem onto the stack
     */
    public void push(int pItem) {
        if (numOfElements >= stackElements.length) {
            increaseCapacity();
        }
        stackElements[numOfElements] = pItem;
        numOfElements++;
        
        if(pItem >= getMaximum()) {
            maxStackElements[numOfElementsInMaxStack] = pItem;
            numOfElementsInMaxStack++;
        }
    }
    
    private void increaseCapacity() {
        int updatedNumOfElements = numOfElements * 2;
        stackElements = Arrays.copyOf(stackElements, updatedNumOfElements);
    }

    /**
     * return the value at the top of the stack.
     */
    public int peek() {
        if (numOfElements == 0) {
            return Integer.MIN_VALUE;
        } else {
            return stackElements[numOfElements-1];
        }
    }
    
    public int size() {
        return numOfElements;
    }
    
    public static void main(String[] str) {
        StackWithMaxImpl stackWithMaxImpl = new StackWithMaxImpl();
        stackWithMaxImpl.push(5);    
        stackWithMaxImpl.push(2);
        stackWithMaxImpl.push(7);    
        stackWithMaxImpl.push(4);
        System.out.println("Size before pop: " + stackWithMaxImpl.size());
        System.out.println("Current top element: " + stackWithMaxImpl.peek());
        System.out.println("Poped Out Elem: " + stackWithMaxImpl.pop());
        System.out.println("Size after first pop: " +stackWithMaxImpl.size());
        System.out.println("Poped Out Elem: " + stackWithMaxImpl.pop());
        System.out.println("Size after second pop: " +stackWithMaxImpl.size());
    }
    
}
