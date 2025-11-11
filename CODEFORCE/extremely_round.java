package CODEFORCE;
import java.util.*;
public class extremely_round {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int count = 0;
            int p = 1;

            while (p <= n) {
                count += Math.min(9, n / p);
                p *= 10;
            }

            System.out.println(count);
        }
        sc.close();
    }
}
