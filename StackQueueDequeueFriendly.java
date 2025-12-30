/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPushfriendly;

import java.util.Stack;

public class StackQueueDequeueFriendly {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation (costly)
    public void enqueue(int data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation (efficient)
    public int dequeue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.pop();
    }

        // Print queue elements
    public void printQueue() {
    System.out.println("Queue elements: " + stack1 + stack2);
}
    
    public static void main(String[] args) {
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.printQueue();
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        q.printQueue();
    }
}
