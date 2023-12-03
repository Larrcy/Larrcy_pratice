package day09.LeetCode434;

public class Solution {
    public static void main(String[] args) {
String s =", , , ,        a, eaefa";
        System.out.println(countSegments(s));
    }

    public static int countSegments(String s) {
        if(s.length()==0){
            return 0;
        }
        String[] res = s.split(" ");
        int count =0;
        for (int i = 0; i < res.length; i++) {
            if(res[i].equals("")){
                continue;
            }
                count++;

        }
        return count;
    }
}
