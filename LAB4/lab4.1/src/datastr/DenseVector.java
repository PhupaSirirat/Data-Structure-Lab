package datastr;

import java.util.ArrayList;
import java.util.Arrays;

public class DenseVector implements Vector{
    private int length;

    private Element[] elementsData;
    private static class Element {
        int index;
        double value;
        Element(int i, double v) {
            this.index = i;  this.value = v;
        }
    }

    public DenseVector(int length){
        this.length = length;
        this.elementsData = new Element[length];
    }
    public DenseVector(double[] list){
        this.length = list.length;
        this.elementsData = new Element[length];
        for (int i=0; i<list.length; i++){
            elementsData[i] = new Element(i,list[i]);
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public double magnitude() {
        double total=0;
        for (int i=0; i<length; i++){
            total += Math.pow(elementsData[i].value, 2);
        }
        return Math.sqrt(total);
    }

    @Override
    public double get(int index) {
        int i=0;
        for(; i<length; i++){
            if (elementsData[i].index >= index) break;
        }
        return elementsData[i].value;
    }

    @Override
    public void set(int index, double value) {
        int i = 0;
        try {
            for (; i < length; i++)
                if (elementsData[i].index >= index) break;
            if (i < length && elementsData[i].index == index)
                elementsData[i].value = value;
        }
        catch (Exception e){
            this.addElement(i, index, value);
        }
    }

    @Override
    public Vector add(Vector v) {
        if (length!=v.length()) throw new IllegalArgumentException();
        DenseVector vec = new DenseVector(length);
        for (int i=0; i<length; i++){
            vec.addElement(i, elementsData[i].index, elementsData[i].value+v.get(i));
        }
        return vec;
    }

    @Override
    public Vector substract(Vector v) {
        if (length!=v.length()) throw new IllegalArgumentException();
        DenseVector vec = new DenseVector(length);
        for (int i=0; i<length; i++){
            vec.addElement(i, elementsData[i].index, elementsData[i].value-v.get(i));
        }
        return vec;
    }

    @Override
    public double dot(Vector v) {
        if (length!=v.length()) throw new IllegalArgumentException();
        double total = 0;
        for (int i=0; i<length; i++)
            total += (this.get(i) * v.get(i));
        return total;
    }

    @Override
    public DenseVector multiply(double c) {
        DenseVector v = new DenseVector(this.length);
        for (int i=0; i<this.length; i++){
            v.addElement(i, elementsData[i].index, c * elementsData[i].value);
        }
        return v;
    }


//    Additional method
    @Override
    public String toString(){
        String allElement = " ";
        for (int i=0; i<this.length; i++){
            try {
                allElement += this.get(i)+" ";
            }
            catch(Exception e) {
                System.out.println("get null");
            }


        }
        return "[" + allElement + "]";
    }

    void addElement(int i, int index, double value) {
        elementsData[i] = new DenseVector.Element(index, value);
    }
}
