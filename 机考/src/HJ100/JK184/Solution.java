package HJ100.JK184;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//完美走位
public class Solution {
    //AASSSDDDDSADASDASDASSADWASWDWASWDWASWDWASWSWAWDAWSDWSWWSWSWDSWAWDWADWAWDWAWSWDWASDWASDWASWDWSWSWSWWSAWAWAWWAWDWDWDWDWSWSWWSDADADWAWSWDSWADWASDWAWDWAD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length() / 4;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('S', 0);
        map.put('W', 0);
        map.put('D', 0);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        int count = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) < n) {
                count += n - map.get(key);
            }
        }
        System.out.println(count);
    }
}
