class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = index in word1 from where
        // word2[j...] can be matched as a subsequence
        int[] last = new int[m];
        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        // Find positions for word2 from the right
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We can use at most ONE mismatch
        boolean changed = false;

        j = 0;

        for (i = 0; i < n; i++) {

            if (j == m) {
                break;
            }

            // Normal matching character
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }
            // Use our one allowed mismatch
            else if (!changed &&
                    (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;
                changed = true;
            }
        }

        // Could not construct the whole sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}