public class Main {

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] arr = {10, 7, 8, 9, 11, 6, 1, 5};
        int n = arr.length;

        sorter.quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
