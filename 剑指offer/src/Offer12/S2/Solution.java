package Offer12.S2;

public class Solution {
    public int[] constructArr(int[] a) {
        if(a.length==0||a==null)return null;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[]res =new int[a.length];
        left[0]=1;
        right[right.length-1]=1;
        for (int i = 1; i < a.length; i++) {
            left[i]=left[i-1]*a[i-1];
        }
        for (int i =a.length-2; i>=0; i--) {
            right[i]=right[i+1]*a[i+1];
        }
        for (int i = 0; i < a.length; i++) {
            res[i]=left[i]*right[i];
        }
        return res;
    }
}
