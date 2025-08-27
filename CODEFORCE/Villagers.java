package CODEFORCE;
import java.util.*;

public class Villagers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            int n = sc.nextInt();
            long[] g = new long[n];
            long sum = 0;
            long max = 0;
            for(int i=0; i<n; i++){
                g[i] = sc.nextLong();
                sum += g[i];
                if(g[i] > max) max = g[i];
            }
            
            long ans = Math.max(sum, 2 * max);
            System.out.println(ans);
        }
        sc.close();
    }
}
