package pracktiseskill.shuzu;

import java.util.HashMap;

/**
 * @ClassName fourSumCount
 * @Description
 * @Author liubo
 * @Date 2021/5/9 2:32 下午
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 **/
public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num1 : nums1){
            for(int num2: nums2){
                map.put(num1 + num2,map.getOrDefault(num2+num1,0) + 1);
            }
        }
        int result = 0;
        for(int num3 : nums3){
            for(int num4: nums4){
                if(map.containsKey(-num3 - num4) ){
                    result += map.get(-num3 - num4) ;
                }
            }
        }
        return result;
    }
}