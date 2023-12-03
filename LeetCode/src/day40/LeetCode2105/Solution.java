package day40.LeetCode2105;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        if (plants.length % 2 == 0) {
            int count = 0;
            int countA = capacityA;
            int countB = capacityB;
            for (int i = 0; i < plants.length / 2; i++) {
                if(capacityA<plants[i]){
                    count++;
                    capacityA=countA;
                }
                if(capacityA>=plants[i]){
                    capacityA-=plants[i];
                }
            }
            for (int i = plants.length-1 ; i >= plants.length/2; i--) {
                  if(capacityB<plants[i]){
                    count++;
                    capacityB=countB;
                }
                if(capacityB>=plants[i]){
                    capacityB-=plants[i];
                }
            }
            return count;
        }else {

            int count = 0;
            int countA = capacityA;
            int countB = capacityB;
            for (int i = 0; i < plants.length / 2; i++) {
                if(capacityA<plants[i]){
                    count++;
                    capacityA=countA;
                }
                if(capacityA>=plants[i]){
                    capacityA-=plants[i];
                }
            }
            for (int i = plants.length-1 ; i >= plants.length/2+1; i--) {
                if(capacityB<plants[i]){
                    count++;
                    capacityB=countB;
                }
                if(capacityB>=plants[i]){
                    capacityB-=plants[i];
                }
            }
            if(Math.max(capacityA,capacityB)<plants[plants.length / 2])count++;
            return count;

        }
    }
}
