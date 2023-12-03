package day22.LeetCode1186;

public class Solution {
    public int maximumSum(int[] arr) {
        //dp0不删除 dp1删除1次
        int[] dp0 = new int[arr.length];
        int[] dp1 = new int[arr.length];
        dp0[0] = arr[0];
        dp1[0]=0;
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //删除时：两种情况 当前位置删除 之前已经删除
            dp1[i]=Math.max(dp1[i-1]+arr[i],dp0[i-1]);
            //不删除：之前不删除 加当前位置元素
            //考虑当数组只有两个元素时 如-3 1 这时只取1
            dp0[i]=Math.max(dp0[i-1],1)+arr[i];
           res =Math.max(Math.max(dp0[i],dp1[i]),res);
        }
        return res;
    }
}
