package day30.LeetCode2336;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Solution {
//红黑树设计
    TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (int) o1 - (int) o2;
        }
    });

    void SmallestInfiniteSet() {
        for(int i=1; i<=1000; i++) {
            treeSet.add(i);
        }
    }

    public int popSmallest() {
        int smallest = treeSet.higher(0);
        treeSet.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if(!treeSet.contains(num)) {
            treeSet.add(num);
        }
    }



}
