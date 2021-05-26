package pracktiseskill.shuzu;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName majorityElement2
 * @Description
 * @Author liubo
 * @Date 2021/5/7 5:48 下午
 * 直观解释链接 https://leetcode-cn.com/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa-zui-zh/
 * 如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
 *
 * 如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
 *
 * 如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
 *
 * 所以以后碰到这样的问题，而且要求达到线性的时间复杂度以及常量级的空间复杂度，直接套上摩尔投票法。
 *
 * 接下来贴上代码：
 *
 *
 **/
public class majorityElement2 {
    public List<Integer> majorityElement(int[] nums) {

        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num)
                count1++;
            else if (cand2 == num)
                count2++;
        }

        if (count1 > nums.length / 3)
            res.add(cand1);
        if (count2 > nums.length / 3)
            res.add(cand2);

        return res;

    }
}
