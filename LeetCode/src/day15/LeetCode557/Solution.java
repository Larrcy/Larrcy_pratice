package day15.LeetCode557;

public class Solution {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder index = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(index.append(split[i]).reverse());
            if (i != split.length - 1) {
                sb.append(" ");
            }
            index.replace(0, split[i].length() , "");
        }
        return sb.toString();
    }
}
