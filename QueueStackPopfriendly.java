import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (O(n))
    public void push(int x) {
        q2.add(x);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation (O(1))
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }
    
    // Print stack elements
    public void printStack() {
    System.out.println("Stack elements: " + q1);
}


    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        stack.push(5);
        stack.push(15);
        stack.push(25);

        stack.printStack();
        System.out.println("Popped: " + stack.pop()); // 25
        System.out.println("Popped: " + stack.pop()); // 15
        stack.printStack();
    }
}
