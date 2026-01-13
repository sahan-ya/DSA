/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class InsertionSort {
    
    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int shifts = 0;
        
        System.out.println("Starting Insertion Sort...");
        System.out.println("Initial array: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            System.out.println("Pass " + i + ": Inserting " + key);
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }
            if (j >= 0) comparisons++; // Count the final comparison
            
            arr[j + 1] = key;
            
            System.out.println("  After insertion: " + arrayToString(arr));
        }
        
        System.out.println("\nComparisons: " + comparisons);
        System.out.println("Shifts: " + shifts);
    }
    
    // Insertion Sort with detailed step-by-step output
    public static void insertionSortDetailed(int[] arr) {
        int n = arr.length;
        
        System.out.println("Detailed Insertion Sort Process:");
        System.out.println("Initial: " + arrayToString(arr));
        System.out.println();
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            System.out.println("Step " + i + ":");
            System.out.println("  Key to insert: " + key + " (at index " + i + ")");
            System.out.println("  Sorted portion: " + arrayToString(arr, 0, i));
            
            // Move elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            
            System.out.println("  Result: " + arrayToString(arr));
            System.out.println();
        }
    }
    
    // Helper method to display array
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    // Helper method to display array portion
    public static String arrayToString(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < end; i++) {
            sb.append(arr[i]);
            if (i < end - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    // Helper method to copy array
    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Insertion Sort Algorithm ===\n");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array: " + arrayToString(arr));
        System.out.println();
        
        insertionSort(copyArray(arr));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Detailed version
        int[] arr2 = {5, 2, 4, 6, 1, 3};
        insertionSortDetailed(arr2);
        
        // Test with already sorted array
        System.out.println("=== Testing with Already Sorted Array ===\n");
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("Array: " + arrayToString(sortedArr));
        insertionSort(sortedArr);
        
        // Test with reverse sorted array
        System.out.println("\n=== Testing with Reverse Sorted Array ===\n");
        int[] reverseArr = {5, 4, 3, 2, 1};
        System.out.println("Array: " + arrayToString(reverseArr));
        insertionSort(reverseArr);
        
        System.out.println("\n=== Key Insights ===");
        System.out.println("- Best case (sorted): O(n) - only comparisons, no shifts");
        System.out.println("- Worst case (reverse sorted): O(n²) - maximum shifts");
        System.out.println("- Efficient for small or nearly sorted arrays");
        System.out.println("- Stable sort - maintains relative order of equal elements");
    }
}
