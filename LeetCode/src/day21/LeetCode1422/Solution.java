package day21.LeetCode1422;

public class Solution {
    public int maxScore(String s) {
        int count =0;
        for (int i = 1; i < s.length(); i++) {
            String left =s.substring(0, i);
            int leftCount =0;
            String right =s.substring(i);
            int rightCount =0;
            for (int j = 0; j < left.length(); j++) {
                if(left.charAt(j)=='0')leftCount++;
            }
            for (int k = 0; k < right.length(); k++) {
                if(right.charAt(k)=='1')rightCount++;
            }
            count=Math.max(count, leftCount+rightCount);
        }
        return count;
    }
}
