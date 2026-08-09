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
                int blockRow = (int) Math.floor(i/3);
                int blockColumn = (int) Math.floor(j/3);
                if(mapRow.get(i)==null){
                    mapRow.put(i,new HashSet<Character>());
                }
                if(mapColumn.get(j)==null){
                    mapColumn.put(j,new HashSet<Character>());
                }
                if(mapBlock.get(List.of(blockRow,blockColumn))==null){
                    mapBlock.put(List.of(blockRow,blockColumn),new HashSet<Character>());
                }
                HashSet tempRow = mapRow.get(i) ;
                HashSet tempColumn = mapColumn.get(j);
                HashSet tempBlock = mapBlock.get(List.of(blockRow,blockColumn));
                char value = board[i][j];
                if(tempRow.contains(value) || tempColumn.contains(value) || tempBlock.contains(value)){
                    //  System.out.println(value);
                    //   System.out.println(tempRow);
                    //    System.out.println(tempColumn);
                    //     System.out.println(tempBlock);
                    // System.out.println(mapRow);
                    // System.out.println(mapColumn);
                    // System.out.println(mapBlock);
                    
                    return false;
                }
                tempRow.add(value);
                tempColumn.add(value);
                tempBlock.add(value);
            }
        }
        return true;
    }
}
