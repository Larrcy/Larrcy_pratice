package HJ100.JK073;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int r = sc.nextInt();
        solution(line, r);
    }


    private static void solution(String line, int r) {
        List<Integer> m = Arrays.stream(line.split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int max = -1;
        for (int i = 0; i < m.size() ; i++) {
            for (int j = i+1; j < m.size(); j++) {
                for (int k = j+1; k < m.size(); k++) {
                        int sum = m.get(i) + m.get(j) + m.get(k);
                        if (sum <= r && sum > max) {
                            max = sum;
                        }

                }
            }
        }
        System.out.print(max);
    }
}
