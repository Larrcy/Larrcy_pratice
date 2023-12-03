package day37.LeetCode2451;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"adc","wzy","abc"};
        System.out.println(oddString(words));
    }
    public static String oddString(String[] words) {
        Map<List<Integer>,Integer> map=new HashMap<>();
        List<List<Integer>>res =new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer>list =new ArrayList<>();
            for (int p = 0,q=1; q < words[i].length(); p++,q++) {
                list.add(words[i].charAt(q)-words[i].charAt(p));
            }
            res.add(list);
           map.put(list,map.getOrDefault(list,0)+1);
        }
        for (List<Integer> key : map.keySet()) {
            if(map.get(key)==1){
                for (int i = 0; i < res.size(); i++) {
                    if(res.get(i)==key){
                        return words[i];
                    }
                }
            }
        }
        return "";
    }
}
