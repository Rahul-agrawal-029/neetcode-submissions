class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        int count = 0;
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        for(int i:nums){
            System.out.print(i);
        }
        
        for (int i = 0; i< nums.length - 1 ; i++){
            if(nums[i+1]-nums[i]!=1 && nums[i+1]-nums[i]!=0){
                System.out.print("max" + max);
                max=Math.max(max,count+1);
                count=0;
            }
            else if(nums[i+1]-nums[i]==1){
                System.out.print("count" + count);
                count++;
            }
            else if(nums[i+1]-nums[i]==0){
                continue;
            }
    
        }   
   return max=Math.max(max,count+1);
    }
}
