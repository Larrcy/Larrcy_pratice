package day07.LeetCode383;

public class Solution2 {
    public static void main(String[] args) {

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr =new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            //26个小写字母初始为0
            //在对应的字母位置进行索引操作
            arr[ransomNote.charAt(i)-'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            if(arr[magazine.charAt(i)-'a']>0){
                arr[magazine.charAt(i)-'a']--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
