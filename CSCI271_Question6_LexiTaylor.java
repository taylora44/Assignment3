/*************************************************************************
* Assignment 3 for CSCI 271-001 Spring 2026
*
* Author: Lexi Taylor
* OS: Windows
* Compiler: javac
* Date: February 25, 2026
*
* Purpose
* This program is one part of a six part project. This specific question
* reads a a list of integers from the keyboard and stores them in an array
* then the program will sum all numbers in the array together
*
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Lexi Taylor>
********************************************************************/
import java.util.Scanner;
public class CSCI271_Question6_LexiTaylor {

/*****************************SumDigit****************************
* Description: calculates the sum of numbers in an array
*
* Parameters: n - non-negative number
*
* Pre: n >= 0
*
* Post: The function does not modify n
*
* Returns: The sum of all products in the array
*
* Called by: main
* Calls: sumDigitPairs
************************************************************************/
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
// run time: T(n) = n × Θ(1) = Θ(n)
