package day81.LeetCode780;

public class Solution {
    //反向考虑 从终点向出发点考虑
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //数值大的那个数一定是由数值小的那个数相加的来的
        //因此数值大的对数值小的取余
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }
        //若取余后跟初始位置相同则说明可以得到
        if (tx == sx && ty == sy) return true;
        else if (tx == sx) {
            //若取余后x的位置重合但y的位置不重合
            //则y需要减小 只有当y能被x整除时才可恢复到原点
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else return false;
    }
}

