class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        System.out.println(nums);
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int low = i+1;
            int high = nums.length - 1;
            while(low<high){
            if(-nums[i]<nums[low]+nums[high]){
                high--;
            }
            else if(-nums[i]>nums[low]+nums[high]){
                low++;
            }    
            else if(-nums[i]== nums[low] + nums[high]){
                result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                while(low<high && nums[low]==nums[low+1]) low++;
                while(low<high && nums[high]==nums[high-1]) high--;
                
                low++;
                high--;
            }
            }
        }
        System.out.println(result);
        return result;
    }
}
