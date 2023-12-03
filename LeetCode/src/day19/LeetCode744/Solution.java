package day19.LeetCode744;

public class Solution {
    public static void main(String[] args) {

    }
    public char nextGreatestLetter(char[] letters, char target) {
        //target最大的情况
        if(target>=letters[letters.length-1])return letters[0];
        int left = 0;
        int right = letters.length - 1;
        //二分查找比中间值大的最小数
        //带等号左闭右闭
        //不带等号左闭右开
        while (left <=right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return letters[left];
    }
}
