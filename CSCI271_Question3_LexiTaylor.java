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
* reads a list of integers and stores them in an array, then finds
* the maximum integer
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
public class CSCI271_Question3_LexiTaylor {

/*****************************maxRecursive****************************
* Description: Finds the maximum integer value amond the first n 
* in the array arr.
*
* Parameters: arr - array of integers, n - number of elements from
* the start of arr
*
* Pre: n >= 1 and arr has at leas n elements
*
* Post: The function does not modify arr
*
* Returns: The maximum value amond arr[] as an int
*
* Called by: main
* Calls: maxRecursive
************************************************************************/

    public static int maxRecursive(int[] arr, int n) {
        if (n ==1) { // base case: only one element
            return arr[0];
        }

        int maxOfRest = maxRecursive(arr, n - 1); // Recursive case: maximum of the first number of elements is the maximum between the last element and the maximum of the first
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

        // This first test is for if the array hasa length of one, the max should be one.
        int[] test1 = {5};
        System.out.println("Test 1: [5], expected 5, got " + maxRecursive(test1, test1.length));

        // The second test is for if there is an increasing sequence, the maximum is the last number.
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: [1,2,3,4,5], expected 5, got " + maxRecursive(test2, test2.length));

        // The third test is for if an array has positive or negative numbers.
        int[] test3 = {-3, 7, 0, -1, 2};
        System.out.println("Test 3: [-3,7,0,-1,2], expected 7, got " + maxRecursive(test3, test3.length));

        in.close();
    }
}
// run time: T(n) = n × Θ(1) = Θ(n)

