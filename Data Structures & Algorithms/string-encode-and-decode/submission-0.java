class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for( String s:strs){
            sb.append(s.length())
            .append("#")
            .append(s);
        }
        System.out.println(sb);
        return sb.toString();
    }

   public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;
    
    while (i < str.length()) {
        // 1. Find the index of the next '#' starting from our current position 'i'
        int hashIndex = str.indexOf('#', i);
        
        // 2. Extract the number part (from 'i' to the '#') and parse it into an integer
        int length = Integer.parseInt(str.substring(i, hashIndex));
        
        // 3. Calculate where the word starts and ends
        int wordStart = hashIndex + 1;
        int wordEnd = wordStart + length;
        
        // 4. Extract the exact word and add it to our list
        String word = str.substring(wordStart, wordEnd);
        result.add(word);
        
        // 5. Jump our pointer to the beginning of the next length prefix
        i = wordEnd;
    }
    
    return result;
}
}
