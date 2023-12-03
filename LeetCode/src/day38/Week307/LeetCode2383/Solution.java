package day38.Week307.LeetCode2383;

public class Solution {
    public static void main(String[] args) {
        int initialEnergy=3;
        int initialExperience=2;
        int[] energy={1};
        int[] experience={2};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int a = 0;
        int b = 0;
        int sum1 = 0;
        for (int i = 0; i < energy.length; i++) {
            sum1 += energy[i];
        }
        a = sum1 - initialEnergy + 1;

        for (int i = 0; i < experience.length; i++) {
            if(initialExperience <= experience[i]) {
                b += experience[i] - initialExperience + 1;
                initialExperience+=experience[i] - initialExperience + 1;
            }
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            }


        }
        if (a <= 0 ){
            a=0;
        }
        if(b<=0){
            b=0;
        }
        return a + b;
    }
}
