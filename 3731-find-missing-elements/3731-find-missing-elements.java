class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(max , num);
            min = Math.min(min , num);

            arr.add(num);
        }

        for(int i = min ; i <= max; i++){
            if(!arr.contains(i)) res.add(i);
        }

        return res;
    }
}