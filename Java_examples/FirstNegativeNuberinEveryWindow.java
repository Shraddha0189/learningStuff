import java.util.ArrayList;

//variation of sliding window
import java.util.*;

public class FirstNegativeNuberinEveryWindow {

    public static void findNegative(int[] arr, int size, int k, ArrayList<Integer> ans) {

        int i = 0, j = 0;
        Deque<Integer> temp = new ArrayDeque<Integer>(10);
        while (j < size) {

            if (arr[j] < 0) {
                // store address of the negaive numbers in this array
                temp.add(j);
                System.out.println("inside this " + arr[j]);
            }

            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                if (temp.isEmpty())
                    ans.add(0);
                else {
                    ans.add(arr[temp.getFirst()]);
                    if (i >= temp.getFirst()) {
                        // remove the address of the number which we for sure know that'll be never used
                        temp.removeFirst();
                    }
                }
                i++;
                j++;

            }

        }
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, -1, -4, 5, 6, 7 };
        int[] arr = { -8, 2, 3, -6, 10 };
        int size = arr.length;
        // int K = 3;
        int K = 2;

        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println("size " + size + " K " + K);
        FirstNegativeNuberinEveryWindow.findNegative(arr, size, K, ans);
        System.out.println(ans);
    }
}
