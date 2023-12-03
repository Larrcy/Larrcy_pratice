package LeetCode75_1.LeetCode605;

public class Solution {
   //贪心
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int num =0;
        for (int i = 0; i < length; i++) {
            //若当前位置没有花且为第一个位置或当前位置的前一个位置没有花且当前位置为最后一个位置或当前位置的下一个位置没有花
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == length-1 || flowerbed[i+1] == 0)){
                //在当前位置把花种上
                flowerbed[i] = 1;
                num++;
                if(num>=n){
                    return true;
                }
            }else{
                //无法插入花时 当n=0时则返回true
                if(num==0&&n==0){
                    return true;
                }
            }

        }
        return false;
    }
}
