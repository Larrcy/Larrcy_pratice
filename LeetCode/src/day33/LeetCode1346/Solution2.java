package day33.LeetCode1346;

import java.util.HashSet;

public class Solution2 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2)))   return true;
            set.add(i);
        }
        return false;

    }
}
