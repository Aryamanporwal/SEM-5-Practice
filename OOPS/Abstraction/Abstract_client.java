package Abstraction;
public class Abstract_client {
    public static void main(String[] args) {
       Abstract_demo ab = new Abstract_demo(){
        @Override
        public void payment(){

        }
        @Override
        public int No_of_items(){
            return 0;
        }
        };
    }
}
