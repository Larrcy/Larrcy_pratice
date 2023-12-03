package day29.LeetCode2038;

public class Solution {
    public boolean winnerOfGame(String colors) {
        String[] Alice = colors.split("B");
        String[] Bob = colors.split("A");
        int moveA = 0;
        int moveB = 0;
        for (int i = 0; i < Alice.length; i++) {
            if (Alice[i].length() >= 3) {
                moveA += Alice[i].length() - 2;
            }
        }
        for (int i = 0; i < Bob.length; i++) {
            if (Bob[i].length() >= 3) {
                moveB += Bob[i].length() - 2;
            }
        }
        return moveA > moveB;
    }
}
