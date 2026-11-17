class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int srow = 0, erow = matrix.length - 1;
        int scol = 0, ecol = matrix[0].length - 1;

        while(scol <= ecol && srow <= erow){

            for(int i = scol; i <= ecol; i++)
                ans.add(matrix[srow][i]);


            for(int j = srow+1; j <= erow; j++)
                ans.add(matrix[j][ecol]);


            for(int i = ecol-1; i >= scol; i--){
                if(srow == erow) break;

               ans.add(matrix[erow][i]);
            }


            for(int j = erow-1; j >= srow+1; j--){
                if(scol == ecol) break;

               ans.add(matrix[j][scol]);
            }

            srow++; erow--;
            scol++; ecol--;
        }

        return ans;
    }
}