/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class CircularDoublyLinkedList {
    
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
    
    public CircularDoublyLinkedList() {
        this.head = null;
    }
    
    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
        }
        System.out.println("Inserted " + data + " at end");
    }
    
    // Insert at specific position (0-indexed)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
            if (current == head) {
                System.out.println("Position out of bounds");
                return;
            }
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
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
        
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        
        System.out.println("Deleted " + data + " from beginning");
    }
    
    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node tail = head.prev;
        int data = tail.data;
        
        if (head.next == head) {
            head = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
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
        
        do {
            if (current.data == data) {
                if (current.next == current) {
                    head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    
                    if (current == head) {
                        head = current.next;
                    }
                }
                System.out.println("Deleted " + data);
                return;
            }
            current = current.next;
        } while (current != head);
        
        System.out.println("Element " + data + " not found");
    }
    
    // Search for an element
    public boolean search(int data) {
        if (head == null) {
            System.out.println("Element " + data + " not found");
            return false;
        }
        
        Node current = head;
        int position = 0;
        
        do {
            if (current.data == data) {
                System.out.println("Element " + data + " found at position " + position);
                return true;
            }
            current = current.next;
            position++;
        } while (current != head);
        
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
        System.out.print("List (Forward): ");
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != head) {
                System.out.print(" <-> ");
            }
        } while (current != head);
        System.out.println(" -> (back to " + head.data + ")");
    }
    
    // Display the list backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head.prev;
        System.out.print("List (Backward): ");
        do {
            System.out.print(current.data);
            current = current.prev;
            if (current != head.prev) {
                System.out.print(" <-> ");
            }
        } while (current != head.prev);
        System.out.println(" -> (back to " + head.prev.data + ")");
    }
    
    // Get size of list
    public int size() {
        if (head == null) {
            return 0;
        }
        
        int count = 0;
        Node current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        
        return count;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
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
