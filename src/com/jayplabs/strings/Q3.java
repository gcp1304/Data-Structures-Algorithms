package com.jayplabs.strings;

public class Q3 {

    public static int method1(String[] str) {
        int prefix = 0;
        for (int i = 0; i < str[0].length(); i++) {
            Character c = str[0].charAt(i);
            for (int j = 1; j < str.length; j++) {
                if (c != str[j].charAt(i)) {
                    return prefix;
                }
            }
            prefix++;
        }
        return prefix;
    }

    static String method2(String[] str) {
        int prefixLen = str[0].length();
        int curLen;
        for (int i = 1; i < str.length; i++) {
            curLen = 0;
            while(curLen < prefixLen &&
                    curLen < str[i].length() &&
                    str[0].charAt(curLen) == str[i].charAt(curLen)) {
                curLen++;
            }
            prefixLen = curLen;
        }
        return str[0].substring(0, prefixLen);
    }

    public static void main(String[] args) {
        String x = "Chandra Chaitra Chandu Chaitu Champ Chang";
        String[] strs = x.split(" ");
        int prefixLen = method1(strs);
        System.out.println(strs[0].substring(0, prefixLen));
        System.out.println(method2(strs));
    }
}
