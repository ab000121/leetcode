class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) curr.add(1);

                else{
                    List<Integer> prev = res.get(res.size() - 1);
                    curr.add(prev.get(j) + prev.get(j-1));
                }
            }
            res.add(curr);
        }
        return res;
    }
}