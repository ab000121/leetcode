class Solution {
    public int smallestNumber(int n, int t) {
        int temp = n;
        
        while(true){
            n = temp;
            int product = 1;
            while(n > 0){
                int rem = n % 10;
                product *= rem;
                n = n / 10;
            }

            if(product % t == 0) return temp;

            temp++;
        }

        
    }
}