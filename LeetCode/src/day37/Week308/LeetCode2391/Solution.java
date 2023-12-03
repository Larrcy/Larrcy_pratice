package day37.Week308.LeetCode2391;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int M = 0;
        int P = 0;
        int G = 0;
        List<Integer> Mindex = new ArrayList<>();
        List<Integer> Pindex = new ArrayList<>();
        List<Integer> Gindex = new ArrayList<>();
        Mindex.add(0);
        Pindex.add(0);
        Gindex.add(0);
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    M++;
                    Mindex.add(i);
                }
                if (garbage[i].charAt(j) == 'P') {
                    P++;
                    Pindex.add(i);
                }
                if (garbage[i].charAt(j) == 'G') {
                    G++;
                    Gindex.add(i);
                }
            }
        }
        int Ml = 0;
        int Pl = 0;
        int Gl = 0;
        for (int i = 0; i < Mindex.get(Mindex.size() - 1); i++) {
            Ml += travel[i];
        }
        for (int i = 0; i < Pindex.get(Pindex.size() - 1); i++) {
            Pl += travel[i];
        }
        for (int i = 0; i < Gindex.get(Gindex.size() - 1); i++) {
            Gl += travel[i];
        }
        return M+G+P+Ml+Pl+Gl;
    }
}
