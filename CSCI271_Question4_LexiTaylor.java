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
* reads integer N and a single digit D and displays the number of times
* D occurs in N
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
public class CSCI271_Question4_LexiTaylor {

/*****************************countDigit****************************
* Description: Counts how many times the digit d occurs in int n
*
* Parameters: n - non- negative long int, d - digit value in n
*
* Pre: n >= 0 and 0 <= d <= 9
*
* Post: The function does not modify n
*
* Returns: The number of times digit d occurs in n as an int
*
* Called by: main
* Calls: countDigit
************************************************************************/
    
    public static int countDigit(long n, int d) {
        if (n == 0) { //base case: when n becomes 0, stop and return 0
            return 0;
        }

        int lastDigit = (int) (n % 10);
        int countNow;
        if (lastDigit == d) {
            countNow = 1;
        } else {
            countNow = 0;
        }

        return countNow + countDigit(n / 10, d); // Recurse on the remaining digits (n/10)
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Question 4: Recursive count of a digit in an integer");
        System.out.print("Enter an integer N: ");
        long N = in.nextLong();
        System.out.print("Enter a single digit D (0-9): ");
        int D = in.nextInt();

        long absN = Math.abs(N); //handling negative N by taking the absolute value. So we can ignore the sign.
        int result;

        if (absN == 0) { // if N is 0, it has exactly one digit 0
            if (D == 0) {
                result = 1; // the number 0 has 0 digits
            } else {
                result= 0; // number 0 has no other digits
            }
        } else {
            result = countDigit(absN, D);
        }
        System.out.println("Digit " + D + " appears " + result + " time in " + N + ".");

        //The first test is for if a number has multiple occurances of the same digit
        long test1 = 12345675L; 
        int d1 = 5;
        System.out.println("Test 1: N = 12345675, D = 5, expected 2, got " + countDigit(test1, d1));

        //The second test is for if a number has no occurances of a digit
        long test2 = 123456L;
        int d2 = 7;
        System.out.println("Test 2: N = 123456L, D = 7, expected 0, got " + countDigit(test2, d2));

        //The third test is for if there is a negative number, and a digit appears multiple times
        long test3 = -7494L;
        int d3 = 4;
        System.out.println("Test 3: N = -7494, D = 4, expected 2, got " + countDigit(Math.abs(test3), d3));
        in.close();
    }
}
