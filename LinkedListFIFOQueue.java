/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class LinkedListFIFOQueue {
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node front;
    private Node rear;
    private int size;
    
    public LinkedListFIFOQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    // Enqueue (add element to rear)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(data + " enqueued to queue");
    }
    
    // Dequeue (remove element from front)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue from empty queue");
            return -1;
        }
        
        int dequeuedData = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        return dequeuedData;
    }
    
    // Peek at front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // Get size of queue
    public int size() {
        return size;
    }
    
    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        queue.display();
        
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        queue.display();
        
        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();
        
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
