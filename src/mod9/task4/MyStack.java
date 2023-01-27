package mod9.task4;

public class MyStack {
    private int size;
    private int[] StackHolder;
    private int top;

    public MyStack(int size) {
        this.size = size;
        StackHolder = new int[size];
        top = -1;

    }

    public void push(int element) {
        if (!isFull()) {
            top++;
            StackHolder[top] = element;
            System.out.println("Push element " + element);
        }
    }

    public void size() {
        System.out.println("Size " + top);
    }

    public void clear() {
        for (int i = 0; i < top; i++) {
            StackHolder[i] = Integer.parseInt(null);
        }
        top = 0;
    }

    public void remove(int actualIndex) {
        for (int a = actualIndex; a < top; a++) {
            StackHolder[a] = StackHolder[a + 1];
            StackHolder[top] = Integer.parseInt(null);
            top--;
            System.out.println("Remove elevent " + actualIndex);
        }
        if (StackHolder.length > size && top < StackHolder.length / 2) {
            System.out.println("Remove elevent " + actualIndex);
        }
    }

    public int peek() {
        return StackHolder[top];
    }

    public int pop() {
        return StackHolder[top--];
    }

    public Boolean isEmpty() {
        return (top == -1);
    }

    public Boolean isFull() {
        return (top == size - 1);
    }
}
