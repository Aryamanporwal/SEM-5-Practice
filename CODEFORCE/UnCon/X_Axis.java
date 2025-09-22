package CODEFORCE.UnCon;
import java.util.*;
public class X_Axis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int x3 = sc.nextInt();
            int a[] = {x1 , x2 , x3};
            Arrays.sort(a);
            int smax = a[1];
            System.out.println(Math.abs(smax-a[0])+Math.abs(smax-a[2]));
        }
    }
}
