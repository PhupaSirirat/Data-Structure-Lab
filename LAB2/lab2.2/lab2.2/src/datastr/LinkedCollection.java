package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

import javax.xml.stream.FactoryConfigurationError;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;

public class LinkedCollection implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
    private LinkedNode header = new LinkedNode(null, null);
    private int size;

    public LinkedCollection() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object e) {
        header.next = new LinkedNode(e, header.next);
        ++size;
    }
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while( node != null ) {
            if (node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while( p.next != null &&
                ! p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next; --size;
        }
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }

//     Lab2.2
    public boolean equals(Object e){
        if (e.getClass().equals(this.getClass())){
            LinkedNode node = header.next;
            if (((LinkedCollection) e).size != this.size) return false;
            while( node!=null){
                if (((LinkedCollection) e).contains(node.element)) node = node.next;
                else {return false;}
            } return true;
        } return false;
    }

    public boolean containsDup(){
        LinkedCollection tester = new LinkedCollection();
        LinkedNode node = header.next;

        while ( node != null){
            if (!tester.contains(node.element)) tester.add(node.element);
            else return true;
            node = node.next;
        } return false;
    }

    public void removeDup(){
        while(this.containsDup()){
            this.remove(this.getDup());
        }
    }

    public void removeAll(Object e){
        LinkedNode node = header.next;
        while ( node != null){
            if (((LinkedCollection) e).contains(node.element)) this.remove(node.element);
            node = node.next;
        }
    }

//    Additional method
    private Object getDup(){
        LinkedCollection tester = new LinkedCollection();
        LinkedNode node = header.next;
        while( node != null){
            if (tester.contains(node.element)) return node.element;
            else {
                tester.add(node.element);
                node = node.next;
            }
        } return null;
    }

    public void printAll(){
        LinkedNode node = header.next;
        for (int i=0; i<this.size; i++){
            System.out.println(node.element);
            node = node.next;
        }
    }
}
