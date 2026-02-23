import java.util.Scanner;
public class CSCI271_Question3_LexiTaylor {

    public static int maxRecursive(int[] arr, int n) {
        if (n ==1) { // only one element
            return arr[0];
        }

        int maxOfRest = maxRecursive(arr, n - 1); // maximum of the first number of elements is the maximum between the last element and the maximum of the first
        if (arr[n - 1] > maxOfRest) {
            return arr[n - 1];
        } else {
            return maxOfRest;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Question 3: Recursive maximum in an array");
        System.out.print("Enter number of integers (no commas just spaces): ");
        int n = in.nextInt();

        int[] A = new int[n]; // loop for the array
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        int max = maxRecursive(A, n);
        System.out.println("Maximum value in the array is: " + max);

        // This test is for if the array hasa length of one, the max should be one.
        int[] test1 = {5};
        System.out.println("Test 1: [5], expected 5, got " + maxRecursive(test1, test1.length));

        // Test 2 is for if there is an increasing sequence, the maximum is the last number.
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: [1,2,3,4,5], expected 5, got " + maxRecursive(test2, test2.length));

        // Test 3 is for if an array has positive or negative numbers.
        int[] test3 = {-3, 7, 0, -1, 2};
        System.out.println("Test 3: [-3,7,0,-1,2], expected 7, got " + maxRecursive(test3, test3.length));

        in.close();
    }
}


