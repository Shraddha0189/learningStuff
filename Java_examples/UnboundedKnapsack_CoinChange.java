import java.util.Arrays;

public class UnboundedKnapsack_CoinChange {

    int[][] temp = new int[6][11];
    int count = 0;

    public UnboundedKnapsack_CoinChange() {
        for (int[] row : temp)
            Arrays.fill(row, -1);

        // initialise the dp array with the minimal conditions possible
        for (int i = 0, j = 0; i < 6; i++) {
            temp[i][j] = 1;
        }

        for (int j = 1, i = 0; j < 11; j++) {
            temp[i][j] = 0;
        }

    }

    int countSubsetSum(int[] array, int revisedSum, int size) {

        if (revisedSum == 0) {
            return 1;
        }

        if (revisedSum > 0 && size == 0)
            return 0;

        if (temp[size][revisedSum] != -1)
            return temp[size][revisedSum];

        if (array[size - 1] <= revisedSum) {

            temp[size][revisedSum] = countSubsetSum(array, revisedSum - array[size - 1], size)
                    + countSubsetSum(array, revisedSum, size - 1);
            return temp[size][revisedSum];
        }

        temp[size][revisedSum] = countSubsetSum(array, revisedSum, size - 1);
        return temp[size][revisedSum];

    }

    public static void main(String[] args) {

        int[] array = { 1, 2, 3 };
        int size = array.length;
        int sum = 5;
        UnboundedKnapsack_CoinChange kp = new UnboundedKnapsack_CoinChange();
        // Return true if subset sum is equal to Sum else return false
        int totalcount = kp.countSubsetSum(array, sum, size);
        System.out.println("Answer: " + totalcount);
    }

}
