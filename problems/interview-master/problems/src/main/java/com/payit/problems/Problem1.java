package com.payit.problems;

import java.util.List;

/**
 * Complete the method below. This method will receive a list (as you can see below). The method should iterate over the list. For most
 * indexes you should put the index value into the list at that index. For indexes that are multiples of three, the value should be "Fizz".
 * For indexes that are multiples of five, the value should be "Buzz". For indexes that are multiples of both three and five, the value
 * should be "FizzBuzz".
 */
public class Probem1 {
    public List<String> fizzBuzz(List<String> fizzBuzz) {
        int i = 0;
        for (String item : fizzBuzz) {
            if (i % 15 == 0) {
                fizzBuzz.set(i, "FizzBuzz");
            } else if (i % 5 == 0) {
                fizzBuzz.set(i, "Buzz");
            } else if (i % 3 == 0) {
                fizzBuzz.set(i, "Fizz");
            }
            i+=1;
        }
        return fizzBuzz;
    }
}