package Offer10.S7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /** 最值型DP
         1.最后一步：最优策略一定是有k个不重复的子字符串，所有一定有最后一个字符ak与前面的k-1个字符都不重复，而且长度还是最长的。
         2.子问题：在第ak个位置时，一定有m个最长的字符串
         3.转移方程：设状态dp[x]= 字符串x有最长的子字符串长度，定义一个map存储字符出现的位置
         要考虑三种情况：
         3.1. 完全没有出现过这个字符，则直接加入，长度加1
         dp[x] = dp[x-1] + 1
         3.2. 出现过这个字符，但前后出现的位置距离不在当前最长距离里面，即大于最长距离，可以再次加入到最长不重复字符里面，长度加1
         dp[x] = dp[x-1] + 1
         3.3. 出现过这个字符，但前后出现的位置距离在当前最长距离里面，即小于等于最长距离，不可加入到最长不重复字符里面
         dp[x] = 1
         每次都要更新字符出现的位置
         4.初始化
         dp[0] = 1
         5.计算顺序: 从小到大
         6.返回值：max
         */
        if(s.length()==0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = 1;
        Map<Character, Integer> dic = new HashMap<>();
        //hashmap 存储的是（字符，出现的位置）
        dic.put(s.charAt(0), 0);
        for(int i=1; i<s.length(); i++){
            //如果完全没有出现过这个字符，则直接加入，并在原来基础上加1
            //如果出现过该字符,该字符前后出现的相对距离>当前最长字符长度，说明最初出现的字符已经不影响，不在最长子字符串里面，依然可以接着加入该字符
            if(!dic.containsKey(s.charAt(i)) || i-dic.get(s.charAt(i)) > dp[i-1]){
                dp[i] = dp[i-1] + 1;
            }else{
                //如果出现该字符
                //该字符的前后的相对位置<=当前最长字符长度，说明最初出现的字符在最长字符串里面，故不可以加入该重复字符
                dp[i] = i - dic.get(s.charAt(i));
            }
            //更新字符所在的位置
            dic.put(s.charAt(i), i);
            //记录最大值
            if(dp[i]>=max) max = dp[i];
        }
        return max;
    }

}
