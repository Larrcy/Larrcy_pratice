package day15.LeetCode557;

public class Solution2 {
    public static void main(String[] args) {

    }
    //原地反转
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = 0; j < n; j++) {
            if (cs[j] == ' ') {
                swap(cs, i, j - 1);
                i = j + 1;
            }
            if (j == n - 1) swap(cs, i, j);
        }
        return new String(cs);
    }

    void swap(char[] cs, int left, int right) {
        while (left < right) {
            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
            left++;
            right--;
        }
    }
}
