package day40.LeetCode1431;
import java.util.*;
public class Solution {
    //用哈希表存储长度为k的字串
    //判断字串是否有2的k次方项
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < Math.pow(2,k) + k - 1) {
            return false;
        }

        Set<String> exists = new HashSet<String>();
        for (int i = 0; i + k <= s.length(); ++i) {
            exists.add(s.substring(i, i + k));
        }
        return exists.size() == Math.pow(2,k);
    }

}
