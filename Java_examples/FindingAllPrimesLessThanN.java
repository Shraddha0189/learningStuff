//Implementing Sieve's algorithm to find all primes less than N

class FindingAllPrimesLessThanN {

    void FindAllPrimes(int N) {

        /*
         * create an array marked all true. Than as we iterate will mak the composite
         * nos as false and in the end we return the array with all true elements
         */

        // initialise an array with true values
        Boolean[] isPrime = new Boolean[N + 1];
        for (int i = 0; i < N; i++)
            isPrime[i] = true;

        for (int p = 2; p * p < N; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < N; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i < N; i++) {
            if (isPrime[i])
                System.out.println(i);
        }

    }

    public static void main(String[] args) {
        FindingAllPrimesLessThanN fp = new FindingAllPrimesLessThanN();
        fp.FindAllPrimes(50);
    }

}