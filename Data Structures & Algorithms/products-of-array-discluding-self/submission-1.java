class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int totalProduct = 1;
        int zeroes = 0;
        for( int num:nums){
            if(num!=0){
                totalProduct*=num;
            }
            else if(num==0){
                zeroes++;
                if(zeroes>1){
                   int[] arr = new int[nums.length];
                    Arrays.fill(arr, 0); 
                    return arr;
                }
                else{
                    totalProduct*=1;
                }
            }
        }
        for( int i=0;i<nums.length;i++){
            if(zeroes>0){
                if(nums[i]!=0){
                     product[i]=0;
                }
                else{
                    product[i]=totalProduct;
                }
            }
            else{
                if(nums[i]!=0){
                product[i]=totalProduct/nums[i];
            }
            else product[i]=totalProduct;
            }
            
            
        }
        return product;
    }
}  
