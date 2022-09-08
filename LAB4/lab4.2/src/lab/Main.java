package lab;

import datastr.DenseMatrix;
import datastr.DenseVector;
import datastr.SparseMatrix;
import datastr.SparseVector;

public class Main {
    public static void main(String[] args) {
        double[][] arr = {{9.0, 1.0, 4.0, 2.0, 7.0, 4.0, 8.0, 0.0, 2.0, 1.0},
                {5.0, 1.0, 4.0, 0.0, 9.0, 7.0, 3.0, 9.0, 6.0, 0.0},
                {7.0, 9.0, 6.0, 2.0, 6.0, 8.0, 6.0, 9.0, 7.0, 0.0},
                {7.0, 5.0, 7.0, 0.0, 5.0, 2.0, 4.0, 5.0, 8.0, 7.0},
                {9.0, 9.0, 0.0, 5.0, 4.0, 1.0, 0.0, 6.0, 7.0, 4.0}};

//        m1
        DenseMatrix m1 = new DenseMatrix(5, arr);
        System.out.println("matrix m1 =");
        System.out.print(m1);
        System.out.println("===========================");

//        m2
        SparseMatrix m2 = new SparseMatrix(10,2);
        m2.set(0,0,7.0);
        m2.set(4,0,2.0);
        m2.set(5,0,4.0);
        m2.set(5,1,1.0);
        m2.set(6,0,2.0);
        m2.set(7,1,3.0);
        System.out.println("matrix m2 =");
        System.out.print(m2);
        System.out.println("===========================");

//        m3
        SparseMatrix m3 = new SparseMatrix(5,10);
        m3.set(0,1,7.0);
        m3.set(0,5,3.0);
        m3.set(1,3,3.0);
        m3.set(1,4,7.0);
        m3.set(1,7,4.0);
        m3.set(2,0,7.0);
        m3.set(2,1,9.0);
        m3.set(2,3,1.0);
        m3.set(2,4,9.0);
        m3.set(2,6,9.0);
        m3.set(3,1,8.0);
        m3.set(3,4,7.0);
        System.out.println("matrix m3 =");
        System.out.print(m3);
        System.out.println("===========================");

//        m1 * m2
        System.out.println("m1*m2 ");
        System.out.print(m1.multiply(m2));
        System.out.println("===========================");

//        m1 + m3
        System.out.println("m1+m3 =");
        System.out.print(m1.add(m3));

    }
}