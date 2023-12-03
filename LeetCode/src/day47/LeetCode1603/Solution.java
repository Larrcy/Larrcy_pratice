package day47.LeetCode1603;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int big;
    int small;
    int medium;

    public void ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.small = small;
        this.medium = medium;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1: {
                big--;
                return big >= 0;
            }
            case 2: {
                medium--;
                return medium >= 0;
            }
            case 3: {
                small--;
                return small >= 0;
            }
        }
        return false;
    }
}

