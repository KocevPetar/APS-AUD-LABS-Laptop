//package tehniki_za_kreiranje_na_algoritmi;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class zad4 {
    public static interface Queue<E> {
        // Elementi na redicata se objekti od proizvolen tip.
        // Metodi za pristap:
        public boolean isEmpty();
        // Vrakja true ako i samo ako redicata e prazena.

        public int size();
        // Ja vrakja dolzinata na redicata.

        public E peek();
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

        // Metodi za transformacija:

        public void clear();
        // Ja prazni redicata.

        public void enqueue(E x);
        // Go dodava x na kraj od redicata.

        public E dequeue();
        // Go otstranuva i vrakja pochetniot element na redicata.
    }
    public static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }




    public static class LinkedQueue<E> implements Queue<E> {

        // Redicata e pretstavena na sledniot nacin:
        // length go sodrzi brojot na elementi.
        // Elementite se zachuvuvaat vo jazli dod SLL
        // front i rear se linkovi do prviot i posledniot jazel soodvetno.
        SLLNode<E> front, rear;
        int length;

        // Konstruktor ...

        public LinkedQueue () {
            clear();
        }

        public boolean isEmpty () {
            // Vrakja true ako i samo ako redicata e prazena.
            return (length == 0);
        }

        public int size () {
            // Ja vrakja dolzinata na redicata.
            return length;
        }

        public E peek () {
            // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
            if (front == null)
                throw new NoSuchElementException();
            return front.element;
        }

        public void clear () {
            // Ja prazni redicata.
            front = rear = null;
            length = 0;
        }

        public void enqueue (E x) {
            // Go dodava x na kraj od redicata.
            SLLNode<E> latest = new SLLNode<E>(x, null);
            if (rear != null) {
                rear.succ = latest;
                rear = latest;
            } else
                front = rear = latest;
            length++;
        }

        public E dequeue () {
            // Go otstranuva i vrakja pochetniot element na redicata.
            if (front != null) {
                E frontmost = front.element;
                front = front.succ;
                if (front == null)  rear = null;
                length--;
                return frontmost;
            } else
                throw new NoSuchElementException();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            SLLNode<E> current = front;
            while (current != null) {
                sb.append(current.element);
                if (current.succ != null) {
                    sb.append(", ");
                }
                current = current.succ;
            }
            sb.append("]");
            return sb.toString();
        }

    }

    static class Sostanok {
        int pocetok;
        int kraj;

        Sostanok(int pocetok, int kraj) {
            this.pocetok = pocetok;
            this.kraj = kraj;
        }
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        Sostanok[] s = new Sostanok[n];
//        for (int i = 0; i < n; i++) {
//            int p = sc.nextInt();
//            int k = sc.nextInt();
//            s[i] = new Sostanok(p, k);
//        }
//
//        Sostanok[] poPocetok = s.clone();
//        Arrays.sort(poPocetok, Comparator.comparingInt(x -> x.pocetok));
//
//        Sostanok[] poKraj = s.clone();
//        Arrays.sort(poKraj, Comparator.comparingInt(x -> x.kraj));
//
//        Queue<Integer> pocetoci = new LinkedQueue<>();
//        Queue<Integer> kraevi = new LinkedQueue<>();
//        for (int i = 0; i < n; i++) {
//            pocetoci.enqueue(poPocetok[i].pocetok);
//            kraevi.enqueue(poKraj[i].kraj);
//        }
//
//        int current = 0, max = 0;
//
//        while (!pocetoci.isEmpty()) {
//            if (pocetoci.peek() < kraevi.peek()) {
//                pocetoci.dequeue();
//                current++;
//                if (current > max) max = current;
//            } else {
//                kraevi.dequeue();
//                current--;
//            }
//        }
//
//        System.out.println(max);



        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pocetok = new int[n];
        int[] kraj = new int[n];

        for(int i =0; i < n; i++){
            pocetok[i] =sc.nextInt();
            kraj[i] = sc.nextInt();
        }

        Arrays.sort(pocetok);
        Arrays.sort(kraj);

        Queue<Integer> pocetokRed =  new LinkedQueue<Integer>();
        Queue<Integer> krajRed = new LinkedQueue<Integer>();

        for(int i =0; i < n; i++){
            pocetokRed.enqueue(pocetok[i]);
            krajRed.enqueue(kraj[i]);
        }

        int current = 0;
        int max = 0;

        while(!pocetokRed.isEmpty()){
            if(pocetokRed.peek() <= krajRed.peek()){
                pocetokRed.dequeue();
                current++;

                if(current > max){
                    max = current;
                }
            }else{
                krajRed.dequeue();
                current--;
            }
        }
        System.out.println(max);
    }
}