package LeetCode.Week3;

public class Solution {
    public static void main(String[] args) {
        String num ="";
        System.out.println(removeTrailingZeros(num));
    }
    public static String removeTrailingZeros(String num) {
        if(num.length()==1){
        return num;
        }
        for (int p = num.length()-1,q=num.length()-2; q>=0; p--,q--) {
            if(num.charAt(p)=='0'&&num.charAt(q)=='0'){
                p=q;
                q--;
            }
            if(num.charAt(p)=='0'&&num.charAt(q)!='0'){
                return num.substring(0,q+1);
            }
            if(num.charAt(p)!='0'){
                return num.substring(0,p+1);
            }
        }
        return "";
    }
}
