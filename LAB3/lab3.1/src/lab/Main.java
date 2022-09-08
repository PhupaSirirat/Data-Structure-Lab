package lab;

import datastr.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList arr = new ArrayList(100);
        for (int i=0; i<100; i++){
            arr.add(i);
        }

        System.out.println("Initial list");
        arr.toArray();
        arr.printAll();

//        System.out.println("\nswap test");
//        arr.swap(0,99);
//        arr.printAll();

        System.out.println("\nReverse");
        arr.reverse();
        arr.printAll();


        int j = (int)Math.floor(Math.random()*99);
        int i = (int)Math.floor(Math.random()*(j));
        System.out.println("\nRemove "+i+" "+j);
        arr.removeRange(i,j);
        arr.printAll();

    }
}