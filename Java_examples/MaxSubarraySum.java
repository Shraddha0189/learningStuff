//Implementing maximum sum subarray using Kandane's algorithm

public class MaxSubarraySum {

    int A[] = { 4, -2, 1, 0, 5, -6 };

    int MaxSum() {

        int local_max = 0;
        int global_max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            local_max = Math.max(A[i], A[i] + local_max);
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }

    public static void main(String[] args) {
        // System.out.println("print A: " + A);
        // calling the maximum sum subarray
        MaxSubarraySum mb = new MaxSubarraySum();
        int maxSum = mb.MaxSum();
        System.out.println("The max sum is : " + maxSum);
    }

}
