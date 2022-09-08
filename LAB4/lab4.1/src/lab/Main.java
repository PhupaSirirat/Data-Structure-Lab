package lab;

import datastr.DenseVector;
import datastr.SparseVector;

public class Main {
    public static void main(String[] args) {
        double[] arr = {5.0,2.0,9.0,4.0,4.0,1.0,5.0,4.0,1.0,0.0};

//        v1
        DenseVector v1 = new DenseVector(arr);
        System.out.println("v1\t\t= "+ v1);

//        0.5 * v1
        System.out.println("0.5*v1\t= "+ v1.multiply(0.5));

//        v2
        SparseVector v2 = new SparseVector(10);
        v2.set(0, 1.0);
        v2.set(4, 9.0);
        v2.set(5, 6.0);
        v2.set(6, 5.0);
        v2.set(9, 9.0);
        System.out.println("v2\t\t= "+ v2);

//        0.5 * v2
        System.out.println("0.5*v2\t= "+ v2.multiply(0.5));

//        v2+v1 or v1+v2 (same output)
        System.out.println("v2+v1\t= "+ v2.add(v1));

//        v1-v2
        System.out.println("v1-v2\t= "+ v1.substract(v2));

//        v1.v2
        System.out.println("v1.v2\t= "+ v1.dot(v2));

//        v2.v1
        System.out.println("v2.v1\t= "+ v2.dot(v1));
    }
}