package TREE;
import java.util.*;
public class createTreeUsingLevelOrder {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    private Node root;
    public createTreeUsingLevelOrder(){
        createTree();
    }
    private void createTree(){
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        Node node = new Node(e);
        root = node;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node rv = q.poll(); //poll = remove first
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if(c1!=-1){
                Node nn = new Node(c1);
                rv.left = nn;
                q.add(nn);
            }
            if(c2!=-1){
                Node nn = new Node(c2);
                rv.right = nn;
                q.add(nn);
            }

        }

    }

    public void Display(){
        Display(root);
    }
   
    private void Display(Node nn){
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

   public static void main(String[] args) {
        createTreeUsingLevelOrder cl = new createTreeUsingLevelOrder();
        cl.Display();
   }

}
