public class first{
    public static void main(String[] args) {
        String [] arr = {"Taav Singh", "Harshit", "Chotu", "Pumpkin", "Jaan", "Babu"};
        Display(arr);
        Integer [] arr1 = {1, 2, 3, 4, 5, 6};
        Display(arr1);
    }
    public static <T> void Display(T[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
//generic ka mtlb h ek essa general class jo kisi bhi type ke liye use ho sake