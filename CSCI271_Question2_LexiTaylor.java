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
* reads a string and single character c and displays the number of times
* c occurs in s
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
public class CSCI271_Question2_LexiTaylor {

/*****************************CountChar****************************
* Description: Recursively counts how many times c occurs in s
*
* Parameters: s - the string, c - the character we are counting
*
* Pre: s can be null or any string
*
* Post: The function is not modifying s
*
* Returns: The number of times c appears in s as an int
*
* Called by: main
* Calls: countChar, s.substring
************************************************************************/

    public static int countChar(String s, char c) {
        if (s == null || s.length() == 0) { //base case where null is a empty string
            return 0;
        }

        int firstCount;
        if (s.charAt(0) == c) { //takes first character of string
            firstCount = 1;
        } else {
            firstCount = 0;
        }
        return firstCount + countChar(s.substring(1), c); //counts how many times c appears first, and how many times it appears.
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Reads string s
        System.out.println("Question 2: Recursive count of a character in a string");
        System.out.print("Enter a string S: ");
        String s = in.nextLine();
        // Reads character c
        System.out.print("Enter a single character C: ");
        String cStr = in.nextLine();
        // Making sure the user only enters ONE character
        while (cStr.length() !=1) {
            System.out.print("Please enter ONE character: ");
            cStr = in.nextLine();
        }
        char c = cStr.charAt(0);

        int count = countChar(s, c); //calling the recursive function
        System.out.println("Character '" +c + "' appears " + count + " time(s) in S.");

        // The first test is for if the character is not in the string at all.
        System.out.println("Test 1: S = \"abc\", C = 'z', expected 0, got " + countChar("abc", 'z'));
        // The second test is for if the character appears a couple of times.
        System.out.println("Test 2: S = \"banana\", C = 'a', expected 3, got " + countChar("banana", 'a'));
        // The third test is for if the entire word (string) is made of all the same characters.
        System.out.println("Test 3: S = \"aaa\", C= 'a', expected 4, got " + countChar("aaaa", 'a'));

        in.close();
    }
}
