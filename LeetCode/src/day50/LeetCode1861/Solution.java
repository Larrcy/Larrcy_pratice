package day50.LeetCode1861;

public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] b = new char[m][n];    //记录旋转之后的数组
        for(int i = 0; i < n; i++)     //旋转90°
            for(int j = 0; j < m; j++)
                b[j][n - i - 1] = box[i][j];
        for(int j = 0; j < n; j++) {    //从第一列开始循环
            int d = m - 1;  //d用于盒子下落的能到达的最低位置
            for(int i = m - 1; i >= 0; i--) {   //从底部开始往上遍历
                if(b[i][j] == '*')  //如果是障碍物，更新盒子下落的能到达的最低位置
                    d = i - 1;
                else if(b[i][j] == '#') {  //如果是盒子，将盒子落到d的位置上
                    b[i][j] = '.';
                    b[d][j] = '#';
                    d--;
                }
            }
        }
        return b;
    }


}
