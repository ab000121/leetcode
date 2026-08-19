class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> hm = new HashMap<>();

        for(int[] seat : reservedSeats){
           if(!hm.containsKey(seat[0])){
            hm.put(seat[0],new HashSet<>());
           }

           hm.get(seat[0]).add(seat[1]);
        }

        int ans = 2 *(n - hm.size());
        for(Set<Integer>seats : hm.values()){
            boolean left = true;  //2,3,4,5
            boolean middle = true;  // 4,5,6,7
            boolean right = true; //6,7,8,9

            for(int seat : seats){
                if(seat >= 2 && seat <= 5) left = false;
                if(seat >= 4 && seat <=7) middle = false;
                if(seat >= 6 && seat <= 9) right = false;
            }

            if(left && right) ans += 2;
            else if(left || middle || right) ans += 1;
        }

        return ans;
    }
}