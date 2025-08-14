package TREE.Leetcode;

import java.util.*;

public class MaxWidth {
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
    public class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            Queue<Pair> q = new LinkedList<>();
            int width = 0;
            q.add(new Pair(root , 0));
            while(!q.isEmpty()){
                Pair start = q.peek();
                int s = q.size();
                Pair end = null;
                for(int i = 0 ; i<s ; i++){
                    end = q.poll();
                    if(end.node.left != null ){
                        q.add(new Pair(end.node.left , 2*end.index+1));
                    }
                    if(end.node.right != null){
                        q.add(new Pair(end.node.right , 2*end.index+2));
                    }
                }
                width = Math.max(width , end.index - start.index+1);
            }
            return width;
        }
    }

}
