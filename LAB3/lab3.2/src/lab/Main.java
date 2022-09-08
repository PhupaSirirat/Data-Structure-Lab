package lab;

import datastr.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList slist = new SinglyLinkedList();
        for (int i=0; i<100; i++){
            slist.add(i);
        }
        System.out.println("Initial list");
        slist.printAll();

//        System.out.println("\nSwap test");
//        slist.swap(0,9);
//        slist.printAll();

        System.out.println("\nReverse");
        slist.reverse();
        slist.printAll();

        int j = (int)Math.floor(Math.random()*(99));
        int i = (int)Math.floor(Math.random()*j);
        System.out.println("\nRemove "+i+" "+j);
        slist.removeRange(i, j);
        slist.printAll();
    }
}