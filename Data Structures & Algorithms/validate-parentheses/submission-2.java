class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();

        for( char c:charArray){
            if(isOpenBracket(c)){
                stack.push(c);
            }
            else if (isClosedBracket(c) && stack.isEmpty()){
                return false;
            }
            else if((isClosedBracket(c) && !isComplimentary(stack.pop(),c))){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public boolean isOpenBracket(char c){
        if(c == '{' || c == '[' || c == '('){
            return true;
        }
        return false;
    }

    public boolean isClosedBracket(char c){
        if(c == '}' || c == ']' || c == ')'){
            return true;
        }
        return false;
    }
    public boolean isComplimentary(char c1,char c2){
        if( c1=='{' && c2== '}' || c1=='[' && c2== ']' || c1=='(' && c2== ')' ){
            return true;
        }
        return false;
    }
}
