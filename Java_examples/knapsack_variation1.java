//Find if the sum of subsets of given array is equal to K

public class knapsack_variation1 {

    boolean[][] temp = new boolean[6][11];

    public knapsack_variation1() {

        // initialise the dp array with the minimal conditions possible
        for (int i = 0, j = 0; i < 6; i++) {
            temp[i][j] = true;
        }

        for (int j = 1, i = 0; j < 11; j++) {
            temp[i][j] = false;
        }

    }

    boolean subsetSum(int[] array, int revisedSum, int size) {

        if (revisedSum == 0) {
            return true;

        }

        if (revisedSum > 0 && size == 0)
            return false;

        if (temp[size][revisedSum])
            return temp[size][revisedSum];

        if (array[size - 1] <= revisedSum) {
            temp[size][revisedSum] = subsetSum(array, revisedSum - array[size - 1], size - 1)
                    || subsetSum(array, revisedSum, size - 1);
            return temp[size][revisedSum];
        }

        temp[size][revisedSum] = subsetSum(array, revisedSum, size - 1);
        return temp[size][revisedSum];

    }

    public static void main(String[] args) {

        int[] array = { 2, 3, 5, 8, 10 };
        int size = array.length;
        int sum = 10;
        knapsack_variation1 kp = new knapsack_variation1();
        // Return true if subset sum is equal to Sum else return false
        boolean subsetSumPresent = kp.subsetSum(array, sum, size);
        System.out.println("Answer: " + subsetSumPresent);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(kp.temp[i][j] + " ");
            }
            System.out.println();
        }

    }

}
