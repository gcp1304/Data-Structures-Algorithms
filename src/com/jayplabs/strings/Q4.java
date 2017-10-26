package com.jayplabs.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Q4 {

    static boolean method1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int x1=0, x2=0;

        for (int i = 0; i < s1.length(); i++) {
            x1 = x1 | s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            x2 = x2 | s2.charAt(i);
        }

        return (x1 ^ x2) == 0;
    }

    static boolean method2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }

    static boolean method3(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 0) return false;
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        Set<Character> keys = map.keySet();
        for (Character c : keys) {
            if (map.get(c) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "jay";
        String s2 = "yaj";
        System.out.println(method3(s1, s2));
    }
}
