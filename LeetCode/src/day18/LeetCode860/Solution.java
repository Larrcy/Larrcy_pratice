package day18.LeetCode860;

public class Solution {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 5, 20, 20, 5, 5, 5, 5};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        //分别统计5美元和10美元的数量 一但5美元数量不够直接返回false
        int a = 0, b = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] / 5 == 1) {
                a++;
                continue;
            }
            if (bills[i] / 5 == 2) {
                a--;
                b++;
                if (a < 0) {
                    return false;
                }
                continue;
            }
            if (bills[i] / 5 == 4) {
                if (b > 0) {
                    b--;
                    a--;
                    if (a < 0) {
                        return false;
                    }
                    continue;
                }
                if (b == 0) {
                    a = a - 3;
                    if (a < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
