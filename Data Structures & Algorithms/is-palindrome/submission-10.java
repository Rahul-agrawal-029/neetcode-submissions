class Solution {
    public boolean isPalindrome(String s) {
        int i =0;
        int j = s.length()-1;
        while(i<j){
            while(!Character.isLetterOrDigit(s.charAt(i)) && i<j){
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j)) && i<j){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }
            else {
                System.out.println("i="+s.charAt(i)+"j="+s.charAt(j));
                return false;
                }
                ;
        }
        return true;
    }
}
