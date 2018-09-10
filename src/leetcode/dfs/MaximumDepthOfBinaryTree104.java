package leetcode.dfs;

import leetcode.TreeNode;

public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
