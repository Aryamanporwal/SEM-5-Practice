package TREE.Leetcode;

public class insert_into_BinarySearchTree {
    class Node {
        int val;
        Node left;
        Node right;
    }

    class Solution {
        public Node insertintoBST(Node root , int val){
            if(root == null){
                return new Node();
            }
            if(root.val < val){
                root.right = insertintoBST(root.right, val);
            }else{
                root.left = insertintoBST(root.left , val);
            }
            return root;
        }
    }
    
}
