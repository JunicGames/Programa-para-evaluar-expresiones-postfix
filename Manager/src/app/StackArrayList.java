package app;

import java.util.ArrayList;

public class StackArrayList<T> implements Stack<T> {

    private ArrayList<T> data;

    public StackArrayList() {
        data = new ArrayList<>();
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
        return data.get(data.size() - 1);
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

