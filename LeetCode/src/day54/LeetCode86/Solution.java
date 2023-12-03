package day54.LeetCode86;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        int min =Integer.MAX_VALUE;
        for (Character key : map.keySet()) {
            if(map.get(key)<min){
                min=map.get(key);
            }
        }
        String index ="";
        for (Character key : map.keySet()) {
            if(map.get(key)==min){
                index+=key;
            }
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(index.contains(String.valueOf(str.charAt(i))))continue;
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
