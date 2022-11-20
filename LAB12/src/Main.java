public class Main {
    public static void main(String[] args) {
        int[] arr1 = {15, 9, 7, 16, 31, 2, 20, 25, 17, 12};
        QuickSort q = new QuickSort(arr1);
        q.printArray();

        int[] arr2 = {5, 2, 12, 9, 1, 8, 7, 18};
        MergeSort m = new MergeSort(arr2);
        m.printArray();
    }
}
