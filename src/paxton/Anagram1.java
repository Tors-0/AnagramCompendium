package paxton;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagram1 {
    public static void main(String[] args) {
        if (args.length < 2) return;

        checkAnagram(args[0], args[1]);
    }

    // more pretty method
    public static void checkAnagram(String s1, String s2) {
        long st = System.nanoTime();
        boolean ic = checkAnagramRaw(s1, s2, false); // check without case sensitivity
        long td = System.nanoTime() - st;

        boolean c = checkAnagramRaw(s1, s2, true); // check with case sensitivity

        // print out the results, and the time it took to check for anagram
        System.out.println("Contains Anagram: [Ignore Case: " + ic + ", Case: " + c + "], Time Taken: " + (td / 1000000.) + " milliseconds (" + (td / 1000000000.) + " seconds)");
    }

    // actually checks for anagram
    public static boolean checkAnagramRaw(String s1, String s2, boolean caseMatters) {
        // instantly return false if the strings are identical
        if (s1.equals(s2)) return false;

        // remove all spaces
        String s1c = s1.replaceAll(" ", "");
        String s2c = s2.replaceAll(" ", "");

        // if they are of different length (after removing spaces), instantly return false
        if (s1c.length() != s2c.length()) return false;

        // check if the case matters and if so, convert to lowercase
        if (!caseMatters) {
            s1c = s1c.toLowerCase();
            s2c = s2c.toLowerCase();
        }

        // split the s2 String into its characters and convert to arraylist for easier handling
        ArrayList<String> s2ch = new ArrayList<>(Arrays.asList(s2c.split("")));

        // loop through all characters of first string
        for (int i = 0; i < s1c.length(); i++) {
            // grab char at index
            String ch = s1c.substring(i, i + 1);

            // check if the other string contains the character, if not, instantly return false
            if (!s2ch.contains(ch)) return false;

            // if it does, remove it (handling for duplicate chars in string)
            s2ch.remove(ch);
        }

        // return true if it passes all the checks
        return true;
    }
}
