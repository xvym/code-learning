package cn.com.xvym.learning.leetcode.no103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Xv
 * @Date: 2021/5/17 22:13
 * @Description:
 */
public class No103Test {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean startFromLeft = true;
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> temp = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = stack.pop();
                level.add(treeNode.val);
                if (startFromLeft) {
                    if (treeNode.left != null) {
                        temp.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        temp.push(treeNode.right);
                    }
                } else {
                    if (treeNode.right != null) {
                        temp.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        temp.push(treeNode.left);
                    }
                }
            }
            startFromLeft = !startFromLeft;
            stack = temp;
            res.add(level);
        }
        return res;
    }
}
