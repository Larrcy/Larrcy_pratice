package day31.Week312.LeetCode2418;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] names={"Mary","John","Emma"};
        int[] heights={180,165,170};
        System.out.println(sortPeople(names, heights));
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> map =new TreeMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i],names[i]);
        }
        List<String> res=new ArrayList<>();
        for (Integer key : map.keySet()) {
            res.add(map.get(key));
        }
        Collections.reverse(res);
       return res.toArray(new String[names.length]);
    }
}
