package day13.LeetCode2299;

public class Solution {
    public static void main(String[] args) {
    String password ="ziyS5FrPQhoQ5oEWRpHW2MjI7sGfcMJdcsjQnIyRbdCilvFaQN07jQtAkOklbjFrU5KcHzw4EvJ41Yz2Ykyd";
        System.out.println(strongPasswordCheckerII(password));
    }

    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        int m = 0, n = 0, p = 0, q = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                m++;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                n++;
            }
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                p++;
            }
            if (password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '^' || (password.charAt(i) >= '#' && password.charAt(i) <= '%') || password.charAt(i) == '&' || (password.charAt(i) >= '(' && password.charAt(i) <= '+') || password.charAt(i) == '-') {
                q++;
            }
        }
        if(p>=1&&q>=1&&m>=1&&n>=1){
            for (int i = 0; i < password.length(); i++) {
                if(password.charAt(i)==password.charAt(i+1)){
                    return false;
                }
                if(i==password.length()-2){
                    break;
                }
            }
            return true;
        }
        return false;

    }
}

