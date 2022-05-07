package pracktiseskill.backpackproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        getSubSet(result, temp, 0, nums);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void getSubSet(List<List<Integer>>result,List<Integer> temp,
                                                int index,int[] nums){
        if(index > nums.length){
            return ;
        }
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            getSubSet(result, temp, i + 1, nums);
            temp.remove(temp.size()-1);
        }
    }
}
