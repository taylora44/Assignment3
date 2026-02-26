import java.util.Scanner;
public class CSCI271_Question6_LexiTaylor {

    public static int sumEven(int[] A, int n) {
        if (n == 0) {
            return 0;
        }

        int last = A[n - 1];
        int contribution;
        if (last % 2 == 0) {
            contribution = last;
        } else {
            contribution = 0;
        }

        return contribution + sumEven(A, n - 1); // Recursive case: call on the first n-1 elements
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Question 6: Recursive sum of even integers in an array");
        System.out.print("Enter number of integers: ");
        int n = in.nextInt();

        int[] A = new int[n];
        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int sum = sumEven(A, n); // Recursive call
        System.out.println("Sum of even integers is: " + sum);

        // First test case, no even numbers
        int[] t1 = {1, 3, 5};
        System.out.println("Test 1: [1,3,5], expected 0, got " + sumEven(t1, t1.length));

        // Second test case, all even numbers
        int[] t2 = {2, 4, 6};
        System.out.println("Test 2: [2,4,6], expected 12, got " + sumEven(t2, t2.length));
        // Third test case, mix of even and odd numbers
        int[] t3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Test 3: [1,2,3,4,5,6], expected 12, got " + sumEven(t3, t3.length));
        in.close();
    }
}
