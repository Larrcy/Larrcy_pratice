package LeetCode75_1.LeetCode443;

public class Solution {
    //双指针
    public int compress(char[] chars) {
    int cur =0;//该指针对整个数组进行重新插入操作
        for (int i = 0; i < chars.length;) {
            int start =i;//记录开始位置
            chars[cur]=chars[i];//对首个字符进行写入
            //当下一个位置的元素与当前位置的元素相同 则指针继续向后移动
            while (i+1<chars.length&&chars[i+1]==chars[i]) {
                i++;
            }
            //若当前指针与起始位置相同则i指针与cur同时后移
            //a b 这种情况
            if(i==start){
                i++;
                cur++;
            }else {
                //记录重复元素的长度
                String len =Integer.toString(i-start+1);
                for (int j = 0; j < len.length(); j++) {
                    //cur位置记录当前的元素
                    cur++;
                    //插入长度
                    chars[cur]=len.charAt(j);
                }
                //插入完之后继续向后寻找
                cur++;
                i++;
            }
        }
        return cur;

    }
}