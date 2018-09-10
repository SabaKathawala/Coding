package leetcode.dfs;

import leetcode.TreeNode;
public class BinaryTreeMaxPathSum127 {
    static int trueMax = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        int sum = dfs(root);
        return Math.max(trueMax,sum);
    }

    private static int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        //You can add only one of the children going up: either left child + root or right child + root
        //and send it upwards
        //this is for continuing recursion
        int maxToBeAdded = Math.max(root.val , root.val + Math.max(left, right));

        //but the max could be without the root or the ancestor

        trueMax = Math.max(trueMax,Math.max(maxToBeAdded, root.val + left + right));

        return maxToBeAdded;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        tree.root.right = new Node(10);
//        tree.root.left.left = new Node(20);
//        tree.root.left.right = new Node(1);
//        tree.root.right.right = new Node(-25);
//        tree.root.right.right.left = new Node(3);
//        tree.root.right.right.right = new Node(4);
        System.out.println(maxPathSum(root));

    }
}
