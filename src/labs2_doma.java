import javax.sound.sampled.Line;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class labs2_doma {

    public static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }



    public static class SLL<E> {
        private SLLNode<E> first;

        public SLL() {
            // Construct an empty SLL
            this.first = null;
        }

        public void deleteList() {
            first = null;
        }

        public int size() {
            int listSize = 0;
            SLLNode<E> tmp = first;
            while(tmp != null) {
                listSize++;
                tmp = tmp.succ;
            }
            return listSize;
        }

        @Override
        public String toString() {
            String ret = new String();
            if (first != null) {
                SLLNode<E> tmp = first;
                ret += tmp.element;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += "->" + tmp.element;
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }

        public void insertFirst(E o) {
            SLLNode<E> ins = new SLLNode<E>(o, null);
            ins.succ = first;
            //SLLNode<E> ins = new SLLNode<E>(o, first);
            first = ins;
        }

        public void insertAfter(E o, SLLNode<E> node) {
            if (node != null) {
                SLLNode<E> ins = new SLLNode<E>(o, node.succ);
                node.succ = ins;
            } else {
                System.out.println("Dadenot jazol e null");
            }
        }
        public void insertBefore(E o, SLLNode<E> before) {

            if (first != null) {
                SLLNode<E> tmp = first;
                if(first==before){
                    this.insertFirst(o);
                    return;
                }
                //ako first!=before
                while (tmp.succ != before && tmp.succ!=null)
                    tmp = tmp.succ;
                if (tmp.succ == before) {
                    tmp.succ = new SLLNode<E>(o, before);;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
        }

        public void insertLast(E o) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (tmp.succ != null)
                    tmp = tmp.succ;
                tmp.succ = new SLLNode<E>(o, null);
            } else {
                insertFirst(o);
            }
        }

        public E deleteFirst() {
            if (first != null) {
                SLLNode<E> tmp = first;
                first = first.succ;
                return tmp.element;
            } else {
                System.out.println("Listata e prazna");
                return null;
            }
        }

        public E delete(SLLNode<E> node) {
            if (first != null) {
                SLLNode<E> tmp = first;
                if(first == node) {
                    return this.deleteFirst();
                }
                while (tmp.succ != node && tmp.succ.succ != null)
                    tmp = tmp.succ;
                if (tmp.succ == node) {
                    tmp.succ = tmp.succ.succ;
                    return node.element;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                    return null;
                }
            } else {
                System.out.println("Listata e prazna");
                return null;
            }

        }

        public SLLNode<E> getFirst() {
            return first;
        }

        public SLLNode<E> find(E o) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (!tmp.element.equals(o) && tmp.succ != null)
                    tmp = tmp.succ;
                if (tmp.element.equals(o)) {
                    return tmp;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
            return null;
        }

        public void merge (SLL<E> in){
            if (first != null) {
                SLLNode<E> tmp = first;
                while(tmp.succ != null)
                    tmp = tmp.succ;
                tmp.succ = in.getFirst();
            }
            else{
                first = in.getFirst();
            }
        }

        public void mirror() {
            if (first != null) {
                //m=nextsucc, p=tmp,q=next
                SLLNode<E> tmp = first;
                SLLNode<E> newsucc = null;
                SLLNode<E> next;

                while(tmp != null){
                    next = tmp.succ;
                    tmp.succ = newsucc;
                    newsucc = tmp;
                    tmp = next;
                }
                first = newsucc;
            }
        }
    }





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

    }

    public static  class Process {
        String name;
        int time;

        public Process(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        LinkedQueue<String> names = new LinkedQueue<>();
        LinkedQueue<Integer> times = new LinkedQueue<>();

        for(int i =0; i < N;i++){
            String name = sc.next();
            int time = sc.nextInt();

            names.enqueue(name);
            times.enqueue(time);


        }


        int counter =1;

        while(!names.isEmpty()){
            String name = names.dequeue();
            int time = times.dequeue();

            if (time <= T) {
                System.out.println(counter +". "  + name);
                counter++;
            }else{
                time -= T;

                names.enqueue(name);
                times.enqueue(time);
            }

        }

        sc.close();

    }
}