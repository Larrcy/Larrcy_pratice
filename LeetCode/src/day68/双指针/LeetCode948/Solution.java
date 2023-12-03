package day68.双指针.LeetCode948;

import java.util.Arrays;

/**
 * 你的初始 能量 为 power，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
 *
 * 令牌可能的两种使用方法如下：
 *
 * 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。
 * 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。
 * 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。
 *
 * 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        //从小到大排序
        Arrays.sort(tokens);
        int l=0,r=tokens.length-1;
        int points = 0,p = P;
        while(l<=r){
            if(p>=tokens[l]){
                //如果当前的能量可以换积分，那就赶紧换积分；然后开始下一轮兑换
                p -= tokens[l];
                points ++;
                l++;
            }else if(points > 0 && l<r){
                //如果有得分，且有最大的能量可以兑换，那就兑换能量
                p+=tokens[r];
                points --;
                r--;
            }else{
                //无法换积分也无法换能量就退出
                break;
            }
        }
        return points;
    }

}
