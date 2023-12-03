package day63.SlideWindow.LeetCode2024;

/**
 * 滑动窗口
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 *
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 *
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 */
public class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int T = 0;
        int F = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == 'T') T++;
            if (answerKey.charAt(i) == 'F') F++;
        }
        if (T <= k || F <= k) {
            return answerKey.length();
        }
        return Math.max(extracted(answerKey, k,'F'),extracted(answerKey, k,'T'));
    }
    private static int extracted(String answerKey, int k,char ch) {
        int left = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            char c = answerKey.charAt(i);
            if (c == ch) {
                k--;
            }
            sum++;
            if(k==0&&i== answerKey.length()-1){
                if (res < sum) {
                    res = sum ;
                }
            }
            while (k < 0) {
                if (res < sum) {
                    res = sum - 1;
                }
                if (answerKey.charAt(left) == ch) {
                    k++;
                }
                sum--;
                left++;
            }
        }
        return res;
    }
}
