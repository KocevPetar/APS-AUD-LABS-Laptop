import java.util.Scanner;
public class labs1 {

    static class Node1{
        int value;
        String status;
        Node1 next;

        Node1(int value){
            this.value = value;
            this.status ="";
            this.next = null;
        }
    }

    static class Node2{
        int value;
        Node2 next;

        Node2(int value){
            this.value = value;
            this.next = null;
        }
    }

    static Node1 addLast1(Node1 head, int value){
        Node1 node = new Node1(value);

        if(head == null){
            return node;
        }

        Node1 p = head;

        while(p.next != null){
            p = p.next;
        }

        p.next = node;
        return head;
    }

    static Node2 addLast2(Node2 head, int value){
        Node2 node = new Node2(value);

        if(head == null){
            return node;
        }

        Node2 p = head;

        while(p.next != null){
            p = p.next;
        }

        p.next = node;
        return head;
    }


    static Node2 process(Node1 first, Node2 second, double x){
        Node1 p1 = first;
        Node2 p2 = second;
        Node2 prev2 = null;

        while(p1 != null){

            if(p2 == null){
                p1.status = "Unchecked";
                p1 = p1.next;
                continue;
            }

            Node2 next2 = p2.next;

            long difference = Math.abs((long) p1.value - p2.value);

            if(difference > x){
                p1.status = "Outlier";

                if(prev2 == null){
                    second = next2;
                }else{
                    prev2.next = next2;
                }
            }else{
                prev2 = p2;
            }
            p1 = p1.next;
            p2 = next2;
        }
        return second;
    }

    static void printFirst(Node1 head) {
        if (head == null) {
            System.out.println("Prazna lista!!!");
            return;
        }

        Node1 p = head;

        while (p != null) {

            if (p.status.equals("Outlier")) {
                System.out.print("Outlier " + p.value);
            } else if (p.status.equals("Unchecked")) {
                System.out.print("Unchecked " + p.value);
            } else {
                System.out.print(p.value);
            }

            if (p.next != null) {
                System.out.print("->");
            }

            p = p.next;
        }

        System.out.println();
    }

    static void printSecond(Node2 head) {
        if (head == null) {
            System.out.println("Prazna lista!!!");
            return;
        }

        Node2 p = head;

        while (p != null) {
            System.out.print(p.value);

            if (p.next != null) {
                System.out.print("->");
            }

            p = p.next;
        }

        System.out.println();
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Node1 first = null;

        for (int i = 0; i < N; i++) {
            first = addLast1(first, sc.nextInt());
        }

        int M = sc.nextInt();
        Node2 second = null;

        for (int i = 0; i < M; i++) {
            second = addLast2(second, sc.nextInt());
        }

        double x = sc.nextDouble();

        // Ги обработуваме листите и ја добиваме новата
        // почетна адреса на втората листа.
        second = process(first, second, x);

        // Печатење: прво првата, потоа втората листа.
        printFirst(first);
        printSecond(second);

        sc.close();
    }
}