import java.util.Stack;

//Enqueue Friendly
public class StackQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation (O(1))
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue operation (O(n))
    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }
    
    // Print queue elements
    public void printQueue() {
    System.out.println("Queue elements: " + s1 + s2);
}


    public static void main(String[] args) {
        StackQueue q = new StackQueue();
        q.enqueue(100);
        q.enqueue(200);
        q.enqueue(300);

        q.printQueue();
        System.out.println("Popped: " + q.dequeue()); // 100
        System.out.println("Popped: " + q.dequeue()); // 200
        q.printQueue();
    }
}
