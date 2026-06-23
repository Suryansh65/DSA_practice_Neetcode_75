class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board.length;
        HashSet<String>set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == '.')continue;
                String row = board[i][j] + "_ROW_" + i;
                String col = board[i][j] + "_COL_" + j;
                String box = board[i][j] + "_BOX_" + i/3 + "_" + j/3;
                if(set.contains(row) || set.contains(col) || set.contains(box)){
                    return false;
                }
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}
