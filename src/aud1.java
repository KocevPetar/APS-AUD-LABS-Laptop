import java.util.ArrayList;

public class aud1 {
    public static class Array <E>{
        private E data[];
        private int size;

        public  Array(int capacity){
            this.data = (E[]) new Object [capacity];
            this.size = 0;
        }
        public void insertLast(E o){
            if(size + 1 > data.length) {
                this.resize();
            }
            data[size++] = o;
        }

        public void insert(int position, E o){
            if(position >= 0 && position <= size ){

                if(size + 1 > data.length) {
                    this.resize();
                }

                for(int i = size; i > position; i--){
                    data[i] = data[i-1];
                }
                data[position] = o;
                size++;
            }else{
                System.out.println("Ne moze da se vmetne element vo taa pozicija");
            }
        }


        public void set (int position, E o){
            if (position >= 0 && position <size){
                data[position] = o;
            }else{
                System.out.println("Ne e validna dadenata pozicija");
            }
        }

        public E get (int position){
            if(position >= 0 && position <size){
                return data[position];
            }else{
                System.out.println("Ne e validna dadenata pozicija");
                return null;
            }

        }


        public int find(E o){
            for(int i = 0; i < size; i++){
                if(o.equals(data[i])){
                    return i;
                }
            }
            return -1;
        }


        public int getSize(){
            return size;
        }

        public void delete(int position){
            if(position >= 0 && position <=size){
                E[] newData = (E[]) new Object [size - 1];

                for(int i = 0; i < position;i++){
                    newData[i] = data[i];
                }

                for(int i = position + 1; i < size; i++){
                    newData[i-1] = data[i];
                }
                data = newData;
                size--;
            }
        }

        public void resize(){
            E[] newData = (E[]) new Object[size*2];
            for(int i = 0; i < size;i++){
                newData[i] = data[i];
            }
            this.data = newData;
        }

        @Override
        public String toString() {
            String result = "";

            for (int i = 0; i < size; i++) {
                result += data[i];

                if (i < size - 1) {
                    result += " ";
                }
            }

            return result;
        }

    }

    //TODO:KLASATA ZA PRVATA ZADACA OD AUD
    public static class ChangeArrays<E>{
        public void compareAndChangeArray(Array<E> niza1, Array<E> niza2){
            if(niza1.getSize() != niza2.getSize()){
                System.out.println("Nizite ne se so ista golemina");
                return;
            }

            int golemina = niza1.getSize();
            int i = 0;

            while(i < golemina){
                if(niza1.get(i).equals(niza2.get(i))){
                    niza1.delete(i);
                    niza2.delete(i);
                    golemina--;
                }else{
                    i++;
                }
            }
        }


        public void compareAndChangeArrays(ArrayList<E>niza1, ArrayList<E>niza2){
            if(niza1.size() != niza2.size()){
                System.out.println("Nizite ne se so ista golemina");
                return;
            }
            int size = niza1.size();
            int i = 0;

            while(i < size){
                if(niza1.get(i).equals(niza2.get(i))){
                    niza1.remove(i);
                    niza2.remove(i);
                    size--;
                }else{
                    i++;
                }
            }
        }
    }









    public static void main(String[] args){
        //TODO: ova tuka e za funkciite koi se vrsat na nizi vo JAVA

//        Array<Integer> niza = new Array<Integer>(4);
//        niza.insertLast(4);
//        System.out.println("Nizata po vmetnuvanje na 4 kako posleden element: ");
//        System.out.println(niza.toString());
//
//        niza.insertLast(7);
//        niza.insertLast(13);
//        System.out.println("Nizata po dodavanje na 7 i 13 kako elementi: ");
//        System.out.println(niza.toString());
//
//
//        niza.insert(1,3);
//        System.out.println("Nizata po dodavanje na 3 kako element na pozicija 1: ");
//        System.out.println(niza.toString());



        //TODO: tuka e main delot od prvata zadaca
//        Array<String> niza1 = new Array<String>(4);
//        niza1.insertLast("nb11");
//        niza1.insertLast("b1");
//        niza1.insertLast("b2");
//        niza1.insertLast("nb12");
//
//        Array<String> niza2 = new Array<String>(4);
//        niza2.insertLast("nb21");
//        niza2.insertLast("b1");
//        niza2.insertLast("b2");
//        niza2.insertLast("nb22");
//
//        System.out.println("Nizite pred primenuvanje na funkcijata: ");
//        System.out.println(niza1.toString());
//        System.out.println(niza2.toString());
//
//        ChangeArrays<String> pom = new ChangeArrays<String>();
//        pom.compareAndChangeArray(niza1, niza2);
//
//        System.out.println("Nizite po primenuvanje na funkcijata: ");
//        System.out.println(niza1.toString());
//        System.out.println(niza2.toString());


        //TODO:isto taka main del od prvata zadaca samo resena so Array List
//        ArrayList<Integer> niza3 = new ArrayList<Integer>(3);
//        niza3.add(10);
//        niza3.add(13);
//        niza3.add(7);
//
//        ArrayList<Integer> niza4 = new ArrayList<Integer>(3);
//        niza4.add(5);
//        niza4.add(13);
//        niza4.add(3);
//
//        System.out.println("Nizite pred primenuvanje na funkcijata: ");
//        System.out.println(niza3.toString());
//        System.out.println(niza3.toString());
//
//        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
//        pom2.compareAndChangeArrays(niza3,niza4);
//
//        System.out.println("Nizite otkako se upotrebeni funkciite: ");
//        System.out.println(niza3.toString());
//        System.out.println(niza3.toString());

    }
}