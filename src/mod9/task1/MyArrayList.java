package mod9.task1;

import java.util.Objects;


public class MyArrayList<T> {
    private T[] data;
    private int size;

    public MyArrayList() {
        data = (T[]) new Object[16];
        size = 0;
    }

    public void add(T value) {
        if (size == data.length) {
            T[] newData = (T[]) new Object[data.length * 2];

            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = value;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Назар");
        list.add("ni");
        list.add("niof");

        System.out.println(list);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(0) = " + list.get(2));
        list.remove(1);
        System.out.println("list after remove = " + list.size());
        list.clear();
        System.out.println("list clear " + list.size());;
    }
}