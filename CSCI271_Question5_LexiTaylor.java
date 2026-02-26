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
* reads string s and displays it backwards
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
public class CSCI271_Question5_LexiTaylor {

/*****************************reverseRecursive****************************
* Description: reads string s and displays it backwards
*
* Parameters: s - the string
*
* Pre: s can be null or any string
*
* Post: The function is not modifying s
*
* Returns: a string that is the reverse of s
*
* Called by: main
* Calls: reverseRecursive, s.substring
************************************************************************/
    public static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) { //this is the base case, if it is empty or a single character
            return s;
        }

        String rest = s.substring(1); //reversive case: reverse everything except the first character, then add the first character to the end
        char firstChar = s.charAt(0);
        return reverseRecursive(rest) + firstChar;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Question 5: Recursive reverse of a string");
        System.out.print("Enter a string S: ");
        String s = in.nextLine();

        String reversed = reverseRecursive(s);
        System.out.println("Reversed string is: " + reversed);

        // The first test is for if the string is empty
        System.out.println("Test 1: S = \"\", expected \"\", got \"" + reverseRecursive("") + "\"");

        // The test 2 is for if it is a single character, it should return the same character
        System.out.println("Test 2: S = \"a\", expected \"a\", got \"" + reverseRecursive("a") + "\"");

        // The third test is for if there are multiple characters so just a word
        System.out.println("Test 3: S = \"hello\", expected \"olleh\", got \"" + reverseRecursive("hello") + "\"");

        // The fourth test is for if there are spaces in the string
        System.out.println("Test 4: S = \"how are you\", expected \"uoy era woh\", got \"" + reverseRecursive("how are you") + "\"");
        in.close();
    }
}
// run time: T(n) = n × Θ(1) = Θ(n)
