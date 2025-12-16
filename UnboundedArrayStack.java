public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        stack = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push(int x) {
        if (top == capacity - 1) {
            resize(capacity * 2); // Increase size
        }
        stack[++top] = x;
    }

    // Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int popped = stack[top--];

        // Reduce size if necessary
        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }

        return popped;
    }

    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }
    
    // Print stack elements
    public void printStack() {
    System.out.print("Stack elements: ");
    for (int i = 0; i <= top; i++) {
        System.out.print(stack[i] + " ");
    }
    System.out.println();
}


    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.printStack();
        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());
        s.printStack();
    }
}
