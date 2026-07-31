class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for( int i = 0; i < temperatures.length - 1; i++){
            int j = i;
            result[i]=0;
            while(temperatures[j]<=temperatures[i] && j<temperatures.length-1){
                j++;
            }
            if(temperatures[j]>temperatures[i]){
                result[i]=j-i;
            }
        }
        return result;
    }
}
