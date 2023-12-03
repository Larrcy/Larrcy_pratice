package Char10.S26.LeetCode;

import java.util.HashSet;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
    //跟排列有关 故先背包后物品
        for (int i = 0; i <= wordDict.size(); i++) { // 背包
            for (int j = 0; j <i; i++) {
                String substring = s.substring(j, i);
                //若截取的部分在字符数组里 且之前的满足条件
                //则i之前的都满足
            if(wordDict.contains(substring)&&valid[j]==true){
                valid[i]=true;
            }
            }
        }

        return valid[s.length()];
    }

}
