/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPushfriendly;

public class SinglyLinkedList {
    
    // Node class
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    public SinglyLinkedList() {
        this.head = null;
    }
    
    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            System.out.println("Inserted " + data + " at end");
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Inserted " + data + " at end");
    }
    
    // Insert at specific position (0-indexed)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int data = head.data;
        head = head.next;
        System.out.println("Deleted " + data + " from beginning");
    }
    
    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.next == null) {
            int data = head.data;
            head = null;
            System.out.println("Deleted " + data + " from end");
            return;
        }
        
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        System.out.println("Deleted " + data + " from end");
    }
    
    // Delete by value
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted " + data);
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println("Element " + data + " not found");
            return;
        }
        
        current.next = current.next.next;
        System.out.println("Deleted " + data);
    }
    
    // Search for an element
    public boolean search(int data) {
        Node current = head;
        int position = 0;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println("Element " + data + " found at position " + position);
                return true;
            }
            current = current.next;
            position++;
        }
        
        System.out.println("Element " + data + " not found");
        return false;
    }
    
    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Get size of list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("=== Insertion Operations ===");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);
        list.insertAtPosition(15, 2);
        list.display();
        
        System.out.println("\n=== Search Operations ===");
        list.search(15);
        list.search(100);
        
        System.out.println("\n=== Deletion Operations ===");
        list.deleteFromBeginning();
        list.display();
        
        list.deleteFromEnd();
        list.display();
        
        list.deleteByValue(15);
        list.display();
        
        System.out.println("\nList size: " + list.size());
    }
}