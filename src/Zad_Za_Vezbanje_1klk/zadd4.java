//package Zad_Za_Vezbanje_1klk;
//
//public class zadd4 {
//}


import java.util.Scanner;


public class zadd4 {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        int n = a.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int max = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (a[j] > a[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}

