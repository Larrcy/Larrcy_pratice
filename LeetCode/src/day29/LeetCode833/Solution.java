package day29.LeetCode833;

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        //利用map来存储需要替换的字符串
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        List<String> list = new ArrayList<>();
        int start = 0; // 记录当前起始位置
        Arrays.sort(indexes);
        for (int i = 0; i < indexes.length; i++) {
            String source = map.get(indexes[i])[0];
            String target = map.get(indexes[i])[1];
            //找到s与source所匹配的索引位置
            //从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。
            int index = S.indexOf(source, indexes[i]); // 从indexes[i]查找
            if (index == indexes[i]) { // 必须等于indexed[i]，否则可能在后面的位置找到source
                //截取未更改的位置
                list.add(S.substring(start, index));
                //添加更改的字符
                list.add(target);
                start = index + source.length(); // 更新start位置
            }
        }
        //将最后一段添加进去
        list.add(S.substring(start));
        StringBuilder sb = new StringBuilder(); // 使用StringBuilder更快
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
