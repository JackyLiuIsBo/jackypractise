package pracktiseskill.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName minPathSum
 * @Description
 * @Author liubo
 * @Date 2021/5/16 4:36 下午
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class minPathSum {
    int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};


        int i = minPathSum(grid);
        System.out.println(i);
    }
    public static int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            dp[i][0] =  dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            dp[0][i] =  dp[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
