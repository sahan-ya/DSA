/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class LinkedListStack {
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top;
    private int size;
    
    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }
    
    // Push element onto stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(data + " pushed to stack");
    }
    
    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return -1;
        }
        
        int poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }
    
    // Peek at top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Get size of stack
    public int size() {
        return size;
    }
    
    // Display stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        stack.display();
        
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
        stack.display();
        
        stack.push(50);
        stack.display();
        
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
