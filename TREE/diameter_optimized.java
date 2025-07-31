package TREE;

public class diameter_optimized {
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
        public int diameterOfBinaryTree(TreeNode root) {
            return diameter(root).dia;
        }
        public diapair diameter(TreeNode root){
            if(root == null) return new diapair();
            diapair ldp = diameter(root.left);
            diapair rdp = diameter(root.right);
            diapair sdp = new diapair();
            sdp.ht = Math.max(ldp.ht, rdp.ht)+1;
            int sd = ldp.ht+rdp.ht+2;
            sdp.dia = Math.max(sd, Math.max(ldp.dia, rdp.dia));
            return sdp;
        }   
        class diapair{
            int dia = 0;
            int ht = -1;
        }
    }
}