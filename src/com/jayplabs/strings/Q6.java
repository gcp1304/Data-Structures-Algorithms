package com.jayplabs.strings;

public class Q6 {
    
    private static String bruteForce(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            int count = 0;
            while (i < input.length() && c == input.charAt(i)) {
                i++;
                count++;
            }
            sb.append(c);
            sb.append(count);
        }

        return (sb.length() < input.length()) ? sb.toString() : input;
    }

    private static String stringCompression(String input) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == prev) count++;
            else {
                sb.append(prev);
                sb.append(count);
                prev = cur;
                count = 1;
            }
        }
        sb.append(prev);
        sb.append(count);

        return (sb.length() < input.length()) ? sb.toString() : input;

    }

    public static void main(String[] args) {
        String s1 = "jjaaayyyy";
        System.out.println(bruteForce(s1));
        System.out.println(stringCompression(s1));
    }
}
