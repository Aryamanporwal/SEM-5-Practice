package TREE;

public class balanced {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
  }
   class Solution {
    public boolean isBalanced(TreeNode root) {
        //balanced = |rh-lh| <= 1
        return isbalanced(root).isbal;
    }
    public balancedpair isbalanced(TreeNode root){
        if(root == null) return new balancedpair();
        balancedpair lbp = isbalanced(root.left);
        balancedpair rbp = isbalanced(root.right);
        balancedpair sdp = new balancedpair();
        sdp.ht = Math.max(lbp.ht, rbp.ht)+1;
        boolean sb = Math.abs(lbp.ht-rbp.ht)<=1;
        sdp.isbal = lbp.isbal && rbp.isbal && sb;
        return sdp;
    }
    class balancedpair{
        boolean isbal = true;
        int ht = -1;
    }
}
}
