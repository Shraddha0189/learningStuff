import java.util.Arrays;

public class KnapsackProble_zeroOne {

    int[][] temp = new int[4][51];

    public KnapsackProble_zeroOne() {
        for (int[] row : temp)
            Arrays.fill(row, -1);
    }

    int knapsack(int[] wt, int[] val, int revisedWt, int size) {

        // First try to define the base condition
        if (revisedWt == 0 || size == 0)
            return 0;

        if (temp[size][revisedWt] != -1)
            return temp[size][revisedWt];

        if (wt[size - 1] <= revisedWt) {
            temp[size][revisedWt] = Math.max(val[size - 1] + knapsack(wt, val, revisedWt - wt[size - 1], size - 1),
                    knapsack(wt, val, revisedWt, size - 1));
            return temp[size][revisedWt];
        }

        temp[size][revisedWt] = knapsack(wt, val, revisedWt, size - 1);
        return temp[size][revisedWt];
    }

    public static void main(String[] args) {

        // create a weight array:
        int[] weight = { 10, 20, 30 };
        int[] value = { 60, 100, 120 };
        int W = 50;
        int size = value.length;
        // lets do 0/1 knapsack problem
        KnapsackProble_zeroOne kp = new KnapsackProble_zeroOne();
        int maxProfit = kp.knapsack(weight, value, W, size);
        System.out.println("Maximum profit is : " + maxProfit);

        // Now lets try to memoize the code so that we dont recompute the instaructions.
        // By storing the values in an array we can utilise the the memory more
        // efficiently and reduce the code complexity
    }

}
