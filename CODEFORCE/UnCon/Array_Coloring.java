package CODEFORCE.UnCon;
import java.util.*;
public class Array_Coloring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(); //length of a
            int a[] = new int[n];
            for(int i = 0; i<n ;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int min = 0;
            int max = a.length-1;
            int res = 0;
            while(max > min){
                res += a[max] - a[min];
                max--;
                min++;
            }
            System.out.println(res);
        }

        sc.close();
    }
    
}
