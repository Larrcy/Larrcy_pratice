package day11.LeetCode551;

public class Solution {
    public static void main(String[] args) {

    }
    //1、int indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。
    //2、int indexOf(String str, int startIndex)：从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。
    //3、int lastIndexOf(String str) ：返回在此字符串中最右边出现的指定子字符串的索引。
    //4、int lastIndexOf(String str, int startIndex) ：从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引。
    public boolean checkRecord(String s) {
        if(s.contains("LLL")){
            return false;
        }
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='A'){
                count++;
            }
        }
        if(count>=2){
            return false;
        }
        return true;
    }
}
