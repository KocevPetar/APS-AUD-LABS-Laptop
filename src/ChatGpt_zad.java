// TODO: PRVA ZADACA TREBA SAMO DA SE ISPECATAT ELEMENTITE VO SLL

//public class ChatGpt_zad {
//    public static class SLLNode<E>{
//        protected E elemement;
//        protected SLLNode<E> succ;
//
//        public SLLNode(E element, SLLNode<E> succ){
//            this.succ = succ;
//            this.elemement = element;
//        }
//    }
//
//    public static class SLL<E>{
//        private SLLNode<E> first;
//
//        public SLL(){
//            this.first = null;
//        }
//
//        public void printList(){
//            SLLNode<E> tmp = first;
//            while(tmp != null){
//                if(tmp.succ != null){
//                    System.out.print(tmp.elemement + " -> ");
//                }else{
//                    System.out.print(tmp.elemement);
//                }
//                tmp = tmp.succ;
//            }
//        }
//
//
//        public void insertFirst(E o){
//            SLLNode<E> ins = new SLLNode<E>(o,null);
//            ins.succ = first;
//            first = ins;
//        }
//
//
//        public void insertLast(E o){
//            if(first != null){
//                SLLNode<E> tmp = first;
//                while(tmp.succ!=null){
//                    tmp = tmp.succ;
//                }
//                tmp.succ = new SLLNode(o,null);
//            }else{
//                insertFirst(o);
//            }
//        }
//
//
//    }
//
//    public static void main (String[] args){
//            SLL<Integer> lista = new SLL<Integer>();
//            lista.insertLast(10);
//            lista.insertLast(20);
//            lista.insertLast(30);
//            lista.insertFirst(5);
//                lista.insertFirst(15);
//            lista.printList();
//
//    }
//}


//public class ChatGpt_zad{
//    public static class SLLNode<E>{
//        protected E element;
//        protected SLLNode<E> succ;
//
//        public SLLNode(E element, SLLNode<E> succ){
//            this.element = element;
//            this.succ = succ;
//        }
//    }
//
//
//    public static class SLL<E>{
//        private SLLNode<E> first;
//
//        public SLL(){
//            this.first = null;
//        }
//
//        public void insertFirst(E o){
//            SLLNode<E> ins = new SLLNode<E>(o,null);
//            ins.succ = first;
//            first = ins;
//        }
//
//
//
//        public int countEven(SLL<Integer> lista){
//            SLLNode<Integer> tmp = lista.first;
//            int result = 0;
//            while(tmp != null){
//                if(tmp.element % 2 ==0){
//                    result++;
//                }
//                tmp = tmp.succ;
//            }
//            return result;
//        }
//
//                public void printList(){
//            SLLNode<E> tmp = first;
//            while(tmp != null){
//                if(tmp.succ != null){
//                    System.out.print(tmp.element + " -> ");
//                }else{
//                    System.out.print(tmp.element);
//                }
//                tmp = tmp.succ;
//            }
//        }
//
//        public SLLNode<E> contains(E  x){
//            if(first!= null) {
//                SLLNode<E> tmp = first;
//                while(!tmp.element.equals(x) && tmp.succ != null){
//                    tmp = tmp.succ;
//                }
//
//                if(tmp.element.equals(x)){
//                    return tmp;
//                }
//            }
//            return null;
//        }
//
//        public void insertBefore(E o,SLLNode<E> before){
//            if(first != null){
//                SLLNode<E> tmp = first;
//                if(first == before){
//                    this.insertFirst(o);
//                    return;
//                }
//
//                while(tmp.succ != before && tmp.succ != null){
//                    tmp = tmp.succ;
//                }
//
//                if(tmp.succ == before){
//                    tmp.succ = new SLLNode<E>(o,before);
//                }else{
//                    System.out.println("Elementot ne postoi vo nizata");
//                }
//
//            }else{
//                System.out.println("Listata e prazna");
//            }
//        }
//
//    }
//     public static void main(String[] args){
//
//        SLL<Integer> niza = new SLL<Integer>();
//        niza.insertFirst(10);
//        niza.insertFirst(14);
//        niza.insertFirst(12);
//        niza.insertFirst(16);
//        niza.insertBefore(43, niza.contains(14));
//         niza.printList();
//
//
//
//



////        boolean validno = niza.contains(9);
////        System.out.println("\n" + validno);
////        int result = niza.countEven(niza);
////        System.out.println("\n"+ result);
//
//    }
//}




import java.util.Scanner;
public class ChatGpt_zad{
    public class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }

    public class SLL<E> {
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


    public  void main (String[] args){

        Scanner input = new Scanner(System.in);
        SLL<Integer> lista = new SLL<Integer>();

        int m = input.nextInt();
        for(int i = 0; i < m;i++){
            lista.insertLast(input.nextInt());
        }
        System.out.println("Prvicno zadadenata lista");
        System.out.println(lista.toString());

        int x = 100;

        lista.insertFirst(x);
        lista.insertLast(x);
        System.out.println("Posle dodavanje na pocetokot i krajot na listata");
        System.out.println(lista.toString());

        SLLNode<Integer>temp = lista.getFirst();
        for(int i = 0; i < m ;i++){
            if(temp.element == 5){
                lista.insertBefore(x,temp);
                break;
            }
            temp = temp.succ;
        }

        System.out.println("Dodavanje na X pred prvoto pojavuvanj na 5 ");
        System.out.println(lista.toString());

        SLLNode<Integer> lastFive = null;

        while(temp!=null){
            if(temp.element == 5){
                lastFive = temp;
            }
            temp = temp.succ;
        }

        if(lastFive != null){
            lista.insertAfter(x,lastFive);
        }
        System.out.println("Dodavanje na X posle poslednoto pojavuvanje na 5 ");
        System.out.println(lista.toString());

    }
}