package day29.LeetCode1817;

import java.util.*;

public class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set> map = new HashMap<>();
        int[] re = new int[k];
        for(int i=0; i<logs.length; i++){
            Set set = new HashSet();
            if(map.get(logs[i][0]) != null){
                set = map.get(logs[i][0]);
            }
            set.add(logs[i][1]);
            map.put(logs[i][0], set);
        }
        for(Integer key : map.keySet()){
            re[map.get(key).size()-1]++;
        }
        return re;
    }

}
