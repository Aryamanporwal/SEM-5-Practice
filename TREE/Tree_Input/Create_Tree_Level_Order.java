package TREE.Tree_Input;
import java.util.*;
public class Create_Tree_Level_Order {
    class Node {
        int val;
        Node left;
        Node right;
    }

   private Node root;
   public Create_Tree_Level_Order() {
        createTree();
    }
    private void createTree(){
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        Node nn = new Node();
        nn.val = sc.nextInt();
        root = nn;
        q.add(nn);
        while(!q.isEmpty()){
            Node r = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if(c1 != -1){
                Node node = new Node();
                node.val = c1;
                r.left = node;
                q.add(node);
            }
            if(c2 != -1){
                Node node = new Node();
                node.val = c2;
                r.right = node;
                q.add(node);
            }
        }
    }
    public void display() {
        display(root);
    }

    private void display(Node nn) {
        if (nn == null) {
            return;
        }
        String s = "<--" + nn.val + "-->";
        if (nn.left != null) {
            s = nn.left.val + s;
        } else {
            s = "." + s;
        }
        if (nn.right != null) {
            s = s + nn.right.val;
        } else {
            s = s + ".";
        }
        System.out.println(s);
        display(nn.left);
        display(nn.right);
    }
}
