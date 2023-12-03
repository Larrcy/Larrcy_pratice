package day24.LeetCode153;

public class Solution {
        public int findMin(int[] nums) {
            /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
            int left = 0;
            int right = nums.length - 1;
            /* 循环不变式，如果left == right，则循环结束 */
            while (left < right) {
                int mid = left + (right - left) / 2;
                /* 中值 > 右值，最小值在右半边，收缩左边界 */
                //即
                //      中
                // 左
                //         右
                if (nums[mid] > nums[right]) {
                    /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
                    left = mid + 1;
                }
                /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                //有两种情况
                //      右          左
                //   中       与           右
                //左                  中
                else if (nums[mid] < nums[right]) {
                    /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
                    right = mid;
                }
            }
            return nums[left];    /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
        }


}


