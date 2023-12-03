package day21.LeetCode2496;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] strs ={"x0v","6","3","6"};
        System.out.println(maximumValue(strs));
    }
    public static int maximumValue(String[] strs) {
        int max =0;

        for (int i = 0; i < strs.length; i++) {
            int count =0;
            int index=0;
            for (int j = 0; j < strs[i].length(); j++) {
                if(!(strs[i].charAt(j)>='0'&&strs[i].charAt(j)<='9')){
                    count=strs[i].length();
                    index =0;

                }

                if((strs[i].charAt(j)>='0'&&strs[i].charAt(j)<='9')){
                    index++;
                }
                if(index==strs[i].length()){
                    count=Integer.parseInt(strs[i]);
                }


            }
            max=Math.max(max,count);
        }
        return max;
    }
}
