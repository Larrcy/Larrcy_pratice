package day30.LeetCode1352;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //前缀积
    int size = 0;
    List<Integer> list = null;
    int multiNum=1;
    void ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if(num==0){
            size=0;     //遇到0时，list长度置0
            multiNum=1;     //累乘元素赋原值1
            list.clear();   //列表清空
        }else{
            size++;
            multiNum=multiNum*num;
            list.add(multiNum);
        }
    }

    public int getProduct(int k) {
        if(k>size){
            return 0;
        }else if(k==size){
            return list.get(size-1);
        }else {
            return list.get(size-1)/list.get(size-k-1);
        }
    }


}
