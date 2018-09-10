package adobe;

//Basically, it is the preOrder traversal of tree with everything as right skewed tree.

// Find the rightmost child of left subtree and make the right subtree the right child of that node

/*
If you notice carefully in the flattened tree, each node’s right child points to the next node of a pre-order traversal.

Now, if a node does not have left node, then our problem reduces to solving it for the node->right.
If it does, then the next element in the preorder traversal is the immediate left child.
But if we make the immediate left child as the right child of the node, then the right subtree will be lost.
So we figure out where the right subtree should go. In the preorder traversal, the right subtree comes right after
the rightmost element in the left subtree.
So we figure out the rightmost element in the left subtree, and attach the right subtree as its right child.
We make the left child as the right child now and move on to the next node.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

 public class FlattenBinaryTreeToLinkedList {
    //in-place iterative right skewed
    public TreeNode flattenInPlaceRight(TreeNode a) {

        if(a==null)
            return null;

        TreeNode node=a;
        while(node!=null)
        {
            if(node.left!=null)
            {
                TreeNode rightmost=node.left;
                while(rightmost.right!=null)
                {
                    rightmost=rightmost.right;
                }
                rightmost.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
        }
        return a;
    }

     //in-place iterative left skewed
     public TreeNode flattenInPlaceLeft(TreeNode a) {

         if(a==null)
             return null;

         TreeNode node=a.left;
         while(node!=null)
         {
             if(node.left != null) {
                 TreeNode leftMost = node.left;
                 while(leftMost.left != null) {
                     leftMost = leftMost.left;
                 }
                 leftMost.left=node.right;
                 node.right=node.left;
                 node.left=null;
             }

             if(node.left!=null)
             {
                 TreeNode rightmost=node.left;
                 while(rightmost.right!=null)
                 {
                     rightmost=rightmost.right;
                 }
                 rightmost.left=node.right;
                 node.right=node.left;
                 node.left=null;
             }
             node=node.right;
         }
         return a;
     }

    // creating a new tree by preOrder traversal
    TreeNode head=new TreeNode(0);
     TreeNode cur=head;

     public TreeNode flatten(TreeNode a) {
         //preOrder traversal
         preOrder(a);
         return head.right;
     }
     public void preOrder(TreeNode a){
         if(a==null){
             return;
         }
         //cur.left
         cur.right=new TreeNode(a.val);
         cur=cur.right;
         //cur=cur.left: // left skewed
         preOrder(a.left);
         preOrder(a.right);
     }

     public void printRightSkewedTree(TreeNode root) {
         while(root != null) {
             System.out.println(root);
             root = root.right;
         }
     }

     public void printLeftSkewedTree(TreeNode root) {
         while(root != null) {
             System.out.println(root);
             root = root.left;
         }
     }

     public TreeNode exampleTree(){
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.left.left = new TreeNode(3);
         root.left.right = new TreeNode(4);
         root.right = new TreeNode(5);
         root.right.right = new TreeNode(6);

         return root;
     }
}
