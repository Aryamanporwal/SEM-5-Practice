package CODEFORCE.Contest;
import java.util.*;
public class SIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc= sc.nextInt();
        while(tc-->0){
            long x = sc.nextInt();
            long y = sc.nextInt();

            if(y>x){
                System.out.println(2);
                continue;    
            }

            if (y < x) {
                long s1_max = (x - y) / 2;
                long s1_min = 1;
                if (s1_min < y && y < x - s1_min && s1_max >= 1) {
                    System.out.println(3);
                } else {
                    System.out.println(-1);
                }
                continue;
            }

            System.out.println(-1);
        }
        sc.close();
    }
}
