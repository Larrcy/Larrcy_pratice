package day20.LeetCode80;

public class Solution {
    //双指针
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        //数组的前两个元素必定可以保留
        //故设初始指针为2
        int slow = 2, fast = 2;
        while (fast < n) {
            //当fast小于数组长度时进行操作
            //由于题目中数组已按升序排列 因此
            //num[2]与num[0]若相等则 为3个相同
            //num[2]与num[0]若不相等则 后两个相同 或后两个不相同
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            //fast探路 slow进行重新插入操作
            fast++;
        }
        return slow;
    }

}
