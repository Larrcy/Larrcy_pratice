package day60.LeetCode2525;

/**
 * 给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
 */
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean Bulky = false;
        boolean Heavy = false;
        long v = (long) length * width * height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || v >= 1000000000) {
            Bulky = true;
        }
        if (mass >= 100) {
            Heavy = true;
        }
        if (Bulky && Heavy) return "Both";
        else if (!Bulky && !Heavy) return "Neither";
        else if (Bulky && !Heavy) return "Bulky";
        else return "Heavy";
    }
}
