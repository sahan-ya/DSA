/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSA;

public class OptimizedBubbleSort {
    
    // Optimized Bubble Sort with Early Termination
    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        boolean swapped;
        
        System.out.println("Starting Optimized Bubble Sort...");
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            
            System.out.println("After pass " + (i + 1) + ": " + arrayToString(arr));
            
            // If no swaps occurred, array is sorted
            if (!swapped) {
                System.out.println("No swaps in this pass - array is sorted!");
                break;
            }
        }
        
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
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
        System.out.println("=== Optimized Bubble Sort Algorithm ===\n");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array: " + arrayToString(arr));
        System.out.println();
        
        optimizedBubbleSort(arr);
        
        System.out.println("\nFinal sorted array: " + arrayToString(arr));
        
        // Test with already sorted array (shows optimization benefit)
        System.out.println("\n=== Testing with Already Sorted Array ===");
        System.out.println("(This shows the optimization advantage)\n");
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("Array: " + arrayToString(sortedArr));
        optimizedBubbleSort(sortedArr);
        System.out.println("\nNotice: Only 1 pass needed instead of 4!");
        
        // Test with nearly sorted array
        System.out.println("\n=== Testing with Nearly Sorted Array ===\n");
        int[] nearlySorted = {1, 2, 5, 3, 4};
        System.out.println("Array: " + arrayToString(nearlySorted));
        optimizedBubbleSort(nearlySorted);
        
        // Test with reverse sorted array
        System.out.println("\n=== Testing with Reverse Sorted Array ===\n");
        int[] reverseArr = {5, 4, 3, 2, 1};
        System.out.println("Array: " + arrayToString(reverseArr));
        optimizedBubbleSort(reverseArr);
    }
}
