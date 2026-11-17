package tehniki_za_kreiranje_na_algoritmi;
import java.util.Scanner;
import java.util.Arrays;

public class Zad3 {
     static class Zadacha{
        int vreme;
        int zarabotka;

        Zadacha(int vreme, int zarabotka){
            this.vreme = vreme;
            this.zarabotka = zarabotka;
        }

        double odnos(){
            return (double) zarabotka / vreme;
        }
    }
    public static void main (String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Zadacha[] zad = new Zadacha[n];
//
//        for(int i = 0; i < n;i++){
//            int vreme = sc.nextInt();
//            int zarabotka = sc.nextInt();
//
//            zad[i] = new Zadacha(vreme,zarabotka);
//        }
//
//        Arrays.sort(zad, (a, b) -> Double.compare(b.odnos(), a.odnos()));
//
//        double ostanato = 40;
//        double vkupno = 0;
//
//        for(int i = 0; i < n && ostanato > 0; i++){
//            if(zad[i].vreme <= ostanato){
//                vkupno += zad[i].zarabotka;
//                ostanato -= zad[i].vreme;
//            }else{
//                vkupno += zad[i].zarabotka * (ostanato / zad[i].vreme);
//                ostanato = 0;
//            }
//        }
//
//
//        System.out.println(vkupno);




        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Zadacha[] zad = new Zadacha[n];
        for(int i = 0; i < n; i++){
            int vreme = sc.nextInt();
            int zarabotka = sc.nextInt();

            zad[i] = new Zadacha(vreme,zarabotka);
        }


        Arrays.sort(zad,(a,b) -> Double.compare(b.odnos(), a.odnos()));

        double ostanato = 40;
        double vkupno = 0;

        for(int i = 0; i < n && ostanato > 0; i++){
            if(zad[i].vreme <= ostanato){
                vkupno +=zad[i].zarabotka;
                ostanato -= zad[i].vreme;
            }else{
                vkupno += zad[i].zarabotka * (ostanato / zad[i].vreme);
                 ostanato = 0;
            }
        }

        System.out.println(vkupno);
    }
}
