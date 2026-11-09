package zadaci_Vezbanje_Nizi_Listi;
import java.util.Scanner;

public class zad9 {
    public static class DLLNode<E> {
        protected E element;
        protected DLLNode<E> pred, succ;
        public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
            this.element = elem;
            this.pred = pred;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    public static class DLL<E> {
        private DLLNode<E> first, last;

        public DLL() {
            this.first = null;
            this.last = null;
        }

        public void insertFirst(E o) {
            DLLNode<E> ins = new DLLNode<E>(o, null, first);
            if (first == null)
                last = ins;
            else
                first.pred = ins;
            first = ins;
        }

        public void insertLast(E o) {
            if (first == null)
                insertFirst(o);
            else {
                DLLNode<E> ins = new DLLNode<E>(o, last, null);
                last.succ = ins;
                last = ins;
            }
        }

        public DLLNode<E> getFirst() {
            return first;
        }

        public DLLNode<E> getLast() {
            return last;
        }

        @Override
        public String toString() {
            String ret = new String();
            if (first != null) {
                DLLNode<E> tmp = first;
                ret += tmp.toString();
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += "<->" + tmp.toString();
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        DLL<Integer> list = new DLL<>();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            list.insertLast(sc.nextInt());
        }

        int M = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(list);

        DLLNode<Integer> node = list.getFirst();

        while (node != null && !node.element.equals(M)) {
            node = node.succ;
        }

        if (node != null && N > 0) {
            k = k % N;

            if (k > 0) {
                DLLNode<Integer> target = node;

                // Наоѓаме каде треба да се премести (k места налево со кружно движење)
                for (int i = 0; i < k; i++) {
                    if (target.pred == null) {
                        target = list.getLast();
                    } else {
                        target = target.pred;
                    }
                }

                if (target != node) {
                    // 1. Го отстрануваме јазолот од неговата стара позиција
                    if (node.pred != null) {
                        node.pred.succ = node.succ;
                    } else {
                        list.first = node.succ;
                    }

                    if (node.succ != null) {
                        node.succ.pred = node.pred;
                    } else {
                        list.last = node.pred;
                    }

                    // 2. Го вметнуваме ПОСЛЕ target (insertAfter)
                    node.pred = target;
                    node.succ = target.succ;

                    if (target.succ != null) {
                        target.succ.pred = node;
                    } else {
                        list.last = node;
                    }
                    target.succ = node;
                }
            }
        } else {
            System.out.println("Elementot ne postoi vo listata");
        }

        System.out.println(list);
    }
}