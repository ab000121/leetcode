

class Solution {

    public long findKthSmallest(int[] coins, int k) {

        int n = coins.length;

        long low = 1;
        long high = (long) Arrays.stream(coins).min().getAsInt() * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long result = 0;

        // Try every subset of coins
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            boolean tooLarge = false;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    // No number <= x can be divisible by this LCM
                    if (lcm > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) {
                continue;
            }

            long current = x / lcm;

            // Odd number of elements → add
            // Even number of elements → subtract
            if (bits % 2 == 1) {
                result += current;
            } else {
                result -= current;
            }
        }

        return result;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}