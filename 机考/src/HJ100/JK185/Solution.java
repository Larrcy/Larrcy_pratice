package HJ100.JK185;

import javafx.scene.transform.Scale;

import java.util.Scanner;
//自动曝光
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        double count = 0;
        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) > 255) {
                count += 255;
            } else count += Math.max(Integer.parseInt(split[i]), 0);
        }
        double avg = 0;
        avg = count / split.length;
        int suf = (int) Math.round(avg - 128);
        System.out.println(-suf);
    }
}
