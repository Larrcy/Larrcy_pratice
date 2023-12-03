package day13.LeetCode202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        //无限循环即在集合中会重复出现
        Set<Integer>set =new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n=getNumber(n);
        }
        return n==1;

    }
    public int getNumber(int n){
        int res =0;
        while (n>0){
            int temp = n%10;
            res=res +temp*temp;
            n=n/10;
        }
        return res;
    }
}
