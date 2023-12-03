package day30.LeetCode2525;

public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long v = (long) length * width * height;
        int Bcount = 0;
        if (length >= 10000) {
            Bcount++;
        }
        if (width >= 10000) {
            Bcount++;
        }
        if (height >= 10000) {
            Bcount++;
        }
        boolean bulkyFlag = Bcount >= 1 || v >= 1_000_000_000;
        boolean massFlag = mass >= 100;
        if (bulkyFlag==true && massFlag==true) {
            return "Both";
        } else if (bulkyFlag==true && massFlag==false) {
            return "Bulky";
        } else if (bulkyFlag==false && massFlag==false) {
            return "Neither";
        } else if (bulkyFlag==false && massFlag==true) {
            return "Heavy";
        }
        return "";
    }

}
