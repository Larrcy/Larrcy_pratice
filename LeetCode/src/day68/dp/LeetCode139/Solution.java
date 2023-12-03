package day68.dp.LeetCode139;

import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Solution {
    //完全背包类问题
    //该题目可以转化为向s中装多少单词可以把s装满
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]dp =new boolean[s.length()];
        dp[0]=true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String sub =s.substring(j,i);
                if(wordDict.contains(sub)&& dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()-1];
    }
}
