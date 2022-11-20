public class Main {
    public static void main(String[] args) {
        int[] a = {0,   20,9,32,6,15,25,50,5,8,13,18};
        int numNode = a.length-1;
        Heap h = new Heap();
        System.out.print("Data Array: ");
        h.printHeap(a, numNode);
        h.buildHeap(a, numNode);
        System.out.print("Heap Array: ");
        h.printHeap(a, numNode);
    }
}
