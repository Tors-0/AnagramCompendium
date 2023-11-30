package aiden;

import java.util.Arrays;
import java.util.Scanner;


public class Anagram1 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Anagram Check by Aiden Rouhani (v1.0)");
        System.out.println("What is the first string you'd like to compare?");
        String firstInput = input.nextLine();

        System.out.println("\nWhat is the second string you'd like to compare?");
        String secondInput = input.nextLine();

        System.out.println("\nComparing the string \"" + firstInput + "\" with the string \"" + secondInput + "\"");

        long startTime = System.nanoTime();
        boolean[] result = anagramCheck(firstInput, secondInput);
        long finalTime = (System.nanoTime() - startTime);

        System.out.println("The strings " + (result[0] ? "are" : "aren't") + " anagrams of one another if case is factored, and" + (result[1] ? " are" : " aren't") + " without case-sensitivity. \n" + "Calculated in " + finalTime/1_000_000_000.0 + "s");
    }

    public static boolean[] anagramCheck(String xOrig, String yOrig) {
        boolean[] results = new boolean[2];

        if (xOrig.equals(yOrig)) {
            return results;
        }

        String x = xOrig.replaceAll(" ", "");
        String y = yOrig.replaceAll(" ", "");

        int xLength = x.length();

        if (xLength != y.length() || x.equalsIgnoreCase(y))
            return results;

        Arrays.fill(results, true);
        for (char letter = 'a'; letter <= 'z'; letter++) {
            int xCount = 0;
            int xCountNormalized = 0;

            int yCount = 0;
            int yCountNormalized = 0;

            for (int i = 0; i != xLength; i++) {
                if (letter == x.charAt(i)) {
                    xCount++;
                }

                if (Character.toLowerCase(letter) == Character.toLowerCase(x.charAt(i))) {
                    xCountNormalized++;
                }

                if (letter == y.charAt(i)) {
                    yCount++;
                }

                if (Character.toLowerCase(letter) == Character.toLowerCase(y.charAt(i))) {
                    yCountNormalized++;
                }
            }

            if (xCountNormalized != yCountNormalized) {
                Arrays.fill(results, false);
                return results;
            }

            if (xCount != yCount) {
                results[0] = false;
            }



        }
        return results;
    }
}