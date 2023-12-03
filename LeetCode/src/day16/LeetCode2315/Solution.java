package day16.LeetCode2315;

public class Solution {
    public static void main(String[] args) {
        String s="l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
    }
    public static int countAsterisks(String s) {
        String[] res =s.split("\\|");
        int count=0;
        for(int i =0;i<res.length;i++){
            if(i%2==0){
                for (int j = 0; j < res[i].length(); j++) {
                    if(res[i].charAt(j)=='*'){
                        count++;
                    }
                }

            }

        }
        return count;
    }
}
