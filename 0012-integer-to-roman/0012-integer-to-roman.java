class Solution {
    public String intToRoman(int num) {
        
        // special caseses 900 = CM, 400 = CD , 90 = XC, 40 = XL, 9 = IX, 4 = IV

        int values[] = {1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1};

        String roman[] = {"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};

        StringBuilder res = new StringBuilder();

        for(int i  = 0 ; i < values.length ; i++){
            while(num >= values[i]){
                res.append(roman[i]);
                num -= values[i];
            }
        }
        return res.toString();
    }
}