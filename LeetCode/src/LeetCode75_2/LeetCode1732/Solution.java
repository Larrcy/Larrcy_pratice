package LeetCode75_2.LeetCode1732;

public class Solution {
    public int largestAltitude(int[] gain) {
        int height =0;
        int res =0;
        for (int i = 0; i < gain.length; i++) {
            height=height+gain[i];
           res =Math.max(res,height);
        }
        return res;
    }
}
