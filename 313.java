class Solution {
    public int nthSuperUglyNumber(int n, int [] primes) {
        if (n < 1 || primes == null || primes.length == 0) {
            return 0;
        }

        List<Double> list = new ArrayList<>();
        list.add(1.0);

        int [] idx = new int [primes.length];

        while (list.size() < n) {
            double min = Double.POSITIVE_INFINITY;

            for (int i = 0;i < primes.length;i++) {
                min = Math.min(min, list.get(idx[i]) * primes[i]);
            }

            list.add(min);

            for (int i = 0;i < primes.length;i++) {
                if (list.get(idx[i]) * primes[i] == min) {
                    idx[i]++;
                }
            }
        }

        return (int) list.get(n - 1).doubleValue();
    }
}
