package day24.LeetCode287;

public class Solution {
    public int findDuplicate(int[] nums) {
        //我们用 cnt[i]表示nums数组中<=i的个数
        //设重复元素为target则target为1-n;
        //原数组的长度为n+1
        //1.若重复元素为2个
        //[1,2,3,4,4] cnt[i]={0,1,2,3,5}
        //通过观察cnt[i]可以发现 当i<target时 cnt[i]=i;
        //当i>=target时 cnt[i]>i
        //2.若重复元素大于2个 假设重复3个
        //[2,2,2,3] cnt[i]={0,0,3,4}
        //此时观察cnt[i]我们发现 当i<target时cnt[i]<i
        //当i>target时cnt[i]>target
        //因此我们对cnt数组进行二分查找 找到第一个满足cnt[i]>i的下标
        //我们对1-n范围内进行查找
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
