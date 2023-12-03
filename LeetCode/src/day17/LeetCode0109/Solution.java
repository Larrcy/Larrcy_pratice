package day17.LeetCode0109;

public class Solution {
    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
    }
    public static boolean isFlipedString(String s1, String s2) {
        StringBuilder sb =new StringBuilder(s1);
        for (int i = 0; i < s1.length(); i++) {
           sb= sb.append(s1.charAt(i));
           sb= sb.deleteCharAt(0);
            if(sb.toString().equals(s2)){
                return true;
            }
        }
        return false;
    }
}
