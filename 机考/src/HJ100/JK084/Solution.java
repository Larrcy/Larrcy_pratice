package HJ100.JK084;

import java.util.*;
//不等式
public class Solution {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            solution(line);
        }

    private static void solution(String line) {
        String[] split1 = line.split(";");
        boolean right = true;
        //list来记录结果
        List<Integer> list = new LinkedList<>();

        // 不等式约束（字符串类型）
        String[] limits = split1[split1.length - 1].split(",");
        // 不等式目标值（double类型）
        String[] aims = split1[split1.length - 2].split(",");
        // 不等式变量（int类型）
        String[] vars = split1[split1.length - 3].split(",");
        // 不等式组系数（double类型）
        for (int i = 0; i < limits.length; i++) {
            double value = 0;
            double aim = Double.parseDouble(aims[i]);
            // 系数
            String[] split = split1[i].split(",");
            for (int j = 0; j < split.length; j++) {
                value += Double.parseDouble(split[j]) * Integer.parseInt(vars[j]);
            }
            String limit = limits[i];
            //e用来记录最大差值
            int e = new Double(Math.abs(value - aim)).intValue();
            switch (limit) {
                case ">":
                    right = (value > aim) && right;
                    list.add(e);
                    break;
                case "<":
                    right = (value < aim) && right;
                    list.add(e);
                    break;
                case ">=":
                    right = (value >= aim) && right;
                    list.add(e);
                    break;
                case "<=":
                    right = (value <= aim) && right;
                    list.add(e);
                    break;
                default:
                    right = false;
            }
        }

        System.out.print(right + " ");
        System.out.println(list.stream().max(Integer::compareTo).get());
    }
}
