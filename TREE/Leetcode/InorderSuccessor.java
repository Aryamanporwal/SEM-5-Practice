package TREE.Leetcode;

public class InorderSuccessor {
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
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {  
            TreeNode ans = null;
            while(root != null){
                if(p.val < root.val){
                    ans = root;
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
            return ans;
        }
    } 
}
