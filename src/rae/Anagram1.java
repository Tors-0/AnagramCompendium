package rae;

import java.util.Collections;
import java.util.HashMap;

public class Anagram1 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length < 2) {
            System.out.println("not enough arguments detected");
            System.exit(0);
        }
        String s1 = args[0];
        String s2 = args[1];
        String s1non = s1.toLowerCase();
        String s2non = s2.toLowerCase();
        HashMap<Character,Integer> s1WithCase = new HashMap<>();
        HashMap<Character,Integer> s2WithCase = new HashMap<>();
        HashMap<Character,Integer> s1NoCase = new HashMap<>();
        HashMap<Character,Integer> s2NoCase = new HashMap<>();
        boolean output1;
        boolean output2;
        for (int i = 0; i < s1.length(); i++) {
            char current = s1.charAt(i);
            if (s1WithCase.containsKey(current)) {
                s1WithCase.put(current, s1WithCase.get(current) + 1);
            } else {
                s1WithCase.put(current, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char current = s2.charAt(i);
            if (s2WithCase.containsKey(current)) {
                s2WithCase.put(current, s2WithCase.get(current) + 1);
            } else {
                s2WithCase.put(current, 1);
            }
        }
        s1WithCase.remove(' ');
        s2WithCase.remove(' ');
        output2 = s1WithCase.equals(s2WithCase);
        for (int i = 0; i < s1non.length(); i++) {
            char current = s1non.charAt(i);
            if (s1NoCase.containsKey(current)) {
                s1NoCase.put(current, s1NoCase.get(current) + 1);
            } else {
                s1NoCase.put(current, 1);
            }
        }
        for (int i = 0; i < s2non.length(); i++) {
            char current = s2non.charAt(i);
            if (s2NoCase.containsKey(current)) {
                s2NoCase.put(current, s2NoCase.get(current) + 1);
            } else {
                s2NoCase.put(current, 1);
            }
        }
        s1NoCase.remove(' ');
        s2NoCase.remove(' ');
        output1 = s1NoCase.equals(s2NoCase);
        if (s1.equalsIgnoreCase(s2)) {
            output2 = false;
            output1 = false;
        }
        long endTime = System.nanoTime();
        System.out.printf("'%s' is%s an anagram of '%s'\n", s1, output1 ? "" : "n't", s2);
        System.out.printf("If you consider case, '%s' is%s an anagram of '%s'\n", s1, output2 ? "" : "n't", s2);
        System.out.printf("Testing took about %s.", formatNanoSec(endTime - startTime));
    }
    private static String formatNanoSec(double nano) {
        short counter = 0;
        while (nano >= 1000) {
            if (counter > 3) {
                break;
            }
            counter++;
            nano /= 1000f;
        }
        String time = String.valueOf((float) Math.round(nano * 100f) / 100f);
        return switch (counter) {
            case 0 -> time + " nanoseconds";
            case 1 -> time + " microseconds";
            case 2 -> time + " milliseconds";
            default -> time + " seconds";
        };
    }
}
