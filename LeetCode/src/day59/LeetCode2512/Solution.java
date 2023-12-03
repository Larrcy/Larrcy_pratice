package day59.LeetCode2512;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        //将正面词与负面词全部添加进集合
        Set<String> positives = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negatives = new HashSet<>(Arrays.asList(negative_feedback));
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //对report进行遍历 将report[i]转为数组s
        //对s中的正面词和负面词进行统计计分，并添加进map
        for (int i = 0; i < report.length; i++) {
            int points = 0;
            String[] s = report[i].split(" ");
            for (String value : s) {
                if (positives.contains(value)) {
                    points += 3;
                } else if (negatives.contains(value)) {
                    points--;
                }
            }
            map.put(student_id[i], points);
        }
        //自定义比较器规则
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (!Objects.equals(o1.getValue(), o2.getValue()))
                    return o2.getValue() - o1.getValue();
                else return o1.getKey() - o2.getKey();

            }
        }).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : list) {
            if (k == 0) break;
            res.add(entry.getKey());
            k--;
        }
        return res;
    }
}
