class Solution {
    public String minWindow(String s, String t) {
        
        // char[] tcount = new char[256];

        if(t.length()>s.length()){
            return "";
        }
        if(s.equals(t)){
            return s;
        }
        HashMap<Character,Integer> tMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> sMap = new HashMap<Character,Integer>();

        for(int i = 0; i<t.length(); i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0;
        int minIndex=0;
        int minLength=Integer.MAX_VALUE;
        for(int right = 0; right < s.length() ; right++){
            sMap.put(s.charAt(right),sMap.getOrDefault(s.charAt(right),0)+1);
            if(!sMap.keySet().containsAll(tMap.keySet())){
                 continue;
            }
            else{
               // Shrink till window is valid
               while(isValid(sMap,tMap)){
                // sMap.get(s.charAt(left))--;
                if(right-left+1<minLength){
                    minIndex=left;
                    minLength=right-left+1;
                }
                sMap.put(s.charAt(left),sMap.get(s.charAt(left))-1);
                left++;
               }
            }
        }
        if(minLength==Integer.MAX_VALUE){
            return "";
        }
        

        return s.substring(minIndex,minIndex+minLength);
    }
    // NEW: A small helper method to properly check frequencies instead of just keys
    private boolean isValid(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        for (Character k : tMap.keySet()) {
            // If sMap doesn't have the character at all, or doesn't have enough of it, return false
            if (sMap.getOrDefault(k, 0) < tMap.get(k)) {
                return false;
            }
        }
        return true;
    }
}
