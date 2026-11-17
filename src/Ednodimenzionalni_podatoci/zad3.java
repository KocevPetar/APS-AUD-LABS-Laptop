//package Ednodimenzionalni_podatoci;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class zad3  {
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

    public static class Student{
        String name;
        int n;
        int nf;
        int ist;

        Student(String name, int n, int nf, int ist) {
            this.name = name;
            this.n = n;
            this.nf = nf;
            this.ist = ist;

        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in, "UTF-8");
        int n = Integer.parseInt(sc.nextLine().trim());

        Queue<Student> NaukaRedica = new LinkedQueue<Student>();
        Queue<Student> NaucnaFantastikaRedica = new LinkedQueue<Student>();
        Queue<Student> IstorijaRedica = new LinkedQueue<Student>();

        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine().trim();
            int nauka = Integer.parseInt(sc.nextLine().trim());
            int naucnaF = Integer.parseInt(sc.nextLine().trim());
            int istorija = Integer.parseInt(sc.nextLine().trim());

            Student s = new Student(ime, nauka, naucnaF, istorija);

            if (s.n == 1) {
                NaukaRedica.enqueue(s);
            } else if (s.nf == 1) {
                NaucnaFantastikaRedica.enqueue(s);
            } else if (s.ist == 1) {
                IstorijaRedica.enqueue(s);
            } else {
                System.out.println(s.name);
            }
        }

        while (!NaukaRedica.isEmpty() || !NaucnaFantastikaRedica.isEmpty() || !IstorijaRedica.isEmpty()) {


            for (int i = 0; i < 2 && !NaukaRedica.isEmpty(); i++) {
                Student s = NaukaRedica.dequeue();
                if (s.nf == 1) {
                    NaucnaFantastikaRedica.enqueue(s);
                } else if (s.ist == 1) {
                    IstorijaRedica.enqueue(s);
                } else {
                    System.out.println(s.name);
                }
            }

            for (int i = 0; i < 1 && !NaucnaFantastikaRedica.isEmpty(); i++) {
                Student s = NaucnaFantastikaRedica.dequeue();
                if (s.ist == 1) {
                    IstorijaRedica.enqueue(s);
                } else {
                    System.out.println(s.name);
                }
            }

            for (int i = 0; i < 2 && !IstorijaRedica.isEmpty(); i++) {
                Student s = IstorijaRedica.dequeue();
                System.out.println(s.name);
            }
        }

        sc.close();
    }
}
