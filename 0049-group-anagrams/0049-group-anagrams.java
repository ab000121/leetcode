class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String , List<String>> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!hm.containsKey(key)){
                hm.put(key , new ArrayList<>());
            }
            hm.get(key).add(str);
        }

        for(List<String> grp : hm.values()){
            res.add(grp);
        }
        return res;
    }
}