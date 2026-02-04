package stack;

public interface Stack<T> {
    void push(T element);
    T pop() throws Exception;
    T peek() throws Exception;
    boolean isEmpty();
    int size();
}
