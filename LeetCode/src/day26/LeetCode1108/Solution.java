package day26.LeetCode1108;

public class Solution {
    public String defangIPaddr(String address) {
        String[] split = address.split("\\.");
        String res = "";
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                res = res + split[i];
            } else {
                res = res + split[i];
                res = res + "[.]";
            }
        }
        return res;
    }
}
