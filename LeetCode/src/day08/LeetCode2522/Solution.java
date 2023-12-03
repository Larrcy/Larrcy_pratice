package day08.LeetCode2522;

import java.security.Key;
//贪心算法
public class Solution {
    public static void main(String[] args) {
        String s="238182";
        int k =5;
        System.out.println(minimumPartition(s, k));
    }
    public  static int minimumPartition(String s, int k) {
        //ans表示字符串分割的个数
        // 未分割就为1
        int n = s.length(), ans = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            //字符的值与0字符相减得到的就是整型之差
            if (s.charAt(i) - '0' > k) return -1;
            //若满足条件则判断加上下一位是否满足条件
            sum = sum * 10 + s.charAt(i) - '0';
            //当不满足条件时
            if (sum > k) {
                //则返回上一次的数 且计数+1
                ans++;
                //取余后的数就是下一个数的开始
                //165%10=5
                //16满足条件故截取到16
                //下一次以5开头
                sum %= 10;
            }
        }

        return ans;
    }
    }

