package pracktiseskill.hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName canFinish
 * @Description
 * @Author liubo
 * @Date 2021/5/20 3:55 下午
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 **/
public class canFinish {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 1}};
        canFinish(2, prerequisites);
    }

    //先构建拓扑图，然后从入度为零的节点依次开始遍历
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {

            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public boolean canFinishTest(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjecent = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjecent.add(new ArrayList<>());
        }
        //计算出每个节点的入度
        for (int[] temp : prerequisites) {
            adjecent.get(temp[1]).add(temp[0]);
            degree[temp[0]]++;
        }
        //添加入度为0的节点进入队列
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            numCourses--;
            //其他节点入度减少为0后，需要添加到队列
            for (int temp : adjecent.get(poll)) {
                if (--degree[temp] == 0) {
                    queue.add(temp);
                }
            }
        }

        return numCourses == 0;

    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { adjacency.add(new ArrayList<>()); }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) { adjacency.get(cp[1]).add(cp[0]); }
        for (int i = 0; i < numCourses; i++) { if (!dfs(adjacency, flags, i)) { return false; } }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) { return false; }
        if (flags[i] == -1) { return true; }
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) { if (!dfs(adjacency, flags, j)) { return false; } }
        flags[i] = -1;
        return true;
    }

}
