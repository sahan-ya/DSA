/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class RabbitProblem {
    
    // Recursive approach
    public static int rabbitsRecursive(int month) {
        if (month <= 2) {
            return 1;
        }
        return rabbitsRecursive(month - 1) + rabbitsRecursive(month - 2);
    }
    
    // Iterative approach (more efficient)
    public static int rabbitsIterative(int month) {
        if (month <= 2) {
            return 1;
        }
        
        int prev2 = 1;
        int prev1 = 1;
        int current = 0;
        
        for (int i = 3; i <= month; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
    
    // Display rabbit population growth over time
    public static void displayGrowth(int months) {
        System.out.println("Rabbit Population Growth (Fibonacci Sequence):");
        System.out.println("Month\tPairs of Rabbits");
        System.out.println("-----\t----------------");
        
        for (int i = 1; i <= months; i++) {
            System.out.println(i + "\t" + rabbitsIterative(i));
        }
    }
    
    // Calculate with memoization for better performance
    public static int rabbitsMemoization(int month, int[] memo) {
        if (month <= 2) {
            return 1;
        }
        
        if (memo[month] != 0) {
            return memo[month];
        }
        
        memo[month] = rabbitsMemoization(month - 1, memo) + rabbitsMemoization(month - 2, memo);
        return memo[month];
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Rabbit Population Problem (Fibonacci) ===\n");
        
        // Problem: Start with 1 pair of rabbits. Each month, every mature pair 
        // produces a new pair. Rabbits mature after 1 month.
        
        int months = 12;
        
        // Using iterative approach
        System.out.println("Using Iterative Approach:");
        displayGrowth(months);
        
        System.out.println("\n=== Specific Month Calculations ===");
        
        // Test specific months
        int month = 10;
        System.out.println("\nMonth " + month + ":");
        System.out.println("Recursive: " + rabbitsRecursive(month) + " pairs");
        System.out.println("Iterative: " + rabbitsIterative(month) + " pairs");
        
        // Using memoization for larger values
        month = 20;
        int[] memo = new int[month + 1];
        System.out.println("\nMonth " + month + " (with memoization): " + 
                           rabbitsMemoization(month, memo) + " pairs");
        
        // Demonstrate the pattern
        System.out.println("\n=== Understanding the Pattern ===");
        System.out.println("Month 1: 1 pair (initial pair, immature)");
        System.out.println("Month 2: 1 pair (initial pair, now mature)");
        System.out.println("Month 3: 2 pairs (initial + 1 new)");
        System.out.println("Month 4: 3 pairs (previous pairs + 1 new from month 2)");
        System.out.println("Month 5: 5 pairs (previous pairs + 2 new from month 3)");
        System.out.println("Pattern: F(n) = F(n-1) + F(n-2)");
    }
}
