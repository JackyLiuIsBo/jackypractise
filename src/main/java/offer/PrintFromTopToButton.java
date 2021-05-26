package offer;

import java.util.ArrayList;
import java.util.LinkedList;

import sun.awt.image.ImageWatched.Link;

/**
 * @ClassName PrintFromTopToButton
 * @Description
 * @Author liubo
 * @Date 2020/11/20 1:20 下午
 **/
public class PrintFromTopToButton {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode pop = queue.pop();
            result.add(pop.val);

            if (pop.left != null){
                queue.add(pop.left);
            }

            if (pop.right != null){
                queue.add(pop.right);
            }
        }
        return result;
    }
}
