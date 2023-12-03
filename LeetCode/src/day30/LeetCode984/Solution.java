package day30.LeetCode984;

public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while (a > b && b > 0) {
            sb.append("aab");
            --a;
            --a;
            --b;
        }
        while (b > a && a > 0) {
            sb.append("bba");
            --b;
            --b;
            --a;
        }
        while (a > 0 && b > 0) {
            sb.append("ab");
            --a;
            --b;
        }
        while (a > 0) {
            sb.append('a');
            --a;
        }
        while (b > 0) {
            sb.append('b');
            --b;
        }
        return sb.toString();
    } // strWithout3a3b(int, int)
}
