package 基础算法.Sort.SelectSort;

public class Solution {
    public void SelectSort(int[]nums){
        //最后一位不用判断 故循环到 nums.length-1
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex =i;
            int min =nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(min>nums[j]){
                    //将后面遍历到的最小值赋值给min
                    min=nums[j];
                    //同时记录最小值的索引
                    minIndex=j;
                }
            }
            //若当前最小值的索引不是我们所假设的索引
            if(minIndex!=i){

                //则将假设的索引元素与我们所找到的最小元素进行互换
                nums[minIndex]=nums[i];
                nums[i]=min;
            }
        }

    }
}
