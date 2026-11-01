public class aud1_SLL {

    public static class SLLNode<E>{
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ){
            this.element = elem;
            this.succ = succ;
        }
    }

    public static class SLL<E>{
        private SLLNode<E> first;

        public SLL(){
            this.first = null;
        }

        public void insertFirst(E o){
            SLLNode<E> ins = new SLLNode<E>(o,null);
            ins.succ = first;
            first = ins;
        }


        public void insertAfter(E o, SLLNode<E> node){
            if(node != null){
                SLLNode<E> ins = new SLLNode<E>(o,node.succ);
                node.succ = ins;
            }else{
                System.out.println("Dadeniot jazel e null");
            }
        }

        public void insertBefore(E o, SLLNode<E> before){
            if(first != null){
                SLLNode<E> tmp = first;
                if(first == before){
                    this.insertFirst(o);
                    return;
                }

                while(tmp.succ != before && tmp.succ != null ){
                    tmp = tmp.succ;
                }

                if(tmp.succ == before){
                    tmp.succ = new SLLNode<E>(o,before);
                }else{
                    System.out.println("Elementot ne postoi vo nizata");
                }
            }else{
                System.out.println("Listata e prazna");
            }
        }

        public void insertLast(E o){
            if (first != null){
                SLLNode<E> tmp = first;
                while(tmp.succ != null){
                    tmp = tmp.succ;
                }
                tmp.succ = new SLLNode<E>(o,null);
            }else{
                insertFirst(o);
            }
        }


        public E deleteFirst(){
            if(first != null){
                SLLNode<E> tmp = first;
                first = first.succ;
                return tmp.element;
            }else{
                System.out.println("Listata e prazna");
                return null;
            }
        }


        public E delete(SLLNode<E> node){
            if(first != null){
                SLLNode<E> tmp = first;
                if(first == node){
                    return this.deleteFirst();
                }

                while(tmp.succ != node && tmp.succ.succ !=null) {
                    tmp = tmp.succ;
                }
                if(tmp.succ == node){
                    tmp.succ = tmp.succ.succ;
                    return node.element;
                }else{
                    System.out.println("Elementot ne postoi vo listata");
                    return null;
                }
            }else{
                System.out.println("Listata e praznza");
                return null;
            }
        }

        public int size(){
            int listSize = 0;
            SLLNode<E> tmp = first;
            while(tmp != null){
                listSize++;
                tmp = tmp.succ;
            }
            return listSize;
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



//        public void merge(SLL<E> in) {
//            if (first != null) {
//                SLLNode<E> tmp = first;
//                while (tmp.succ != null)
//                    tmp = tmp.succ;
//                tmp.succ = in.getFirst();
//            } else {
//                first = in.getFirst();
//            }
//        }

        @Override public String toString() {
            StringBuilder sb = new StringBuilder();
            SLLNode<E> tmp = first;

            while (tmp != null) {
                sb.append(tmp.element);

                if (tmp.succ != null) {
                    sb.append(" -> ");
                }

                tmp = tmp.succ;
            }

            return sb.toString();
        }

    }









    public static void main (String[] args){
        SLL<Integer>lista = new SLL<Integer>();
        lista.insertLast(5);
        System.out.println("Listata po vmetnuvanje na 5 kako posleden element: ");
        System.out.println(lista.toString());

        lista.insertFirst(3);
        System.out.println("Listata po vmetnuvanje na 3 kako prv element: ");
        System.out.println(lista.toString());

        lista.insertLast(1);
        System.out.println("Listata po vmetnuvanje na 1 kako posleden element: ");
        System.out.println(lista.toString());

        lista.deleteFirst();
        System.out.println("Listata po brisenje na prviot element: ");
        System.out.println(lista.toString());

        SLLNode<Integer> pom = lista.find(5);
        lista.insertBefore(2,pom);
        System.out.println("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
        System.out.println(lista.toString());

        pom = lista.find(1);
        lista.insertAfter(3,pom);
        System.out.println("Listata po vmenuvanje na elementot 3 pred elementot 1: ");
        System.out.println(lista.toString());

        System.out.println("Momentalna dolzina na listata: " + lista.size());

        pom = lista.find(2);
        lista.delete(pom);
        System.out.println("Listata po brisenje na elementot 2: ");
        System.out.println(lista.toString());

        System.out.println("Momentalna dolzina na listata: " + lista.size());


    }
}