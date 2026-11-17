package tehniki_za_kreiranje_na_algoritmi;
import java.util.Scanner;
public class zad1 {
    public static void main (String[] args){
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        int[] niza = new int[n];

        for(int i = 0; i < n; i++){
            niza[i] = sc.nextInt();
        }

        for(int i = 0; i < n-1; i++){

            for(int j = 0; j < n-i-1; j++){
                if(niza[j]  < niza[j+1]){
                    int tmp = niza[j];
                    niza[j] = niza[j+1];
                    niza[j+1] = tmp;

                }
            }


        }

        for(int i = 0; i < n; i++){
            System.out.print(niza[i]);
        }

    }
}
