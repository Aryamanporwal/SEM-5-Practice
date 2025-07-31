package IntereFace;

public class interface_client implements DSAI{

    public static void main(String[] args) {
        interface_client obj = new interface_client();
        obj.push(10);
        obj.pop();
        obj.peek();
        obj.Display();
        obj.size();
        obj.isEmpty();
    }

    @Override
    public void push(int item) {
        System.out.println("Push method called with item: " + item);
    }
    
    
        @Override
        public void pop() {
            System.out.println("Pop method called");
        }
    
        @Override
        public void peek() {
            System.out.println("Peek method called");
        }
    
        @Override
        public void Display() {
            System.out.println("Display method called");
        }
    
        @Override
        public void fun() {
            System.out.println("Fun method called");
        }
    
        @Override
        public void size() {
            System.out.println("Size method called");
        }
    
        @Override
        public boolean isEmpty() {
            System.out.println("isEmpty method called");
            return false;
        }
}