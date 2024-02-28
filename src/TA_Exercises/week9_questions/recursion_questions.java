package TA_Exercises.week9_questions;

import java.util.ArrayList;
import java.util.List;

public class recursion_questions {
    //question 1

    public static boolean isPalindrome(String s){
        if(s.isEmpty() || s.length() == 1) {
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }



// question 2

    public String toBinary(int n) {
        if (n <= 1 ) {
            return String.valueOf(n);
        }
        return toBinary(n / 2) + n % 2;
    }


// question 3

    public static List<String> permutations(String str) {
        List<String> permutations = new ArrayList< >();
        generatePermutationsHelper(str, "", permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String str, String current, List < String > permutations) {
        // Base case: if the string is empty, add the current permutation to the list
        if (str.isEmpty()) {
            permutations.add(current);
            return;
        }
        // Recursive case: for each character in the string, generate permutations by
        // appending the character to the current permutation, and recursively call the method
        // with the remaining characters as the new string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutationsHelper(remaining, current + ch, permutations);
        }
    }

}
