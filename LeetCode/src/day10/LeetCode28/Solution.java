package day10.LeetCode28;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String haystack="hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                list.add(i);
            }
        }
        if(list.size()==0){
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            while (haystack.length() - list.get(i) + 1 > needle.length()) {
                if (haystack.substring(list.get(i), (list.get(i) + needle.length())).equals(needle)) {
                    return list.get(i);
                }
                if(i==list.size()-1) {
                    break;
                }
                    i++;

            }
        }
        return -1;
    }
}
