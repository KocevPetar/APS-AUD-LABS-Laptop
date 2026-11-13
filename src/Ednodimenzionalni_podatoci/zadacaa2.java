//package Ednodimenzionalni_podatoci;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class zadacaa2 {
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
    public static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }

    static class Student {
        public String ime;
        public int nauka;
        public int fantastika;
        public int istorija;


        Student(String ime, int nauka, int fantastika, int istorija) {
            this.ime = ime;
            this.nauka = nauka;
            this.fantastika = fantastika;
            this.istorija = istorija;
        }
    }


            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                LinkedQueue<Student> listNauka = new LinkedQueue<Student>();
                LinkedQueue<Student> listFantastika = new LinkedQueue<Student>();
                LinkedQueue<Student> listIstorija = new LinkedQueue<Student>();
                input.nextLine();

                for (int i = 0; i < n; i++) {
                    String name = input.nextLine();
                    int na = input.nextInt();
                    int f = input.nextInt();
                    int is = input.nextInt();
                    input.nextLine(); //
                    Student s = new Student(name, na, f, is);
                    if (s.nauka == 1) {
                        listNauka.enqueue(s);
                    } else if (s.fantastika == 1) {
                        listFantastika.enqueue(s);
                    } else if (s.istorija == 1) {
                        listIstorija.enqueue(s);
                    } else {
                        System.out.println(name);
                    }
                }


                while (!listNauka.isEmpty()) {
                    Student s = listNauka.dequeue();
                    if (s.fantastika == 0 && s.istorija == 0) {
                        System.out.println(s.ime);
                    } else if (s.fantastika == 1) {
                        listFantastika.enqueue(s);
                    } else {
                        listIstorija.enqueue(s);
                    }

                }

                while (!listFantastika.isEmpty()) {
                    Student s = listFantastika.dequeue();
                    if (s.istorija == 0) {
                        System.out.println(s.ime);
                    } else {
                        listIstorija.enqueue(s);
                    }
                }

                while (!listIstorija.isEmpty()) {
                    Student s = listIstorija.dequeue();
                    System.out.println(s.ime);
                }
            }
    }

