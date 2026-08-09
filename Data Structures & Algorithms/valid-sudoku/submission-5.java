class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashMap<Integer,Hashset<Character> map = new Hashmap<Integer,HashSet<Character>>();
        HashMap<Integer,HashSet<Character>> mapRow = new HashMap<Integer,HashSet<Character>>();
        HashMap<Integer,HashSet<Character>> mapColumn = new HashMap<Integer,HashSet<Character>>();
        HashMap<List<Integer>,HashSet<Character>> mapBlock = new HashMap<List<Integer>,HashSet<Character>>();

        for( int i = 0; i<9 ; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                
                if(mapRow.get(i)==null){
                    mapRow.put(i,new HashSet<Character>());
                }
                if(mapColumn.get(j)==null){
                    mapColumn.put(j,new HashSet<Character>());
                }
                if(mapBlock.get(List.of((int) Math.floor(i/3),(int) Math.floor(j/3)))==null){
                    mapBlock.put(List.of((int) Math.floor(i/3),(int) Math.floor(j/3)),new HashSet<Character>());
                }
                HashSet tempRow = mapRow.get(i) ;
                HashSet tempColumn = mapColumn.get(j);
                HashSet tempBlock = mapBlock.get(List.of((int) Math.floor(i/3),(int) Math.floor(j/3)));

                if(tempRow.contains(board[i][j]) || tempColumn.contains(board[i][j]) || tempBlock.contains(board[i][j])){
                    //  System.out.println(value);
                    //   System.out.println(tempRow);
                    //    System.out.println(tempColumn);
                    //     System.out.println(tempBlock);
                    // System.out.println(mapRow);
                    // System.out.println(mapColumn);
                    // System.out.println(mapBlock);
                    
                    return false;
                }
                tempRow.add(board[i][j]);
                tempColumn.add(board[i][j]);
                tempBlock.add(board[i][j]);
            }
        }
        return true;
    }
}


//Most Optimised Solution:
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         boolean[][] rows = new boolean[9][9];
//         boolean[][] cols = new boolean[9][9];
//         boolean[][] boxes = new boolean[9][9];

//         for(int i = 0; i < 9; i++) {
//             for(int j = 0 ; j < 9; j++) {
//                 char c = board[i][j];
//                 if (c == '.') {
//                     continue;
//                 }

//                 int digit = c -'1'; // maps to 0 - 8
//                 int boxIndex = (i/3)*3 + (j/3);

//                 if(rows[i][digit] || cols[j][digit] || boxes[boxIndex][digit]) {
//                     return false;
//                 }
//                 rows[i][digit]=true;
//                 cols[j][digit]= true;
//                 boxes[boxIndex][digit] = true;
//             }
//         }

//         return true;
//     }
       
// }