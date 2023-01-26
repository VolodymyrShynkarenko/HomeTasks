package mod9.task2;

public interface LikedList1<T> {
    

    void add(int index, T element);

    public default int size() {
        return size();
    }

    boolean isEmpty();

    void clear();

    T get(int index);

    T set(int index, T element);

    T remove(int index);

    void add(T e);
}
