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
   // peek() повертає перший елемент стеку
    //push(Object value) додає елемент в кінець
    //size() повертає розмір колекції
    //clear() очищає колекцію

    //remove(int index) видаляє елемент за індексом


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


//private class Node
//    {
//        private Element    item;
//        private Node next;
//    }
//
//    // The top of the stack (the most recently added item)
//    private Node first = null;
//
//    // Add a new string to the stack
//    public void push(Element s)
//    {
//        Node node = new Node();
//        node.item = s;
//        node.next = first;
//        first = node;
//    }
//
//    // Remove the most recently added string
//    public Element pop()
//    {
//        if (first == null){
//            throw new RuntimeException("Stack is empty!");
//        }
//
//        Element result = first.item;
//        first = first.next;
//        return result;
//    }
//
//    // Return the item at the specified 0-based index of the Stack.
//    // Throws an exception if index is not valid.
//    public Element elementAt(int index)
//    {
//        int i = 0;
//        Node current = first;
//        if ( index < size() && index >= 0)
//        {
//            while (current != null)
//            {
//                if (i == index)
//                {
//                    return current.item;
//                }
//                i++;
//                current = current.next;
//            }
//            return null;
//        }
//        else
//            throw new RuntimeException("Invalid index!");
//    }
//
//    // Return the index of the specified element in the Stack.
//    // Returns -1 if we couldn't find the element.
//    public int indexOf(Element element)
//    {
//        int i = 0;
//        Node current = first;
//        while (i < size())
//        {
//            if(current.item == element)
//                return i;
//            current = current.next;
//            i++;
//        }
//        return -1;
//    }
//
//    // Find out how many items are currently in the stack
//    public int size()
//    {
//        int result = 0;
//        Node current = first;
//        while (current != null)
//        {
//            result++;
//            current = current.next;
//        }
//        return result;
//    }
//
//    // Peek at the top of the stack without removing the item
//    public Element peek()
//    {
//        if (first == null)
//            throw new RuntimeException("Stack is empty!");
//        return first.item;
//    }
//
//    // Check if the stack is empty
//    public boolean isEmpty()
//    {
//        return (first == null);
//    }
//
//    // Return a string representation of the stack
//    public String toString()
//    {
//        String result = "";
//        Node current = first;
//        while (current != null)
//        {
//            if (current != first)
//                result += " ";
//            result += current.item;
//            current = current.next;
//        }
//        return result;
//    }
//
//    // Main test method, adds a sentence to the stack print in reverse order
//    public static void main(String [] args)
//    {
//        // First try a Stack of String objects
//        MyStack<String> s1 = new MyStack<String>();
//        s1.push("it");
//        s1.push("was");
//        s1.push("the");
//        s1.push("best");
//        s1.push("of");
//        s1.push("times");
//        System.out.println("S1 after adding: " + s1 + ", size = " + s1.size());
//        System.out.println("S1 peek = " + s1.peek());
//        System.out.println("S1 indexOf(best) = " + s1.indexOf("best"));
//        System.out.println("S1 indexOf(blah) = " + s1.indexOf("blah"));
//        System.out.println("S1 elementAt(1) = " + s1.elementAt(1));
//        while (!s1.isEmpty())
//            System.out.println("S1 popped: " + s1.pop() + ", stack = " + s1);
//        System.out.println();
//
//        // Now lets try a Stack of integers.
//        // Generic collections need objects, so we can't put in a primitive int.
//        // We use the Integer wrapper class instead.
//        MyStack<Integer> s2 = new MyStack<Integer>();
//
//        // We can push primitive ints since Java autoboxing will handle
//        // converting to an Integer wrapper object.
//        s2.push(10);
//        s2.push(20);
//        s2.push(30);
//        s2.push(40);
//        System.out.println("S2 after adding: " + s2 + ", size = " + s1.size());
//        System.out.println("S2 peek = " + s2.peek());
//        while (!s2.isEmpty())
//            System.out.println("S2 popped: " + s2.pop() + ", stack = " + s2);
//    }
//}