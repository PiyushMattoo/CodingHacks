package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  LIFO Implementation
 * @author mattoop
 */
public class CustomStack {
    int numOfElements;
    Object[] stackElements;
    public static final int DEFAULT_SIZE=5;

    public CustomStack() {
        this.stackElements = new Object[DEFAULT_SIZE];
    }
    
    public Object pop() {
        if(numOfElements == 0) {
            return null;
        }
        Object element = stackElements[--numOfElements];
        stackElements[numOfElements] = null;
        return element;
    }
    
    public void push(Object element) {
        if(numOfElements >= stackElements.length) {
            increaseCapacity();
        }
        stackElements[numOfElements] = element;
        numOfElements++;
    }
    
    private void increaseCapacity() {
        int updatedNumOfElements = numOfElements * 2;
        stackElements = Arrays.copyOf(stackElements, updatedNumOfElements);
    }
    
    public int size() {
        return numOfElements;
    }
    
    public static void main(String[] str) {
        CustomStack stack = new CustomStack();
        stack.push("1");    stack.push("2");
        stack.push("3");    stack.push("4");
        System.out.println("Size before pop: " + stack.size());
        
        System.out.println("Poped Out Elem: " + stack.pop());
        
        System.out.println("Size after pop: " +stack.size());
    }
}
