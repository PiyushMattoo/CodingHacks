package com.codinghacks.java;

import java.util.ArrayList;
import java.util.List;

/**
 *  LIFO Implementation
 * @author mattoop
 */
public class CustomStack {
    int numOfElements;
    List<Object> stackElements;

    public CustomStack() {
        this.stackElements = new ArrayList<>();
    }
    
    public Object pop() {
        numOfElements--;
        Object element = stackElements.get(stackElements.size()-1);
        return element;
    }
    
    public void push(Object element) {
        stackElements.add(element);
        numOfElements++;
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
