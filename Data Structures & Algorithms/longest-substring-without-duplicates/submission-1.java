class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int maxSize = 0;
        char[] arr = s.toCharArray();
        for( int i = 0; i < arr.length ; i++ ){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
            else {
                maxSize=Math.max(maxSize,map.size());
                i=map.get(arr[i]);
                map.clear();
            }
        }
        return Math.max(maxSize,map.size());
    }
}
