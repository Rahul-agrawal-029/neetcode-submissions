class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int max = 0;
        int[] charCount = new int[26];
        int maxFreq = 0;
        
        for(int high = 0; high<s.length();high++ ){
            charCount[s.charAt(high)-'A']++;

            maxFreq = Math.max(maxFreq, charCount[s.charAt(high)-'A']);

            int window = high - low +1;
            if(window-maxFreq>k){
                charCount[s.charAt(low) -'A']--;
                low++;
            }
            max = Math.max(max, high - low +1);
        }
        return max;
    }
}
