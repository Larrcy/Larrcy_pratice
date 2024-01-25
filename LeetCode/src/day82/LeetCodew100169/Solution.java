package day82.LeetCodew100169;
import java.util.*;
/**
 * 有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 hFences 和 vFences 给出。
 *
 * 水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, vFences[i]) 。
 *
 * 返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。
 *
 * 由于答案可能很大，所以请返回结果对 109 + 7 取余 后的值。
 */
public class Solution {
    //暴力枚举水平栅栏与垂直栅栏的所有差值
    //找到差值相同的值取最大值
    public  int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> h = f(hFences, m);
        Set<Integer> v = f(vFences, n);
        int ans = 0;
        for (int x : h) {
            if (v.contains(x)) {
                ans = Math.max(ans, x);
            }
        }
        if (ans == 0) {
            return -1;
        }
        //最后记得取模
        return (int) ((long) ans * ans % 1_000_000_007);
    }
    public  Set<Integer> f(int[] a, int mx) {
        int[] newArray = Arrays.copyOf(a, a.length + 2);
        //将边界也加进去
        newArray[a.length] = 1;
        newArray[a.length + 1] = mx;
        Arrays.sort(newArray);
        //暴力枚举所有边的距离
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                set.add(newArray[j] - newArray[i]);
            }
        }
        return set;
    }
}
