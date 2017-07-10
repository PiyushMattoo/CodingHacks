package com.codinghacks.java;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * FIFO
 * @author mattoop
 */
public class CustomQueue {
    int size;
    Object[] elements = null;
    private final static int DEFAULT_SIZE=5;
    
    public CustomQueue() {
        elements = new Object[DEFAULT_SIZE];
    }
    
    public void queue(Object obj) {
        if(size >= elements.length) {
            increaseQueueCapacity();
        }
        elements[size] = obj;
        size++;
    }
    
    public Object dequeue() {
        elements[0] = null;
        elements[0] = elements[1];
        size--;
        return elements;
    }
    
    public void increaseQueueCapacity() {
        int newSize = size*2;
        elements = Arrays.copyOf(elements, newSize);
    }
    
    public Object peek() {
        if(size ==0) {
            throw new NoSuchElementException("Cannot peek inside Empty queue");
        }
        return elements[size-1];
    }
    
    public int getSize() {
        return size;
    }
}
