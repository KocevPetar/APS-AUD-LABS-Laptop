package Ednodimenzionalni_podatoci;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
    static class Student   {
        String name;
        int dokument;
        int indeks;
        int sredno;

        Student(String name, int dokument, int indeks, int sredno){
            this.name =name;
            this.dokument = dokument;
            this.indeks = indeks;
            this.sredno =sredno;
        }
    }
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Queue<Student> dokumentRedica = new LinkedQueue<Student>();
        Queue<Student> indeksRedica = new LinkedQueue<Student>();
        Queue<Student> srednoRedica = new LinkedQueue<Student>();

        for(int i = 0; i < n ;i++){
            String name = sc.nextLine();
            int dokument = sc.nextInt();
            int indeks = sc.nextInt();
            int sredno = sc.nextInt();
            sc.nextLine();

            Student s = new Student(name,dokument,indeks,sredno);
            if(s.dokument == 1){
                dokumentRedica.enqueue(s);
            }else if(s.indeks == 1){
                indeksRedica.enqueue(s);
            }else if (s.sredno == 1){
                srednoRedica.enqueue(s);
            }
            else{
                System.out.println(s.name);
            }
        }


        while(!dokumentRedica.isEmpty() || !indeksRedica.isEmpty() || !srednoRedica.isEmpty()){

            for(int i = 0; i < 1 && !dokumentRedica.isEmpty(); i++){
                Student s = dokumentRedica.dequeue();
                if(s.indeks == 1){
                    indeksRedica.enqueue(s);
                }else if (s.sredno == 1){
                    srednoRedica.enqueue(s);
                }else{
                    System.out.println(s.name);
                }
            }


            for(int i =0; i < 1 && !indeksRedica.isEmpty(); i++){
                Student s = indeksRedica.dequeue();
                if(s.sredno == 1){
                    srednoRedica.enqueue(s);
                }else{
                    System.out.println(s.name);
                }
            }


            for(int i = 0; i < 1 && !srednoRedica.isEmpty(); i++){
                Student s = srednoRedica.dequeue();
                System.out.println(s.name);
            }

        }

    }
}
