package com.jayplabs.strings;

import java.util.Arrays;

public class Q2 {

    private static boolean method1(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean method2(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1]) return false;
        }
        return true;
    }

    private static boolean method3(String str) {
        boolean[] chars = new boolean[256];
        Arrays.fill(chars, false);
        for (int i = 0; i < str.length(); i++) {
            int index = (int) str.charAt(i);
            if (chars[index])
                return false;

            chars[index] = true;
        }
        return true;
    }

    private static boolean method4(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int bitIndex = str.charAt(i) - 'a';
            if ((checker & (1<<bitIndex)) > 0) return false;

            checker = checker | (1<<bitIndex);
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "cccc";
        System.out.println(method1(input));
        System.out.println(method2(input));
        System.out.println(method3(input));
        System.out.println(method4(input));
    }

}
