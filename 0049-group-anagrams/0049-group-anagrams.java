class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> hm = new HashMap<>();

        for(String str : strs){
            char []Char = str.toCharArray();
            Arrays.sort(Char);
            String temp = new String(Char);

            if(!hm.containsKey(temp)){
                hm.put(temp , new ArrayList<>());
            }
            
            hm.get(temp).add(str);
        }

        for(List<String> vals : hm.values()){
            ans.add(vals);
        }

        return ans;
    }
}