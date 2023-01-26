package mod9.task2;

import java.util.List;
import java.util.Objects;

public class MyLinkedList<T> implements LikedList1<T> {
    public static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(T element) {
            this.element = element;
        }
    }
    private Node<T> first;
    private Node<T> last;
    int size;

    public static <T> List<T> of(T... elements) {
        MyLinkedList<T> myLinkedList = new MyLinkedList<>();
        for (T e : elements) {
            myLinkedList.add(e);
        }
        return (List<T>) myLinkedList;
    }

    private Node<T> getNodeByIndex (int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    @Override
    public void add(int index, T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next =newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
        first=last=null;
        size=0;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedElement = prev.next.element;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
            size--;
        }
        return removedElement;
    }

    @Override
    public void add(T e) {

    }
}

