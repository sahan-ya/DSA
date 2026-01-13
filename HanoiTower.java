/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class HanoiTower {
    
    // Counter for number of moves
    private static int moveCount = 0;
    
    // Recursive solution for Tower of Hanoi
    public static void solveHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            moveCount++;
            System.out.println("Move " + moveCount + ": Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary using destination
        solveHanoi(n - 1, source, auxiliary, destination);
        
        // Move the nth disk from source to destination
        moveCount++;
        System.out.println("Move " + moveCount + ": Move disk " + n + " from " + source + " to " + destination);
        
        // Move n-1 disks from auxiliary to destination using source
        solveHanoi(n - 1, auxiliary, destination, source);
    }
    
    // Calculate minimum number of moves required
    public static int minimumMoves(int n) {
        return (int) Math.pow(2, n) - 1;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Tower of Hanoi Problem ===\n");
        
        int numberOfDisks = 3;
        
        System.out.println("Number of disks: " + numberOfDisks);
        System.out.println("Minimum moves required: " + minimumMoves(numberOfDisks));
        System.out.println("\nSolution Steps:");
        System.out.println("---------------");
        
        // Reset move counter
        moveCount = 0;
        
        // Solve Tower of Hanoi
        // A = Source rod, C = Destination rod, B = Auxiliary rod
        solveHanoi(numberOfDisks, 'A', 'C', 'B');
        
        System.out.println("\nTotal moves made: " + moveCount);
        
        // Test with different number of disks
        System.out.println("\n=== Testing with 4 disks ===\n");
        numberOfDisks = 4;
        System.out.println("Number of disks: " + numberOfDisks);
        System.out.println("Minimum moves required: " + minimumMoves(numberOfDisks));
        System.out.println("\nSolution Steps:");
        System.out.println("---------------");
        
        moveCount = 0;
        solveHanoi(numberOfDisks, 'A', 'C', 'B');
        
        System.out.println("\nTotal moves made: " + moveCount);
        
        // Show pattern for different disk counts
        System.out.println("\n=== Moves Required for Different Disk Counts ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " disk(s): " + minimumMoves(i) + " moves");
        }
    }
}
