class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l =0;
        int r = heights.length-1;

        while(l<r){
            maxArea= Math.max(calculateArea((r-l),Math.min(heights[l],heights[r])),maxArea);
            if(heights[l]>=heights[r]){
                r--;
            }
            else l++;
        }
        return maxArea;
    }

    public int calculateArea(int i , int j){
        return i*j;
    }
}
