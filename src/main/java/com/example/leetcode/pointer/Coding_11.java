package com.example.leetcode.pointer;

/**
 * @author kai·yang
 * @Date 2022/7/15 14:05
 *
 * subject: 盛最多水的容器【11】
 * level： medium
 */
public class Coding_11 {

    /*

    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    说明：你不能倾斜容器。

    示例 1：


    输入：[1,8,6,2,5,4,8,3,7]
    输出：49
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    示例 2：

    输入：height = [1,1]
    输出：1
     */

    /**
     * 双指针
     *
     * 分析：
     *  左指针为：x，  右指针为：y， 两者之间的距离为：t
     *  那么此时的容量为: area1 = min（height[x], height[y]）* t
     *  然后移动指针，可想而知需要移动指针数据小的，
     *  假设：左指针小   x < y
     *   此时 左指针的下标为：x1, 两者的距离为：t-1
     *   那么此时容量为： area2 = min(height[x1], height[y]) * (t-1)
     *  最大容量为：max(area1,area2);
     *
     *
     *  为什么要移动指针数据小的呢？ 如果移动指针数据大的一侧，那么容量为 area = min(height[x], height[y1]) * (t-1),
     *
     * @param height
     */
    public int maxArea(int[] height){
        //头指针指向第一个元素
        int head = 0;
        //尾指针指向最后一个元素
        int tail = height.length - 1;
        //最大容量
        int max = 0;
        while ( head < tail ){
            int min = Math.min(height[head], height[tail]);
            max = Math.max(max, min * (tail - head));
            //判断容器那一侧的低，那一侧指针移动
            if (height[head] < height[tail]){
                head++;
            }else {
                tail--;
            }
        }
        return max;
    }


    public int maxArea20240301(int[] height){
        //左指针起始位置
        int left = 0;
        //右指针起始位置
        int right = height.length - 1;
        int maxA = 0;
        while(left < right){
            //找到左右边缘最低那个
            int minH = Math.min(height[left], height[right]);
            maxA = Math.max(maxA, (right - left) * minH);
            //判断容器那一侧的低，那一侧指针移动
            if (height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxA;
    }
}
