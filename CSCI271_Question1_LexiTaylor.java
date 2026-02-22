import java.util.Scanner;

public class CSCI271_Question1_LexiTaylor {
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

        System.out.println("Test 1: empty string, expected 0, got " + recursiveLength(""));

        System.out.println("Test 2: \"hello\", expected 5, got " + recursiveLength("hello"));

        System.out.println("Test 3: \"how are you\", expected 11, got " + recursiveLength("how are you"));

        in.close();
    }
}
