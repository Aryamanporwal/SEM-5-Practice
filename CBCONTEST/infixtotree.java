import java.util.*;
public class infixtotree {
     public class TreeNode {
      char val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(char val) { this.val = val; }
      TreeNode(char val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
        public static TreeNode expTree(String s){
            String PostFix = getPostFix(s);
            Stack<TreeNode> st = new Stack<>();
            for(int i = 0; i<PostFix.length() ; i++){
                char ch = PostFix.charAt(i);
                if(ch=='+'|| ch=='-' || ch== '*'|| ch=='/'){
                    TreeNode nn = new TreeNode();
                    TreeNode right = st.pop();
                    TreeNode left = st.pop();
                    st.push(nn);
                }else{
                    st.push(new TreeNode(ch));
                }
            }

            return st.peek();
        }
        public static String getPostFix(String s){
            StringBuilder sb = new StringBuilder();
            Stack<Character> st = new Stack<>();
            for(int i = 0; i< s.length() ; i++){
                char ch = s.charAt(i);
                if(ch>='0' && ch<='9'){
                    sb.append(ch);
                }
                else if(ch=='('){
                    st.push(ch);
                }
                else if(ch==')'){
                    while(st.peek() != '('){
                        sb.append(st.pop());
                    }
                    st.pop();
                }
            }

            while(!st.isEmpty()){ 
                sb.append(st.pop());
            }
            return sb.toString();
        }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        TreeNode nn = expTree(s);
    }

}
