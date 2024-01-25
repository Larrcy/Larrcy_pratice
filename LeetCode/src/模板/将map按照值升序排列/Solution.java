package 模板.将map按照值升序排列;
import java.util.*;
public class Solution {
    //按照字符串出现频率从小到大排列 相同的按字母升序
    public List<String>f(String[] nums){
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        List<String> ans = new ArrayList<>(set);
        ans.sort((a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        return ans;
    }
}
