package mod9.task3;

public class MyQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    MyQueue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void add(int item) {
        System.out.println("Inserting " + item);
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        int x = arr[front];
        System.out.println("Removing " + x);
        front = (front + 1) % capacity;
        count--;
        return x;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() ==0;
    }

    public void clear() {
        count = 0;
    }
}

class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue(35);
        q.add(565);
        q.add(2);
        q.add(32);
        System.out.println("The queue size is " + q.size());
        System.out.println("The front element is " + q.peek());
        q.poll();
        System.out.println("The front element is " + q.peek());
        q.clear();
        System.out.println("The queue size after clear is " + q.size());
    }
}
