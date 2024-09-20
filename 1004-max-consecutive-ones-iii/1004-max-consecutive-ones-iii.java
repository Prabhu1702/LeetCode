class Solution {
    public int longestOnes(int[] nums, int k) {
       int right=0,left=0,max=0,zero=0;

       while(right<nums.length){
        if(nums[right]==0){
            zero++;
        }
        while(zero>k){
            if(nums[left]==0){
                zero--;
            }
            left++;
        }
        if(zero<=k){
        max=Math.max(max,right-left+1);
        }
        right++;
       }
       return max;
    }
}