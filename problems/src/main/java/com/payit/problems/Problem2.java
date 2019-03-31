package com.payit.problems;

/**
 * For this problem you should complete the method below.
 * This method should determine if a string is a palindrome or not.
 */
public class Problem2 {
    public boolean isPalindrome(String value) {
        int low = 0;
        int high = value.length();

        while (high > low) {
            if (Character.toLowerCase(value.charAt(low)) != Character.toLowerCase(value.charAt(high))) {
                return false;
            }
            low += 1;
            high -= 1;
        }

        return true;
    }

}