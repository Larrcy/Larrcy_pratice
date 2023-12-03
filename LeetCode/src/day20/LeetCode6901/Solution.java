package day20.LeetCode6901;

public class Solution {
    public static void main(String[] args) {
        int mainTank = 6;
        int additionalTank = 1;
        System.out.println(distanceTraveled(mainTank, additionalTank));
    }

    public static int distanceTraveled(int mainTank, int additionalTank) {
        if (mainTank < 5) {
            return mainTank * 10;
        }
        int result = 0;
        int a =mainTank/5;
        while (mainTank > 0) {
            if (mainTank - 5 >= 0&&additionalTank>0) {
                mainTank=mainTank-5;
                additionalTank=additionalTank-1;
                mainTank=mainTank+1;
                result = result + 5 * 10;
            } else {

                result = result + mainTank * 10;
                mainTank=0;
            }



        }
        return result;
    }
}
