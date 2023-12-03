package HJ100.JK191;

import java.util.*;
//寻找链表中间节点
public class Solution {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
            int head = scanner.nextInt();
            int n = scanner.nextInt();
            Map<Integer, int[]> link = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                int address = scanner.nextInt();
                int data = scanner.nextInt();
                int next = scanner.nextInt();
                link.put(address, new int[]{data, next});
            }
            int res = solution(head, link);
            System.out.println(res);
        }


    private static int solution(int head, Map<Integer, int[]> link) {
        if (link.size() == 0) {
            return -1;
        }
        List<Integer> data = new ArrayList<>();
        int next = head;
        //循环遍历map找头节点
        //找到则将节点加入结果集合
        //然后指向尾节点
        while (link.containsKey(next)) {
            int[] node = link.get(next);
            data.add(node[0]);
            next = node[1];
        }
        return data.get(data.size() / 2);
    }
}
