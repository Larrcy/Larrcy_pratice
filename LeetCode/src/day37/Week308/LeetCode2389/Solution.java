package day37.Week308.LeetCode2389;

import java.util.Arrays;

public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            int sum =0;
            for (int j = 0; j < nums.length; j++) {
                sum+= nums[j];
                if(sum<=queries[i])
                    count++;
                else{
                    sum-= nums[j];
                }
            }

            ans[i] = count;
        }
        return ans;
    }

    }

