package day48.LeetCode997;

public class Solution {
    public int findJudge(int n, int[][] trust) {
    int[] inDegrees =new int[n];
    int[] outDegrees =new int[n];
        for (int[] edge : trust) {
            int in =edge[1];
            int out =edge[0];
            inDegrees[in]++;
            outDegrees[out]++;

        }
        for (int i = 1; i <= n; i++) {
            if(inDegrees[i]==n-1&&outDegrees[i]==0){
                return i;
            }
        }
        return -1;
    }
}
