package day20.LeetCode2730;

public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {

        int count = 1;
        int left =0;
        int right;
        int same =0;
        //从right=1的位置进行判断
        for (right = 1; right < s.length(); right++) {
            if(s.charAt(right)==s.charAt(right-1)){
                same++;
            }
            //若出现两对相同元素 则移动左指针
            if(same>1){
                left++;
                //当左指针所指元素与其之前的元素不同时则左指针向后移动
                //直至消除相同元素至一对
                while (s.charAt(left)!=s.charAt(left-1)){
                    left++;

                }
                same=1;
            }
            //计算此时的最大长度 最后进行取最大值
            count=Math.max(count, right - left + 1);
        }
        return count;
    }


}
