package CODEFORCE.UnCon;
import java.util.*;
public class Star_Trek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc --> 0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int a[] = new int[n];
            int res[] = new int[n];
            for(int i = 0; i<n ; i++){
                a[i] = sc.nextInt();
                res[i] = a[i]+(i+1);
            }
            
            Arrays.sort(res);
            int tele = 0;
            for(int i = 0; i<res.length ; i++){
                if(c>=res[i]){
                    c = c-res[i];
                    tele++;
                }
            }
            System.out.println(tele);
        }
    }

}
