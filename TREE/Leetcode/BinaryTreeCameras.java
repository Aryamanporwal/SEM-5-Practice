package TREE.Leetcode;

public class BinaryTreeCameras {
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
        int camera = 0;
        public int minCameraCover(TreeNode root) {
            // -1 = need a cmaera
            // 1 = has a camera
            // 0 = covered  
            int c = minCamera(root);
            if(c == -1){
                camera++;
            }
            return camera;
        
        }

        public int minCamera(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = minCamera(root.left);
            int right = minCamera(root.right);
            if(left == -1 || right == -1){ //camera ki need hai
                camera++;
                return 1; // placed a camera here;
            }
            else if(left == 1 || right == 1){ //camera ki need nahi hai , kisi ek ke pass a dono k pass camera hai
                return 0; // covered hai camera
            }
            else {
                return -1; //dono ke pass camera nahi hai, dono ke pass camera ki need hai
            }


        }
    }
}
