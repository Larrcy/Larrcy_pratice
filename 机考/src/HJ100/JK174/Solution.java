package HJ100.JK174;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

//预定酒店
public class Solution {
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        func(nums, n, k, x);
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else
                System.out.print(res.get(i) + " ");
        }

    }

    public static void func(int[] nums, int n, int k, int x) {
        Arrays.sort(nums);
        //利用二维数组保存price 和price与x的差值
        //然后将二维数组按照差值从小到大排序
        //最后遍历输出即可
        int[][] index = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            int price = nums[i];
            index[i][0] = price;
            index[i][1] = Math.abs(price - x);
        }
        List<int[]> sorted = Arrays.stream(index).sorted(Comparator.comparingInt(o -> o[1]))
                .collect(Collectors.toList());

        for (int i = 0; i < k; i++) {
            res.add(sorted.get(i)[0]);
        }
        Collections.sort(res);
    }

}

