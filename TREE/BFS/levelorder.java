package TREE.BFS;

import java.util.*;
public class levelorder {
    
    class Node{
        int val;
        Node left;
        Node right;
    }
    
    private Node root;
    Scanner sc = new Scanner(System.in);
    public levelorder(){
        root = CreateTree();
    }

    private Node CreateTree(){
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;
        boolean hlc = sc.nextBoolean();
        if(hlc){
            nn.left = CreateTree();
        }
        boolean hrc = sc.nextBoolean();
        if(hrc){
            nn.right = CreateTree();
        }
        return nn;
    }

    public void Display(){
        Display(root);
    }

    public void Display(Node nn){
        if(nn == null){
            return;
        }
        String s = "";
        s = "<--"+nn.val+"-->";
        if(nn.left!=null){
            s = nn.left.val +s ;
        }else{
            s = "."+s;
        }
        if(nn.right != null){
            s = s+nn.right.val;
        }else{
            s = s+".";
        }
        System.out.println(s);
        Display(nn.left);
        Display(nn.right);
    }

    public static void nthlevel(Node root , int n ){
          if(root == null){
            return;
        }
        if (n==1) System.out.println(root.val+" ");
        System.out.println(root.val+" ");
        nthlevel(root.left , n-1);
        nthlevel(root.right , n-1);
    }
    public void levelOrder(){
        // LinkedList<Node> q = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        //add first , remove first
        q.add(root);
        while(!q.isEmpty()){
            Node rv = q.remove(); //remove first
            System.out.println(rv.val+" ");
            if(rv.left!=null){
                q.add(rv.left);
            }
            if(rv.right!=null){
                q.add(rv.right);
            }
        }
        System.out.println();
   
    }
}
