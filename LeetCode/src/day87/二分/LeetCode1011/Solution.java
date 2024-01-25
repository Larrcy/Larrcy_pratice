package day87.二分.LeetCode1011;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
public class Solution {
    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        //确定左右区间
        //左区间应当为weights中的最大值 保证所有货物都能装上船
        //右区间为sum(weights)
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) > days) {
                //此时要加快吃香蕉的速度
                left = mid + 1;
            } else {
                //满足条件但速度过快 需要降低速度
                right = mid - 1;
            }
        }
        return left;

    }
}
