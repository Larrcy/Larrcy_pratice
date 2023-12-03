package HJ100.JK197;

import java.util.*;

//找数字
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ints = new int[n][m];
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ints[i][j] = sc.nextInt();
            }
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map.containsKey(ints[i][j])) {
                    map.put(ints[i][j], new ArrayList<>());
                }
                map.get(ints[i][j]).add(new int[]{i, j});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(ints[i][j]).size() == 1) {
                    res[i][j] = -1;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < map.get(ints[i][j]).size(); k++) {
                    if (map.get(ints[i][j]).get(k)[0] == i && map.get(ints[i][j]).get(k)[1] == j) {
                        continue;
                    }
                    min = Math.min(min, (Math.abs(map.get(ints[i][j]).get(k)[0] - i) + Math.abs(map.get(ints[i][j]).get(k)[1] - j)));
                }
               res[i][j]=min;
            }
        }
        List<List<Integer>>arrayList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer>list =new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(res[i][j]);
            }
            arrayList.add(list);
        }
        System.out.println(arrayList);
    }
}
