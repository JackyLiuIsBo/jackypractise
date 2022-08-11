package leetcode.math;

import designs.pattern.creational.prototype.abstractprototype.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println("size: "+ list.size());
        list.add(2);
    }
    private ArrayList<Integer> list ;
    private HashMap<Integer,Integer> map;
    private Random random ;
    public RandomizedSet(){
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val){
        if (map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val){
        if (!map.containsKey(val)){
            return false;
        }

        Integer pos = map.get(val);
        if (pos < list.size()-1){
            list.set(pos,list.get(list.size())-1);
            map.put(list.get(list.size()-1),pos);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }


    public int getRandom(){
        return list.get(random.nextInt(list.size()));
    }




















//    ArrayList<Integer> nums;
//    HashMap<Integer, Integer> locs;
//    java.util.Random rand = new java.util.Random();
//    /** Initialize your data structure here. */
//    public RandomizedSet() {
//        nums = new ArrayList<Integer>();
//        locs = new HashMap<Integer, Integer>();
//    }
//
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        boolean contain = locs.containsKey(val);
//        if ( contain ) return false;
//        locs.put( val, nums.size());
//        nums.add(val);
//        return true;
//    }
//
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        boolean contain = locs.containsKey(val);
//        if ( ! contain )
//            return false;
//        int loc = locs.get(val);
//        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
//            int lastone = nums.get(nums.size() - 1 );
//            nums.set( loc , lastone );
//            locs.put(lastone, loc);
//        }
//        locs.remove(val);
//        nums.remove(nums.size() - 1);
//        return true;
//    }
//
//    /** Get a random element from the set. */
//    public int getRandom() {
//        return nums.get( rand.nextInt(nums.size()) );
//    }
}
