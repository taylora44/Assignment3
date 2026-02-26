import java.util.Scanner;
public class CSCI271_Question5_LexiTaylor {

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
