//approach similar as fibonacci

public class CountOfBinaryStringWithNoConsecutiveOnes {

    static int fib(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static int CountStrings(int N) {
        /*
         * if N ==2 .. a. First is 0 and scond can be anything 0/1 (this is similar to
         * the same problem with size n-1) So technically we have reduced the problem to
         * size N-1 b. If first is 0 then, since we cant have 2 consecutive 1's the
         * second should be 0. and rest can be anything. Again, the problem is now
         * reduced to size N-2 Hence we can find a relation between them. Count(N) =
         * COunt(n-1) + Count(N-2). if youll see clearly this is similar to the Fiboacci
         * sequence
         */

        return fib(N + 2);

    }

    public static void main(String[] args) {
        int N = 3;
        int toalNoOfStrings = CountOfBinaryStringWithNoConsecutiveOnes.CountStrings(N);
        System.out.println("Total no of strings that can be formed are: " + toalNoOfStrings);
    }

}
