package day31.New.AC.LeetCode2379;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wNum = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                wNum++;
            }
        }
        int min =wNum;
        for (int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i-k)=='W'){
            wNum--;
            }
            if(blocks.charAt(i)=='W'){
                wNum++;
            }
            min=Math.min(min,wNum);
        }
        return min;
        }
    }
