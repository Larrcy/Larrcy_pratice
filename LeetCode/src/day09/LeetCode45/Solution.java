package day09.LeetCode45;



import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    //时间复杂度O(N)
    //空间复杂度O(N)
    public String reverseVowels(String s) {
        char mid = ' ';
        String s1 = "";
        //利用哈希表存储字符串中含有的元音索引和字符
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
                    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')) {
                s1 = s1 + s.charAt(i);
                map.put(i, s.charAt(i));


            }
        }
        //创建数组c存储元音字符
        char[] c = new char[s1.length()];
        for (int i = 0; i < c.length; i++) {
            c[i] = s1.charAt(i);
        }
        //创建数组d存储字符串
        char[]d =new char[s.length()];
        for (int i = 0; i < d.length; i++) {
            d[i] = s.charAt(i);
        }
        //对元音字符进行倒序操作
        for (int p = 0, q = s1.length() - 1; p < q; p++, q--) {
            mid = c[p];
            c[p] = c[q];
            c[q] = mid;

        }
        int j =0;
        //对字符串进行遍历 若map中含有该索引 即map对应的值为元音字母
        //故将倒序的c数组对应的字符赋值给d数组
        for (int i = 0; i < s.length(); i++) {
           if( map.containsKey(i)){
               d[i]=c[j];
               //若为c最后的一个元素 则直接跳出循环 防止越界
               if(j==c.length-1){
                   break;
               }
               j++;
           }
        }
        //将数组转化为字符串
        return String.copyValueOf(d);

    }
}
