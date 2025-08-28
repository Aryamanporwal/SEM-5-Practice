import java.util.*;

public class topview {
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer , Integer> map = new TreeMap<>();
        ArrayList<Integer> ll = new ArrayList<>();
        view(root , ll , 0 , map);
        for(int key : map.keySet()){
            ll.add(map.get(key));
        }
        return ll;
    }
    public void view(Node root , List<Integer> ll , int curr, TreeMap<Integer, Integer> map){
        
        if(root==null){
            return;
        }
        if(!map.containsKey(curr)){
            map.put(curr, root.data);
        }
        
        view(root.left , ll , curr-1 , map);
        view(root.right , ll , curr+1 , map);
    }
}
}
