package CODEFORCE.Contest;

import java.util.Scanner;

public class RabbitsAndFlower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next().trim();

            if (s.contains("0000")) { // four consecutive zeros → impossible
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        sc.close();
    }
}
