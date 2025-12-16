import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushfriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (O(1))
    public void push(int x) {
        q1.add(x);
    }

    // Pop operation (O(n))
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Move elements except last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }
    // Print stack elements
    public void printStack() {
    System.out.println("Stack elements: " + q1);
}


    public static void main(String[] args) {
        QueueStackPushfriendly stack = new QueueStackPushfriendly();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack();
        System.out.println("Popped: " + stack.pop()); // 30;
        System.out.println("Popped: " + stack.pop()); // 20
        stack.printStack();
    }
}
