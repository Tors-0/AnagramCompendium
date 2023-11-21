package maggie;

import java.util.Scanner;

public class Anagram1 {
    public static void main(String[] args){
        //get inputs
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter string 1:");
        String str1 = myScanner.nextLine();
        System.out.println("Enter string 2:");
        String str2 = myScanner.nextLine();
        //check if they're anagrams
        long startTime = System.nanoTime();
        if (isAnagram(str1.toLowerCase(), str2.toLowerCase())){ //if anagrams regardless of case
            if (isAnagram(str1, str2)){ //if anagrams with case
                System.out.println("Yes, \"" + str1 + "\" and \"" + str2 + "\" are anagrams, whether or not case is considered");
            }
            else{
                System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are anagrams without considering case, but are not anagrams if case is considered");
            }
        }
        else{
            System.out.println("No, \"" + str1 + "\" and \"" + str2 + "\" are not anagrams");
        }
        //calculate and print how long it took to check
        long endTime = System.nanoTime();
        double time = endTime - startTime;
        double ms = time / 1000000;
        double s = ms / 1000;
        System.out.println("Time: " + ms + " ms (" + s + " s)");
    }

    public static boolean isAnagram(String str1, String str2){
        //remove spaces
        str1 = str1.replaceAll(" ", "");
        str2 = str2.replaceAll(" ", "");
        //if they are the same word, return false
        if (str1.equals(str2)){
            return false;
        }
        //if they aren't the same length, return false
        if (str1.length() != str2.length()){
            return false;
        }
        //for every letter in str1, check if it's in str2.
        //if yes, remove it from str2, so we can't double count it.
        //if no, return false.
        for (int i = 0; i < str1.length(); i++){
            String letter = str1.substring(i, i+1);
            int ind = str2.indexOf(letter);
            if (ind >= 0){
                str2 = str2.substring(0, ind) + str2.substring(ind+1);
            }
            else{
                return false;
            }
        }
        //if we've made it this far, return true
        return true;
    }
}
