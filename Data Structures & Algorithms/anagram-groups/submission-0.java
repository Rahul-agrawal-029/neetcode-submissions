class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Need to parse the array, sort the strings and then put it in map of string list of strings
        Map<String, List<String>> map = new HashMap();
        for (String s:strs) {
        //    if( map.get(Collection.sort(s)) ){
        //     map.put(Collection.sort(s),s);
        //    }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        String sortedString = new String(array);
           if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList());
            }
            map.get(sortedString).add(s); 
        }
        return new ArrayList(map.values());
    }
}
