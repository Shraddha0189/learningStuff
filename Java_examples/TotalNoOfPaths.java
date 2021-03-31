public class TotalNoOfPaths {

    static int totalWays(int n, int m) {

        if (n == 1 || m == 1)
            return 1;

        return totalWays(n, m - 1) + totalWays(n - 1, m);

    }

    public static void main(String[] args) {
        // Find the no of paths in a n*m matrix to reach from start to end
        // Lets say that we reach the last column of the matrix somehow, then there is
        // just 1 way to reach th end ot
        // if we reach the last row of the matrix then there is one way to reach the
        // end.
        // define a matrix of nxm
        int n = 4, m = 4;
        int noOfWays = TotalNoOfPaths.totalWays(n, m);
        System.out.println("Total number of ways to reach from start to end are: " + noOfWays);
    }

}
