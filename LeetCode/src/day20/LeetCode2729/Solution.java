package day20.LeetCode2729;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
int n =267;
        System.out.println(isFascinating(n));
    }
    public static boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(n * 2).append(n * 3);
        Set<Character>set =new HashSet<>();
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)=='0')return false;
           if(!set.add(sb.charAt(i))){
               return false;
            }
        }
        return true;
    }
}
