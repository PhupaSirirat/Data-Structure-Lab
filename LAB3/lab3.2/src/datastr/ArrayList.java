package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
public class ArrayList implements List {
    private Object[] elementData;
    private int size;
    public ArrayList(int cap) {
        elementData = new Object[cap];
        size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void remove(Object e) {
        int i = indexOf(e);
        if (i >= 0) remove(i);
    }
    public Object get(int index) {
        return elementData[index];
    }
    public void set(int index, Object e) {
        elementData[index] = e;
    }
    public void add(int index, Object e) {
        ensureCapacity(size+1);
        for(int i=size; i>index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        size++;
    }
    public void remove(int index) {
        for(int i=index+1; i<size; i++) {
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
    }
    public int indexOf(Object e) {
        for(int i=0; i<size; i++)
            if (elementData[i].equals(e)) return i;
        return -1;
    }
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr = new Object[s];
            for(int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = elementData[i];
        }
        return a;
    }

//    lab 3
    public void swap(int i, int j){
//        old i = i
//        new i = j
//        new j = old i
        Object old_i = this.get(i);
        this.set( i, this.get(j));
        this.set( j, old_i);
    }

    public void reverse(){
        for (int i=0; i<size/2; i++){
            this.swap(i, size-i-1);
        }
    }

    public void removeRange(int i, int j){
        for (int k=0; k<j-i; k++){
            int index = i;
            this.remove(this.get(i));
            index++;
        }
    }


//    Additional method
    public void printAll(){
        for (int i=0; i<this.size; i++){
            System.out.print(this.get(i)+" ");
        }
    }
}
