package app;

import java.util.Vector;

public class StackVector<T> implements Stack<T> {

    private Vector<T> data;

    public StackVector() {
        data = new Vector<>();
    }

    @Override
    public void push(T item) {
        data.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return data.lastElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}

