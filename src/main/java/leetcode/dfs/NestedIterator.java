package leetcode.dfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * link: https://leetcode.com/problems/flatten-nested-list-iterator/
 * flag : false
 * experience: 没做过，需要根据实际情况进行设计
 */
public class NestedIterator implements Iterator<Integer> {
    LinkedList<NestedInteger> stack ;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList();
        forEachPush(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        return !stack.isEmpty();
    }

    private void forEachPush(List<NestedInteger> nestedList){
        for(NestedInteger t : nestedList){
            if(t.isInteger()){
                stack.add(t);
            }else{
                forEachPush(t.getList());
            }
        }
    }

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

}
