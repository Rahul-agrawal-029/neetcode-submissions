class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
    int[] s2count = new int[26];

    int start = 0;
    for(char c:s1.toCharArray()){
        s1count[c-'a']++;
    }


    for(int i=0;i<s2.length();i++){
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


// Optimised:
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int[] s1count = new int[26];
//         int[] s2count = new int[26];

//         int start = 0;
//         for(char c : s1.toCharArray()){
//             s1count[c-'a']++;
//         }

//         for(int i = 0; i < s2.length(); i++){
//             char c = s2.charAt(i);
//             s2count[c-'a']++;

//             // 1. Uncomment the while loop and decrement the character at 'start'
//             while(s2count[c-'a'] > s1count[c-'a']){
//                 s2count[s2.charAt(start) - 'a']--;
//                 start++;
//             }
            
//             // 2. Check for the match AFTER the while loop fixes the window
//             if(Arrays.equals(s1count, s2count)){
//                 return true;
//             }
//         }

//         return false; 
//     }
// }

//fastest
// public class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) {
//             return false;
//         }

//         int[] s1Count = new int[26];
//         int[] s2Count = new int[26];
//         for (int i = 0; i < s1.length(); i++) {
//             s1Count[s1.charAt(i) - 'a']++;
//             s2Count[s2.charAt(i) - 'a']++;
//         }

//         int matches = 0;
//         for (int i = 0; i < 26; i++) {
//             if (s1Count[i] == s2Count[i]) {
//                 matches++;
//             }
//         }

//         int l = 0;
//         for (int r = s1.length(); r < s2.length(); r++) {
//             if (matches == 26) {
//                 return true;
//             }

//             int index = s2.charAt(r) - 'a';
//             s2Count[index]++;
//             if (s1Count[index] == s2Count[index]) {
//                 matches++;
//             } else if (s1Count[index] + 1 == s2Count[index]) {
//                 matches--;
//             }

//             index = s2.charAt(l) - 'a';
//             s2Count[index]--;
//             if (s1Count[index] == s2Count[index]) {
//                 matches++;
//             } else if (s1Count[index] - 1 == s2Count[index]) {
//                 matches--;
//             }
//             l++;
//         }
//         return matches == 26;
//     }
// }