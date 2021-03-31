//Sliding window example 

public class MaximumSumSubarrayOfSizeK {

    public static int findMaxSum(int[] arr, int k, int size) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < size) {

            sum = sum + arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 2, 1, 3, 4, -1, 2, 8 };
        int size = arr.length;
        int maxSum = MaximumSumSubarrayOfSizeK.findMaxSum(arr, k, size);
        System.out.println("Max sum is : " + maxSum);
    }

}