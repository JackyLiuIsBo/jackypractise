package pracktiseskill.hot100;

/**
 * @ClassName sortColors
 * @Description
 * @Author liubo
 * @Date 2021/5/18 11:00 下午
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 **/
public class sortColors {
    public void sortColors(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length()-1);
        int left = 0,mid = 0,right = nums.length-1;
        if(nums == null || nums.length <=1){
            return ;
        }
        for(int i = 0;i <= right; i++){
            while(i <= right && nums[i] == 2){
                swap(nums,i,right);
                right--;
            }

            if(nums[i] == 0){
                swap(nums,i,left);
                left++;
            }

        }
    }
    public void swap(int [] array,int left,int right){
        int tmep = array[left];
        array[left] = array[right];
        array[right] = tmep;
    }
}
