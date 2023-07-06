package com.example.leetcode.sort;

import java.util.*;

/**
 * @author kai·yang
 * @Date 2023/7/6 16:52
 *
 * leetcode:【210】课程表II
 * level：medium
 * <link>https://leetcode.cn/problems/course-schedule-ii/
 * company: 字节
 */
public class Coding_210 {

    /**
     * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中
     * isites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
     *
     *  例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
     *
     *  返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组
     *
     *  示例 1：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：[0,1]
     * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     *
     *  示例 2：
     *
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：[0,2,1,3]
     * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     *  示例 3：
     *
     * 输入：numCourses = 1, prerequisites = []
     * 输出：[0]
     *
     *
     * 提示：
     *
     *  1 <= numCourses <= 2000
     *  0 <= prerequisites.length <= numCourses * (numCourses - 1)
     *  prerequisites[i].length == 2
     *  0 <= ai, bi < numCourses
     *  ai != bi
     *  所有[ai, bi] 互不相同
     *
     *  Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
     */


    /**
     * 经典的【拓扑排序】问题
     * 给定一个包含 n 个节点的有向图 G，我们给出它的节点编号的一种排列，如果满足：
     *
     * 对于图 G 中的任意一条有向边 (u, v)，u 在排列中都出现在 v 的前面。
     * 那么称该排列是图 G 的「拓扑排序」。根据上述的定义，我们可以得出两个结论：
     *
     * 如果图 G 中存在环（即图 G 不是「有向无环图」），那么图 G 不存在拓扑排序。这是因为假设图中存在环  ，那么 x_1 在排列中必须出现在 x_n 的前面，但 x_n 同时也必须出现在 x_1 的前面，因此不存在一个满足要求的排列，也就不存在拓扑排序；
     *
     * 如果图 G 是有向无环图，那么它的拓扑排序可能不止一种。举一个最极端的例子，如果图 G 值包含 n 个节点却没有任何边，那么任意一种编号的排列都可以作为拓扑排序。
     *
     *
     *
     * 广度优先遍历
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null){
            return new int[0];
        }
        //存放节点指向的节点
        List<Integer>[] cite = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            cite[i] = new ArrayList<>();
        }
        //存放节点入度（被引用次数）
        int[] indegree = new int[numCourses];
        for (int[] item : prerequisites){
            indegree[item[0]]++;
            cite[item[1]].add(item[0]);
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i ++){
            if (indegree[i] == 0){
                queue.push(i);
            }
        }
        //结果
        int[] result = new int[numCourses];
        //已经完成检索的个数
        int count = 0;
        while(!queue.isEmpty()){
            Integer zero = queue.pop();
            result[count++] = zero;
            List<Integer> target = cite[zero];
            for (int i = 0; i < target.size(); i++){
                //对应的节点入度减一，如果为0，则可以当作下一次起始点
                if (--indegree[target.get(i)] == 0){
                    queue.push(target.get(i));
                }
            }
        }
        if (count == numCourses){
            return result;
        }
        return new int[0];
    }

}
