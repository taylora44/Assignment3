import java.util.Scanner;
public class CSCI271_Question2_LexiTaylor {
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
