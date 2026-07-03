class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();

        getAllParts(s , new ArrayList<>() , res);
        return res;
    }

    public boolean isPalindrome(String str){
        int l = 0, r = str.length() - 1;

        while(l<r){
            if(str.charAt(l) != str.charAt(r)) return false;

            l++; r--;
        }
        return true;
    }

    public void getAllParts(String s , List<String> partitions , List<List<String>> res){
        if(s.length() == 0){
            res.add(new ArrayList<>(partitions));
            return;
        }

        for(int i = 0 ; i < s.length() ; i++){
            String parts = s.substring(0 , i+1);
            if(isPalindrome(parts)){
                partitions.add(parts);
                getAllParts(s.substring(i+1) , partitions , res);
                partitions.remove(partitions.size() - 1);
            }
        }
    }
}