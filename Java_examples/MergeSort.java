//to be fixed yet
public class MergeSort {

    void sort(int[] arr, int low, int high) {

        int mid = (low + high) / 2;
        if (low < high) {

            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);

        }
    }

    void merge(int[] arr, int low, int mid, int high) {
        // int[] sortedarray = new int[arr.length];
        int lsize = mid - low + 1;
        int rsize = high - mid;
        int[] leftarr = new int[mid - low + 1];
        int[] rightarr = new int[high - mid];

        for (int i = 0; i < lsize; i++) {
            leftarr[i] = arr[i];
        }

        for (int i = mid; i < rsize; i++) {
            rightarr[i] = arr[low + mid + 1];
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftarr.length && j < rightarr.length) {

            if (leftarr[i] < rightarr[j]) {
                arr[k] = leftarr[i];
                i = i + 1;
            } else {
                arr[k] = leftarr[i];
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < leftarr.length) {
            arr[k] = leftarr[i];
            i++;
            k++;
        }

        while (j < rightarr.length) {
            arr[k] = rightarr[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        int A[] = { 5, 3, 12, 67, 21, 1, 9 };
        int low = 0;
        int high = A.length - 1;

        MergeSort ms = new MergeSort();
        ms.sort(A, low, high);

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }

    }

}
