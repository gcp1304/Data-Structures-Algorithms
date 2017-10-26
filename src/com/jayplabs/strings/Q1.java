package com.jayplabs.strings;

import java.util.Stack;

/**
 Objective: You have been asked to Write an algorithm to find Whether Given the Sequence of parentheses are well formed.
 This question was asked in the Amazon Interview.

 Input: A String contains a sequence of parentheses

 Output: true or false on whether parentheses are well formed or not

 Example:
 { { } { } } – Well formed
 { { } { = Not well formed
 */

public class Q1 {

    public static boolean naiveSolution(String paranthesis) {
        if (paranthesis == null || paranthesis.length() == 0) return false;
        int count = 0;
        for (int i = 0; i < paranthesis.length(); i++) {
            if (paranthesis.charAt(i) == '{') count++;
            else if (paranthesis.charAt(i) == '}' && count > 0) count--;
            else return false;
        }
        return count == 0;
    }

    public static boolean isWellFormed(String paranthesis) {
        if (paranthesis == null || paranthesis.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < paranthesis.length(); i++) {
            if (paranthesis.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
            if (paranthesis.charAt(i) == '{') {
                stack.push(paranthesis.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isWellFormed("}{}}"));
    }
}
