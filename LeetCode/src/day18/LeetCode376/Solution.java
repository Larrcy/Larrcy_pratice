package day18.LeetCode376;


public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        //将只有两个元素的情况也考虑进去
        //若两个元素相同则返回1
        //若不同则返回2
        //故初始时给这两个元素添加头尾元素来保证两个元素不同时值为2
        int prediff=0;
        int curdiff=0;
        int count =1;
        for (int i = 1; i < nums.length-1; i++) {
            //计算当前坡度
            curdiff=nums[i+1]-nums[i];
            //当上下坡度为一正一负时进行记录
            if ((prediff <= 0 && curdiff > 0) || (prediff >= 0 && curdiff < 0)) {
                count++;
                //记录当坡度改变时才进行记录
                //否则出现平坡时会多记录一次
                prediff = curdiff;
            }

        }
        return count;
    }

}
