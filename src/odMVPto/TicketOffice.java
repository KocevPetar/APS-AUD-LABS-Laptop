package odMVPto;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class TicketOffice {
    public static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
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

    static void printQueue(LinkedQueue<String> q, StringBuilder sb) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            String x = q.dequeue();
            sb.append(" ").append(x);
            q.enqueue(x);
        }
    }
    public static void main (String[] args){
        Scanner sc =  new Scanner(System.in);
        int n  =sc.nextInt();
        LinkedQueue<String> vip = new LinkedQueue<String>();
        LinkedQueue<String> reg = new LinkedQueue<String>();

        for(int i = 0; i < n; i++){
            String cmd = sc.next();

            if(cmd.equals("arrive")){
                String id = sc.next();
                String type = sc.next();
                if(type.equals("VIP")){
                    vip.enqueue(id);
                }else{
                    reg.enqueue(id);
                }
            }else if (cmd.equals("status")){
                if(vip.isEmpty() && reg.isEmpty()){
                    System.out.println("Waiting: empty");
                }else{
                      StringBuilder sb = new StringBuilder("Waiting:");
                      printQueue(vip, sb);
                      printQueue(reg, sb);
                      System.out.println(sb);
                }
            }else if (cmd.equals("serve")){
                if(!vip.isEmpty()){
                    System.out.println("Serving: " + vip.dequeue());
                }else if (!reg.isEmpty()){
                    System.out.println("Serving: " + reg.dequeue());
                }else {
                    System.out.println("Serving: empty");
                }
            }
        }


    }

}
