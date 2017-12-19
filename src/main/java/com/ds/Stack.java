package com.ds;

import java.util.Arrays;

public class Stack<E> {

    private Object[] stack;
    private int size;
    private int index = -1;

    public Stack(final int size) {
        stack = new Object[size];
        this.size = size;
    }

    public void push(final E element) {
        capacityHandler();
        stack[++index] = element;
    }

    public E pop() {
        if (index < 0)
            throw new RuntimeException("Stack Underflow.");

        E element = (E) stack[index];
        index--;
        return element;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack {");
        for (int i = 0; i <= index; i++) {
            sb.append(" " + stack[i]);
        }
        sb.append(" }");
        System.out.println(sb.toString());
    }

    private void capacityHandler() {
        this.size = (index == this.size-1) ? incrementCapacity() : this.size;
    }

    private int incrementCapacity() {
        int newCapacity = this.size + this.size / 2;
        stack = Arrays.copyOf(stack, newCapacity);
        return newCapacity;
    }

}
