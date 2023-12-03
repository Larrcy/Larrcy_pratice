package HJ.JK003;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[]samples =new int[split.length];
        for (int i = 0; i < split.length; i++) {
            samples[i]=Integer.parseInt(split[i]);
        }
        System.out.println(func(m,t,p,samples));
    }
    private static int func(int m, int t, int p, int[] samples) {
        // 下标 i ->  正常迭代下标.
        int i= 0;
        int n = samples.length;
        int cycle = 0,fail = 0;

        // 用一个栈把正常数据的下标都给保存下来.
        Deque<Integer> deque = new LinkedList<>();

        while(i < n) {
            //  直接判断在 M 周期内是不是进入了故障恢复期.
            if(cycle <= m) {
                // cycle永远小于M，因为进入下一个周期，会重置 cycle 和 fail.
                if(fail == t) {
                    // 这个时候进入恢复周期，产生故障之后，优先进入恢复周期，即使 M 周期没有走完.
                    // 恢复周期为 T
                    int count = p;
                    while(count > 0 && i < n) {
                        if(judge(samples, i)) {
                            // 这里的话， 表示数据还是异常.
                            count = p;
                        } else {
                            count--;
                        }
                        i++;
                    }
                    // 如果已经恢复，那么进入到正常的周期循环，此时 i 的位置代表了，数据恢复正常之后的第一个数据位置.
                    cycle = fail = 0;
                    continue;
                }
                if(cycle == m) {
                    // 进入下一个周期.
                    cycle = fail = 0;
                    continue;
                }
            }

            // true ： 数据采样错误.
            if(judge(samples, i)) {
                // 故障次数+1
                fail++;
                //  数据故障，判断是否可以被近似正常值代替.
                //  栈不为空，表示存在近似正常数据.
                if(!deque.isEmpty()) {
                    samples[i] = samples[deque.peek()];
                    deque.push(i);
                }
            } else {
                //  如果是正确采样数据的话，保存下标.
                deque.push(i);
            }
            // 周期数+1
            cycle++;
            i++;
        }

        int ans = 0;
        int lastIndex = deque.pop();
        int temp = 1;
        while(!deque.isEmpty()) {
            if(deque.peek() + 1 == lastIndex) {
                temp++;
                lastIndex = deque.pop();
            } else {
                ans = Math.max(ans, temp);
                lastIndex = deque.pop();
                temp = 1;
            }
        }

        return ans==0?temp:ans;
    }

    private static boolean judge(int[] samples, int i) {
        return samples[i] <= 0 || (i >= 1 && (samples[i] < samples[i-1])) || samples[i] - samples[i-1] >= 10;
    }
}
