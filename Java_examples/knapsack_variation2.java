import java.util.Arrays;

public class knapsack_variation2 {

    int[][] temp = new int[6][11];
    int count = 0;

    public knapsack_variation2() {
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

            temp[size][revisedSum] = countSubsetSum(array, revisedSum - array[size - 1], size - 1)
                    + countSubsetSum(array, revisedSum, size - 1);
            System.out.println("s " + size + " rs " + revisedSum + temp[size][revisedSum]);
            return temp[size][revisedSum];
        }

        temp[size][revisedSum] = countSubsetSum(array, revisedSum, size - 1);
        return temp[size][revisedSum];

    }

    public static void main(String[] args) {

        int[] array = { 2, 3, 5, 8, 10 };
        int size = array.length;
        int sum = 10;
        knapsack_variation2 kp = new knapsack_variation2();
        // Return true if subset sum is equal to Sum else return false
        int totalcount = kp.countSubsetSum(array, sum, size);
        System.out.println("Answer: " + totalcount);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(kp.temp[i][j] + " ");
            }
            System.out.println();
        }

    }

}
