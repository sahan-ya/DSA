/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPushfriendly;

public class ArrayCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Enqueue operation - Add element to rear
    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }
    
    // Dequeue operation - Remove element from front
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }
    
    // Peek front element without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }
    
    // Get current size
    public int size() {
        return size;
    }
    
    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);
        
        System.out.println("Enqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        queue.display();
        
        System.out.println("\nDequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        queue.display();
        
        System.out.println("\nEnqueuing more elements:");
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        
        queue.display();
        
        System.out.println("\nFront element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Is full: " + queue.isFull());
    }
}

