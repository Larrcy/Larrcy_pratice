package day22.LeetCode167;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(numbers, target));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];

        for (int i = 0; i < numbers.length; ) {

            int left = 0;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (numbers[mid] == target - numbers[i]) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    if (res[0] == res[1]) {
                        res[1]++;
                    }
                    return res;
                }
                if (numbers[mid] > target - numbers[i]) {
                    right = mid - 1;
                }
                if (numbers[mid] < target - numbers[i]) {
                    left = mid + 1;
                }
            }
            if (left > right) i++;

        }
        return res;
    }

}
