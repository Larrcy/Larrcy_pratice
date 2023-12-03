package day20.LeetCode2698;

public class Solution {
    public int punishmentNumber(int n) {
        int count =0;
        for (int i = 1; i <= n; i++) {
            int num =i*i;
            int index=0;
            while (num!=0){
                index+=num%10;
                num=num/10;
            }
            if(index==i){
                count++;
            }
        }
        return count;
    }

}
