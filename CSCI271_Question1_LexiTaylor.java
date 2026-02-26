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
* reads a string and displays the length of the string to the user.
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
public class CSCI271_Question1_LexiTaylor {

/*****************************Recursive Length****************************
* Description: Displays the length of a string
*
* Parameters: s - the string
*
* Pre: s can be null or any string
*
* Post: The function is not modifying s
*
* Returns: The number of characters as s as an int
*
* Called by: main
* Calls: recursiveLength, s.substring
************************************************************************/
    public static int recursiveLength(String s) {
        if (s == null || s.equals("") ) { //if s is null there is no string that was passed so it would be 0
        //if s is empty then it would also be 0 characters
            return 0;
        }

        return 1 + recursiveLength(s.substring(1)); //count 1 for first character plus the length of the rest
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Question 1: Recursive string length");
        System.out.print("Enter a string: ");
        String s = in.nextLine();

        int length = recursiveLength(s);
        System.out.println("The length of the string is: " + length);
        // First test is for if the string is empty
        System.out.println("Test 1: empty string, expected 0, got " + recursiveLength(""));
        // Second test is for if the string is one word with no spaces
        System.out.println("Test 2: \"hello\", expected 5, got " + recursiveLength("hello"));
        // Third test is for if the string has spaces, it will include the spaces
        System.out.println("Test 3: \"how are you\", expected 11, got " + recursiveLength("how are you"));

        in.close();
    }
}
// run time: T(n) = n × Θ(1) = Θ(n)
