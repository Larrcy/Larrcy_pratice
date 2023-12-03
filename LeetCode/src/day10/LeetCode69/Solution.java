package day10.LeetCode69;

public class Solution {
    public static void main(String[] args) {
        System.out.println(mySqrt(17));

    }

    public static int mySqrt(int x) {
            int l = 0, r = x, ans = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                //查找到的数的平方若小于x则该数后面的数也有可能符合条件
                //若大于则一定不符合条件
                if ((double) mid * mid <= x) {
                    //最后一次寻找到的小于x的数即为满足条件的数
                    ans = mid;
                    l = mid + 1;
                } else {

                    r = mid - 1;
                }
            }
            return ans;
        }



    }





