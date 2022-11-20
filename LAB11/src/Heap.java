public class Heap {
    public void buildHeap(int[] heapArray, int numNode) {
        int i;
        for (i=numNode/2; i>0; i--) {
            reHeap(heapArray, i, numNode);
        }
    }
    public void reHeap(int[] heapArray, int root, int numNode){
        int maxChild, tmp;
        boolean isHeap = false;
        while ((2*root <= numNode) && (!isHeap)){
            if (2*root == numNode) maxChild = 2*root;
            else {
                if (heapArray[2*root] > heapArray[2*root+1]) maxChild = 2*root;
                else maxChild = 2*root+1;
            }

            if(heapArray[root] < heapArray[maxChild]){
                tmp = heapArray[root];
                heapArray[root] = heapArray[maxChild];
                heapArray[maxChild] = tmp;
                root = maxChild;
            }
            else isHeap = true;
        }
    }
    public void printHeap(int[] heapArray, int numNode){
        for (int i=1; i<=numNode; i++){
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
}
