package odMVPto;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class DigitStack {
    public static interface Stack<E> {
        // Elementi na stekot se objekti od proizvolen tip.
        // Metodi za pristap:

        public boolean isEmpty();
        // Vrakja true ako i samo ako stekot e prazen.

        public E peek();
        // Go vrakja elementot na vrvot od stekot.

        // Metodi za transformacija:
        public void clear();
        // Go prazni stekot.

        public void push(E x);
        // Go dodava x na vrvot na stekot.

        public E pop();
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.

        public int size();
        // Ja vrakja dolzinata na stekot.
    }
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
    public static  class LinkedStack<E> implements Stack<E> {
        // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
        private SLLNode<E> top;
        int size;

        public LinkedStack() {
            // Konstrukcija na nov, prazen stek.
            top = null;
            size = 0;
        }

        public String toString() {
            SLLNode<E> current = top;
            StringBuilder s = new StringBuilder();
            while (current != null) {
                s.append(current.element);
                s.append(" ");
                current = current.succ;
            }
            return s.toString();
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (top == null);
        }

        public void clear() {
            // Go prazni stekot.
            top = null;
            size = 0;
        }

        public E peek() {
            // Go vrakja elementot na vrvot od stekot.
            if (top == null)
                throw new NoSuchElementException();
            return top.element;
        }

        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            top = new SLLNode<E>(x, top);
            size++;
        }

        public int size() {
            // Ja vrakja dolzinata na stekot.
            return size;
        }

        public E pop() {
            // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
            if (top == null)
                throw new NoSuchElementException();
            E topElem = top.element;
            size--;
            top = top.succ;
            return topElem;
        }

    }



    public static void main (String[] args){
        Scanner sc =  new Scanner(System.in);
        int  n = sc.nextInt();

        Stack<Integer> st = new LinkedStack<Integer>();
        Stack<Integer> tmp = new LinkedStack<Integer>();

        for(int i =0; i < n; i++){
            String cmd = sc.next();

            if(cmd.equals("ADD")){
                int d = sc.nextInt();
                st.push(d);
            }else if (cmd.equals("REMOVE")){
                int d = sc.nextInt();
                if(!st.isEmpty() && st.peek() == d){
                    st.pop();
                }else{
                    System.out.println("INVALID COMMAN");
                    return;
                }
            }else if (cmd.equals("PRINT")){
                if(st.isEmpty()){
                    System.out.println("EMPTY");
                }else{
                    StringBuilder reversed = new StringBuilder();
                    StringBuilder correct = new StringBuilder();

                    while(!st.isEmpty()){
                        int d = st.pop();
                        reversed.append(d);
                        tmp.push(d);
                    }


                    while(!tmp.isEmpty()){
                        int d = tmp.pop();
                        correct.append(d);
                        st.push(d);
                    }

                    System.out.println(correct);
                    System.out.println(reversed);
                }
            }
        }
    }
}
