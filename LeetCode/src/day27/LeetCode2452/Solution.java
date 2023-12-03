package day27.LeetCode2452;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String w1: queries){
            for (String w2: dictionary){
                //记录变换次数
                int diff = 0;
                for (int i = 0; i < w1.length(); i ++){
                    if (w1.charAt(i) != w2.charAt(i)){
                        diff ++;
                        if (diff > 2){
                            break;
                        }
                    }
                }
                if (diff <= 2){
                    res.add(w1);
                    break;
                }
            }
        }

        return res;
    }

}
