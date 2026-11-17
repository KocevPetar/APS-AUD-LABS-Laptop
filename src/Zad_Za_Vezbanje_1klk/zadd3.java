package Zad_Za_Vezbanje_1klk;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class zadd3 {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//Stari
        int M = Integer.parseInt(br.readLine());//Deca
        long min = Math.max(N, M) * 100L;

        long max;

        if (M == 0) {
            max = N * 100L;
        } else {
            max = (N + M - 1) * 100L;
        }

        System.out.println(min);
        System.out.println(max);

        br.close();

        // Vasiot kod tuka



    }

}
