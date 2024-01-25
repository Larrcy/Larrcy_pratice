package LeetCode.Test;


import java.util.*;

public class Main {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] max = new int[n];
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            max[i] = list.get(i)[1];
            list1.add(list.get(i)[0]);
        }
        for (int i = 1; i < max.length; i++) {
            if (max[i] < max[i - 1]) max[i] = max[i - 1];
            System.out.println(max[i-1]);
        }
        int res = 0;
        for (int i = 0; i < worker.length; i++) {
            if (worker[i] >= list.get(BinarySearch(list1, worker[i]))[0])
                res += max[BinarySearch(list1, worker[i])];
        }
        return res;
    }

    public int BinarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}






