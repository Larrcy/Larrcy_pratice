package day82.LeetCode1947;

/**
 * 有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。
 *
 * 这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，其中 students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，其中 mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。
 *
 * 每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。
 *
 * 例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
 * 请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。
 *
 * 给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。
 */
public class Solution {
    private int max = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int[] visited = new int[m];
        backtrack(students,mentors,0,0, visited);
        return max;
    }
    /**
     cur代表当前要处理哪个学生的配对
     sum代表处理到学生cur之前已经积累的兼容性评分
     visited主要来统计哪个导师在之前已经被配对过了
     */
    private void backtrack(int[][] students, int[][] mentors, int cur, int sum ,int[] visited){
        if(cur == students.length){
            max= Math.max(max,sum);
            return;
        }
        for(int i = 0; i < visited.length; i++){
            //代表该导师i已经在我们当前处理的这个时间被配对过了，需要继续找到下一个没有被配对的导师
            if(visited[i]==1){
                continue;
            }
            visited[i] = 1;
            //学生cur与导师i配对，使用cnt来统计这一个配对的兼容性评分
            int cnt = 0;
            for(int j = 0; j < students[0].length; j++){
                if(students[cur][j] == mentors[i][j]){
                    cnt++;
                }
            }
            //进行下一个学生的配对
            backtrack(students,mentors,cur+1,sum + cnt, visited);
            visited[i] = 0;
        }
    }
}
