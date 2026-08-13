class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
    int[] s2count = new int[26];

    int start = 0;
    for(char c:s1.toCharArray()){
        s1count[c-'a']++;
    }


    for(int i=0;i<s2.length();i++){
        System.out.println(Arrays.toString(s2count));
        char c = s2.charAt(i);
        s2count[c-'a']++;
        

        if(s2count[c-'a']>s1count[c-'a']){
            while(s2count[c-'a']>s1count[c-'a'] && s2.length()-start>s1.length()){
                s2count[s2.charAt(start)-'a']--;
                start++;
            }
        }
        if(Arrays.equals(s1count, s2count)){
            return true;
        }
    }

    return false; // Placeholder return value
    }
}
