package basic.Poxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

public class test {
    public static void main(String[] args) {

        int n = 11,a = 3,b = 5;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result1 = getResult(result, list, n);
        System.out.println(Arrays.toString(result1.toArray()));
    }
    public static List<List<Integer>> getResult(List<List<Integer>> result,List<Integer> list,int target){
        if(target < 0){
            return result;
        }

        if (target == 0){
             result.add(new ArrayList<>(list));
             return result;
        }
        list.add(3);
        getResult(result,list,target-3);
        list.remove(list.size()-1);

        list.add(5);
        getResult(result,list,target-5);
        list.remove(list.size() - 1);

        return result;
    }
}
