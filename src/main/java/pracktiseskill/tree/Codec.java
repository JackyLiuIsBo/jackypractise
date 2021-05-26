package pracktiseskill.tree;

import java.util.Arrays;
import java.util.LinkedList;

import leetcode.TreeNode;

/**
 * @ClassName Codec
 * @Description
 * @Author liubo
 * @Date 2021/5/9 5:17 下午
 **/
public class Codec {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("abc");
        s.append(",");
        System.out.println(s.toString());
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#,";
        }
        StringBuilder str = new StringBuilder();
        str.append(root.val +",");
        str.append(serialize(root.left));
        str.append(serialize(root.right));
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] datas =  data.split(",");
        LinkedList<String> list = new LinkedList(Arrays.asList(datas));
        return dfs(list);

    }
    public TreeNode dfs(LinkedList<String> list){
        String node = list.poll();
        if(node == null || node.equals("#") ){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = dfs(list);
        root.right = dfs(list);
        return root;
    }

}
