package pracktiseskill.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.util.StringUtils;

//todo

/**
 * 求全排列和子集有所不同，全排列需要对当前的位置进行交换，下一步迭代需要对当前位置+1，而求子集则是对for循环的变量+1
 */
public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> abc = Permutation("abc");
        for (String s:abc
             ) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if (StringUtils.isEmpty(str)){
            return result;
        }
        char[] chars = str.toCharArray();
        int size = str.length();
        sort(size,0,chars,set);
        result.addAll(set);
        Collections.sort(result);

        return result;
    }

    private static void sort(int size, int start, char[] chars, HashSet<String> result) {

        if (start == size-1){

            result.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++){
            swap(chars,i,start);

            sort(size,start+1,chars,result);
            swap(chars,start,i);
        }

    }

    static void  swap(char[] array,int left,int right){
        char temp = array[left];

        array[left] = array[right];

        array[right] = temp;
    }


    //public static ArrayList<String > Permutation(String str) {
    //
    //    ArrayList<String> arrayList = new ArrayList<>();
    //    HashSet<String> set = new HashSet<>();
    //    Sort(str.toCharArray(),set ,0);
    //    arrayList.addAll(set);
    //    Collections.sort(arrayList);
    //    return arrayList;
    //}
    //public static void Sort(char[] array, HashSet set,int k){
    //    if (k == array.length-1){
    //        set.add(new String(array));
    //    }
    //    for (int i = k; i  < array.length; i++){
    //        swap(array,i,k);
    //        Sort(array,set,k+1);
    //        swap(array,i,k);
    //    }
    //
    //}
    //public static void swap(char [] chars, int left, int right){
    //    char temp = chars[left];
    //    chars[left] = chars[right];
    //    chars[right] = temp;
    //}


/*    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }
    static void  fun(HashSet<String> re, char[] str, int k) {
        if (k == str.length - 1) {
            re.add(new String(str));
            return;
        }
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            swap(str, i, k);
        }
    }
    static void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }*/
}
