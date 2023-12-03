package HJ100.JK194;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//静态扫描最优成本
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fee = sc.nextInt();
        sc.nextLine();
        String idsStr = sc.nextLine();
        String sizesStr = sc.nextLine();
        System.out.println(solution(fee, idsStr, sizesStr));

    }

    private static int solution(int m, String idsStr, String sizesStr) {
        Map<Integer, Integer> idCost = new HashMap<>();
        Map<Integer, Integer> idSize = new HashMap<>();
        String[] ids = idsStr.split(" ");
        String[] sizes = sizesStr.split(" ");

        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);
            int size = Integer.parseInt(sizes[i]);
            idCost.put(id, idCost.getOrDefault(id, 0) + 1);
            idSize.put(id, size);
        }

        int sum = 0;
        for (Integer id : idCost.keySet()) {
            int total = idCost.get(id) * idSize.get(id);
            idCost.put(id, Math.min(total, m + idSize.get(id)));
            sum += idCost.get(id);
        }
        return sum;
    }
}
