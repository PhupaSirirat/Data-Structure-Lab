package datastr;

import java.util.Random;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
public class SinglyLinkedList implements List {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }
    private LinkedNode header;
    private int size;

    public SinglyLinkedList() {
        header = new LinkedNode(null, null);
        size = 0;
    }
    public boolean isEmpty() {
        return header.next == null;
    }
    public int size() {
        return size;
    }
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void add(int i, Object e) {
        LinkedNode p = nodeAt(i-1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }
    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }
    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e))
            p = p.next;
        removeAfter(p);
    }
    public void remove(int i) {
        LinkedNode p = nodeAt(i-1);
        removeAfter(p);
    }
    public Object get(int i) {
        return nodeAt(i).element;
    }
    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        for (int i = 0; i < size; i++) {
            arr[i] = p.element;
            p = p.next;
        }
        return arr;
    }

//    Lab3.2
    public int indexOf(Object e){
        LinkedNode p = header.next;
        int i = 0;
        while (p.next != null && !p.next.element.equals(e)){
            p = p.next;
            i++;
        } return i;
    }

    public void swap(int i, int j){

        if (i==j) System.out.println("Same index");

        LinkedNode prevI = null, currI = header.next;
        while (currI != null && !currI.element.equals(nodeAt(i).element)){
            prevI = currI;
            currI = currI.next;
        }

        LinkedNode prevJ = null, currJ = header.next;
        while (currJ != null && !currJ.element.equals(nodeAt(j).element)){
            prevJ = currJ;
            currJ = currJ.next;
        }

        if (currI == null || currJ == null) return;

//        if previous i is header
        if (prevI != null) prevI.next = currJ;
        else header.next = currJ;
//        if previous j is header
        if (prevJ != null) prevJ.next = currI;
        else header.next = currI;

//        Swap next pointers
//        1 2 3 4 5
//        1 4 3 2 5
        LinkedNode temp = currI.next;
        currI.next = currJ.next;
        currJ.next = temp;
    }

    public void reverse(){
        for (int i=0; i<this.size/2; i++){
            this.swap(i, size-i-1);
        }
    }

    public void removeRange(int i, int j){
        for (int k=0; k<j-i; k++){
            int index = 0;
            this.remove(i+index);
            index++;
        }
    }

//    Additional method
    public void printAll(){
        LinkedNode p = header.next;
        while (p != null) {
            System.out.print(p.element+" ");
            p = p.next;
        }
    }
}