package mod9.task1;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int index = 0;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
    }

    public void add(T value) {
        if (index == data.length - 1) {
            resize(data.length * 2);
            List<String> arra = new ArrayList<>();
        }
        data[index++] = value;
    }

    public void resize(int newSize) {
        Object[] coppiedAray = new Object[newSize];
        System.arraycopy(data, 0, coppiedAray, 0, index);
        data = coppiedAray;
    }

    public void clear() {
        for (int i = 0; i < index; i++) {
            data[i] = null;
        }
        index = 0;
    }

    public void remove(int actualIndex) {
        for (int a = actualIndex; a < index; a++) {
            data[a] = data[a + 1];
            data[index] = null;
            index--;
        }
        if (data.length > INIT_SIZE && index < data.length / 2) {
            resize(data.length / 2);
        }
    }

    public T get(int i) {
        return (T) data[i];
    }

    public int size() {
        return index;
    }
}