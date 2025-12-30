/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPushfriendly;

public class DoublyLinkedList {
    
    // Node class
    class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        newNode.prev = current;
        
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        
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
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        
        System.out.println("Deleted " + data + " from beginning");
    }
    
    // Delete from end
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        int data = tail.data;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        
        System.out.println("Deleted " + data + " from end");
    }
    
    // Delete by value
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Element " + data + " not found");
            return;
        }
        
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        
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
    
    // Display the list forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("List (Forward): null <- ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    // Display the list backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = tail;
        System.out.print("List (Backward): null <- ");
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println(" -> null");
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
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("=== Insertion Operations ===");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);
        list.insertAtPosition(15, 2);
        list.displayForward();
        list.displayBackward();
        
        System.out.println("\n=== Search Operations ===");
        list.search(15);
        list.search(100);
        
        System.out.println("\n=== Deletion Operations ===");
        list.deleteFromBeginning();
        list.displayForward();
        
        list.deleteFromEnd();
        list.displayForward();
        
        list.deleteByValue(15);
        list.displayForward();
        
        System.out.println("\nList size: " + list.size());
    }
}

