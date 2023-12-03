package day01.LeetCode67;

public class Solution {
    public static void main(String[] args) {


        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        //定义结果字符串
        StringBuilder ans = new StringBuilder();
        //定义每一位的值
        //carry为最后一位相加的和
        int carry = 0;
        //定义两个二进制数的下标
        //二进制数对应数组的的最后一位
        int i = a.length() - 1;
        int j = b.length() - 1;
        //当二进制数的下标位置不为0 或者进位不为0则进行循环
        //从最后一位往前算
        while (i >= 0 || j >= 0 || carry != 0) {

            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            //最后一位相加的和有3种情况 0 1 2
            //当为0时直接跳出循环
            //当为1时则取出该位的数继续到前面判断循环 若不满足循环条件则为最后一位
            //当为2时则需要进位 将该位取余得0 再除以2得1进到前一位继续循环
            ans.append(carry % 2);
            carry /= 2;
        }


        return ans.reverse().toString();
    }
}
